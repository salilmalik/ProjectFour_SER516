package server.controller;

import com.google.gson.Gson;
import server.constants.ServerConstants;
import server.listener.LogListenerInterface;
import server.model.ServerModelSingleton;
import server.services.DetectionListenerService;

import javax.swing.*;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * The ServerSocketEndpoint class establishes connection threads for clock
 * setting with client.
 * 
 * @author Team 06
 * @version 1.0
 */
@ServerEndpoint("/server")
public class ServerSocketEndpoint {

	public static Queue<Session> queue = new ConcurrentLinkedQueue<Session>();
	private static Gson gson = new Gson();
	private static Thread rateThread;
	private static LogListenerInterface logListener;
	private static DetectionListenerService detectionListenerService;

	/**
	 * Spawns a thread for running server
	 */
	static {
		rateThread = new Thread() {
			public void run() {
				while (true) {
					if (queue != null) {
						if (ServerModelSingleton.getInstance().isAutoReset()) {
							sendAndUpdateCounter();
						}
						if (ServerModelSingleton.getInstance().isOneTimeSend()) {
							sendAndUpdateCounter();
							ServerModelSingleton.getInstance().setOneTimeSend(false);
						}
						try {
							Double clock = ServerModelSingleton.getInstance().getStateInterval();
							Long sleepValue = (long) (clock * 1000);
							sleep(sleepValue);
						} catch (InterruptedException e) {
						}
					}
				}
			}

			/**
			 * Sends data to console log,parses json and change counter
			 */
			private void sendAndUpdateCounter() {
				double interval = ServerModelSingleton.getInstance().getStateInterval();
				double counter = ServerModelSingleton.getInstance().getData().getCounter();
				double newCounter = counter + interval;
				ServerModelSingleton.getInstance().getData().setCounter(newCounter);
				String data = gson.toJson(ServerModelSingleton.getInstance().getData());
				logListener.logMessage(data);
				detectionListenerService.changeCounter(newCounter);
				sendAll(data);
				if (ServerModelSingleton.getInstance().getData().getFaceData().getExpressiveData().isAutoReset()) {
					ServerModelSingleton.getInstance().getData().getFaceData().getExpressiveData().setAutoReset(false);
					ServerModelSingleton.getInstance().getData().getFaceData().getExpressiveData().resetValues();
					detectionListenerService.disableActive();
				}
			}
		};
		rateThread.start();
	}

	/**
	 * Sends data to all open WebSocket sessions
	 * 
	 * @param msg
	 */
	private static void sendAll(String msg) {
		try {
			ArrayList<Session> closedSessions = new ArrayList<>();
			for (Session session : queue) {
				if (!session.isOpen()) {
					System.err.println("Closed session: " + session.getId());
					closedSessions.add(session);
				} else {
					session.getBasicRemote().sendText(msg);
				}
			}
			queue.removeAll(closedSessions);
			logListener.logMessage("Sending " + msg + " to " + queue.size() + " clients");
		} catch (Throwable e) {
			JOptionPane.showMessageDialog(null, ServerConstants.SEND_EXCEPTION_MESSAGE);
		}
	}

	/**
	 * Sets the log listener so that message can be passed to console panel
	 * 
	 * @param logListenerObject
	 */
	public static void setLogListener(LogListenerInterface logListenerObject) {
		logListener = logListenerObject;
	}

	/**
	 * Sets the detection listener so that message can be passes to the detection
	 * panel
	 * 
	 * @param detectionListenerServiceObject
	 */
	public static void setDetectionListenerService(DetectionListenerService detectionListenerServiceObject) {
		detectionListenerService = detectionListenerServiceObject;
	}

	/**
	 * provided for completeness, in out scenario clients don't send any msg.
	 * 
	 * @param session
	 * @param msg
	 */
	@OnMessage
	public void onMessage(Session session, String msg) {
		try {
			logListener.logMessage("received msg " + msg + " from " + session.getId());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, ServerConstants.RECEIVE_EXCEPTION_MESSAGE);
		}
	}

	/**
	 * When session is opened sends log to console panel and add session to a queue.
	 * 
	 * @param session
	 */
	@OnOpen
	public void open(Session session) {
		queue.add(session);
		logListener.logMessage(ServerConstants.NEW_SESSION_OPENED + session.getId());

	}

	/**
	 * When an error is occured sends message to log
	 * 
	 * @param session
	 * @param t
	 */
	@OnError
	public void error(Session session, Throwable t) {
		queue.remove(session);
		logListener.logMessage("Error on session " + session.getId());
	}

	/**
	 * When session closes the session is remvoved from the queue and logged
	 * 
	 * @param session
	 */
	@OnClose
	public void closedConnection(Session session) {
		queue.remove(session);
		logListener.logMessage("session closed: " + session.getId());
	}
}