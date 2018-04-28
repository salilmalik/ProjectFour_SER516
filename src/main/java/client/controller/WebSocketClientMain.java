package client.controller;

import java.net.URI;

import javax.swing.JOptionPane;
import javax.websocket.ContainerProvider;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

import client.constants.ClientConstants;

/**
 * The WebSocketClientMain class connects to the server socket and maintain the
 * connection
 * 
 * @author Team06
 * @version 1.0
 */
public class WebSocketClientMain {
	private static Object waitLock = new Object();
	Thread clientThread;
	Session session = null;

	/**
	 * wait4TerminateSignal method synchronizes the web socket connection
	 */
	private static void wait4TerminateSignal() {
		synchronized (waitLock) {
			try {
				waitLock.wait();
			} catch (InterruptedException e) {
				waitLock.notifyAll();
			}
		}
	}

	/**
	 * connectToServer configures client connection to the server
	 * 
	 * @param ip
	 *            : String with Server IP
	 * @param port
	 *            : String with Server port number
	 */
	public void connectToServer(String ip, String port) {
		ClientSocketEndpoint.setMainClientWebSocket(this);
		String url = ClientConstants.WEB_SOCKETS_SCHEMA + ip + ClientConstants.COLON + port
				+ ClientConstants.SERVER_DIR;
		Runnable serverTask = new Runnable() {

			@Override
			public void run() {
				WebSocketContainer container = null;
				try {
					container = ContainerProvider.getWebSocketContainer();
					System.out.println("URL: "+url);
					session = container.connectToServer(ClientSocketEndpoint.class, URI.create(url));
					//ClientDataSingleton.getInstance().setSessionMaintained(true);
					wait4TerminateSignal();

				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, ClientConstants.SERVER_NOT_RUNNING);
				} finally {
					if (session != null) {
						try {
							session.close();
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, ClientConstants.CLOSING_SESSION_EXCEPTION_MESSAGE);
						}
					}
				}
			}
		};
		clientThread = new Thread(serverTask);
		clientThread.start();
	}

	public Session getSession() {
		return session;
	}
}