package client.controller;

import java.io.IOException;

import server.controller.ServerMainController;

/**
 * The ClientServerConnectionService class provides service for client server
 * connection
 * 
 * @author Team06
 * @version 1.0
 */
public class ClientServerConnectionService {
	client.controller.WebSocketClientMain webSocketClientMain = new client.controller.WebSocketClientMain();

	public void startServer(String ip, String port) {
		establishServerClientConnection(ip, port);
	}

	/**
	 * reconnectServer method implements reconnection to the last connected server
	 * 
	 * @param url
	 *            String containing url of last connected server
	 */
/*	public void reconnectServer(String url) {
		String ip = ClientConfigurationSingleton.getInstance().getIp();
		String port = ClientConfigurationSingleton.getInstance().getPort();
		if (ip == null || port == null) {
			JOptionPane.showMessageDialog(null, ClientConstants.CONNECT_TO_SERVER);
		} else {
			establishServerClientConnection(ip, port);
		}
	}
*/
	/**
	 * initializeServer method instantiate ServerApplicationController class
	 * @throws IOException 
	 */

	public void initializeServer() throws IOException {
		//Runtime.getRuntime().exec("java ../../server.controller/ServerMainController");
		new ServerMainController();
	}

	/**
	 * establishServerClientConnection method sets client configuration for server
	 * client connection
	 * 
	 * @param ip
	 *            String which is User Input IP
	 * @param port
	 *            String denotes user input for port number
	 */
	private void establishServerClientConnection(String ip, String port) {
		webSocketClientMain.connectToServer(ip, port);
		/*if (!ClientDataSingleton.getInstance().isSessionMaintained()) {
			ClientConfigurationSingleton.getInstance().setIp(ip);
			ClientConfigurationSingleton.getInstance().setPort(port);
			
		} else {
			JOptionPane.showMessageDialog(null, ClientConstants.CLIENT_ALREADY_CONNECTED);
		}*/
	}
}