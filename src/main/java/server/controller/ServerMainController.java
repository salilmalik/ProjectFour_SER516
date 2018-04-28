package server.controller;

import server.constants.ServerConstants;
import server.listener.LogListenerInterface;
import server.listener.ServerListenerInterface;
import server.model.ServerModelSingleton;
import server.services.DetectionListenerService;
import server.services.InteractiveListenerService;
import server.services.ServerSocketService;
import server.view.ServerView;

import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The ServerMainController class sets and instantiates all listener services
 * along with connection objects.
 * 
 * @author Team 06
 * @version 1.0
 */
public class ServerMainController {

	public ServerMainController(ServerView serverView, ServerModelSingleton serverDataSingleton,
                                ServerSocketService serverSocketService, InteractiveListenerService interactiveListenerService,
                                DetectionListenerService detectionListenerService) {
		addViewToController(serverView);
		setListeners(serverView, interactiveListenerService, detectionListenerService, serverSocketService);
		serverSocketService.startServer(serverView);
	}

	/**
	 * sets the log listener for server console panel
	 * 
	 * @param serverView
	 */
	private static void setLogListener(ServerView serverView) {
		ServerSocketEndpoint.setLogListener(new LogListenerInterface() {
			@Override
			public void logMessage(String message) {
				serverView.logMessage(message);
			}
		});
	}

	/**
	 * attaches view to the controller following mvc
	 * 
	 * @param serverView
	 */
	private static void addViewToController(ServerView serverView) {
		try {
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if (ServerConstants.AQUA.equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException | javax.swing.UnsupportedLookAndFeelException | IllegalAccessException ex) {
			Logger.getLogger(ServerView.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(ServerView.class.getName()).log(Level.SEVERE, null, ex);
		}

		/**
		 * Create and display the form in a new thread .
		 */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				serverView.setVisible(true);
			}
		});
	}

	/**
	 * Performs dependency injection for loose coupling
	 * 
	 * @param serverView
	 * @param interactiveListenerService
	 * @param detectionListenerService
	 * @param serverSocketService
	 */
	private void setListeners(ServerView serverView, InteractiveListenerService interactiveListenerService,
                              DetectionListenerService detectionListenerService, ServerSocketService serverSocketService) {
		setDetectionListener(serverView, detectionListenerService);
		setLogListener(serverView);
		setInteractiveListener(serverView, interactiveListenerService);
		setServerStopListener(serverView, serverSocketService);
	}

	/**
	 * Sets the server stop listener
	 * 
	 * @param serverView
	 * @param serverSocketService
	 */
	private void setServerStopListener(ServerView serverView, ServerSocketService serverSocketService) {
		serverView.setServerListener(new ServerListenerInterface() {
			@Override
			public void stopServer() {
				serverSocketService.stopServer();
			}
		});
	}

	/**
	 * Sets the listener for all fields in the detection panel
	 * 
	 * @param serverView
	 * @param detectionListenerService
	 */
	private void setDetectionListener(ServerView serverView, DetectionListenerService detectionListenerService) {
		detectionListenerService.setServerView(serverView);
		ServerSocketEndpoint.setDetectionListenerService(detectionListenerService);
		serverView.setDetectionListenerService(detectionListenerService);
	}

	/**
	 * Set the listener for all fields in interaction panel
	 * 
	 * @param serverView
	 * @param interactiveListenerService
	 */
	private void setInteractiveListener(ServerView serverView, InteractiveListenerService interactiveListenerService) {
		serverView.setInteractiveListener(interactiveListenerService);
	}
}