package server.controller;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.swing.JOptionPane;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.google.gson.Gson;

import server.constants.ServerConstants;
import server.model.ServerDataModel;
import server.view.ServerMainView;

/**
 * The ServerSocketEndpoint class establishes connection threads for clock
 * setting with client.
 * 
 * @author Team 06
 * @version 1.0
 */
@ServerEndpoint("/server")
public class ServerSocketEndpointController{

	public static Queue<Session> queue = new ConcurrentLinkedQueue<Session>();
	private static Gson gson = new Gson();
	private static Thread rateThread;
	private static ServerMainView serverMainView;
	private static ServerDataModel serverDataModel;
	/**
	 * Spawns a thread for running server
	 */
	static {
		serverMainView = ServerFactory.getServerMainView();
		serverDataModel = ServerFactory.getServerDataModel();
		rateThread = new Thread() {
			public void run() {
				while (true) {
					if (queue != null) {
						if (serverMainView.getInteractiveView().getAutoResetCheckBox().isSelected() == true) {
							sendAndUpdateCounter();
						}
						if (serverMainView.getInteractiveView().isOneTimeSend() == true) {
							sendAndUpdateCounter();
							serverMainView.getInteractiveView().setOneTimeSend(false);
						}
						try {
							Double clock = (Double) serverMainView.getInteractiveView().getTimeInterval().getValue();
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
				float interval = serverDataModel.getDetectionModel().getTimeStampCounter()
						+ serverDataModel.getInteractiveModel().getLastTimeStamp();
				serverDataModel.setTimestamp(interval);
				String data = gson.toJson(serverDataModel);
				// this.serverMainView.getConsolelogMessage(data);
				System.out.println("data: " + data);
				serverDataModel.getDetectionModel().setTimeStampCounter(interval);
				sendAll(data);
				if (serverMainView.getDetectionView().getEyeActivateRadioButton().isSelected() == true) {
					serverMainView.getDetectionView().getEyeActivateRadioButton().setSelected(false);
					// serverMainView.getDetectionView().getActivateCheckBox().setSelected(false);
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
				} catch (Throwable e) {
			JOptionPane.showMessageDialog(null, ServerConstants.SEND_EXCEPTION_MESSAGE);
		}
	}
	
	
	/*public ServerSocketEndpointController(ServerMainView serverMainView, ServerDataModel serverDataModel) {
		this.serverMainView = serverMainView;
		this.serverDataModel = serverDataModel;
		rateThread = new Thread(this);
		rateThread.start();
	}*/


	/**
	 * Sets the log listener so that message can be passed to console panel
	 * 
	 * @param logListenerObject
	 */
	/*
	 * public static void setLogListener(LogListenerInterface logListenerObject) {
	 * logListener = logListenerObject; }
	 */

	/**
	 * Sets the detection listener so that message can be passes to the detection
	 * panel
	 * 
	 * @param detectionListenerServiceObject
	 */
	/*
	 * public static void setDetectionListenerService(DetectionListenerService
	 * detectionListenerServiceObject) { detectionListenerService =
	 * detectionListenerServiceObject; }
	 */

	/**
	 * provided for completeness, in out scenario clients don't send any msg.
	 * 
	 * @param session
	 * @param msg
	 */

	@OnMessage
	public void onMessage(Session session, String msg) {
		try {
			//logListener.logMessage("received msg " + msg + " from " + session.getId());
		} catch (Exception e) {
			e.printStackTrace();
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
		System.out.println("OPEN SESSION");
		queue.add(session);
		// logListener.logMessage(ServerConstants.NEW_SESSION_OPENED + session.getId());

	}

	/**
	 * When an error is occured sends message to log
	 * 
	 * @param session
	 * @param t
	 */
	@OnError
	public void error(Session session, Throwable t) {
		System.out.println("ERROR SESSION");
		queue.remove(session);
		// logListener.logMessage("Error on session " + session.getId());
	}

	/**
	 * When session closes the session is remvoved from the queue and logged
	 * 
	 * @param session
	 */
	@OnClose
	public void closedConnection(Session session) {
		System.out.println("closedConnection");
		queue.remove(session);
		// logListener.logMessage("session closed: " + session.getId());
	}
}