package server.controller;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JOptionPane;
import javax.websocket.Session;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.websocket.jsr356.server.ServerContainer;
import org.eclipse.jetty.websocket.jsr356.server.deploy.WebSocketServerContainerInitializer;

import server.constants.ServerConstants;
import server.view.ServerMainView;

/**
 * The ServerSocketService class inherits the Server Listener that focuses on
 * teh server start and stop functionalities.
 * 
 * @author Garv
 * @version 1.0
 */
public class ServerSocketController implements ServerSocketInterface {
	Thread serverThread;
	// LogListenerInterface logListener;
	Server server;
	ServerConnector connector;
	ServletContextHandler context;

	public static void main(String args[]) {
		//new ServerMainController();
	}

	/**
	 * Starts the server and binds the view to it
	 * 
	 * @param serverView
	 */
	public void startServer(ServerMainView serverMainView) {
		System.out.println("ASDASDASDASDDS");
		final ExecutorService clientProcessingPool = Executors.newFixedThreadPool(10);
		Runnable serverTask = new Runnable() {
			@Override
			public void run() {
				server = new Server();
				connector = new ServerConnector(server);
				connector.setPort(8081);
				server.addConnector(connector);
				// Setup the basic application "context" for this application at "/"
				// This is also known as the handler tree (in jetty speak)
				context = new ServletContextHandler(ServletContextHandler.SESSIONS);
				context.setContextPath("/");
				server.setHandler(context);
				try {
					// Initialize javax.websocket layer
					ServerContainer wscontainer = WebSocketServerContainerInitializer.configureContext(context);
					// Add server end point to the server
					wscontainer.addEndpoint(ServerSocketEndpointController.class);
					server.start();
					server.dump(System.err);
				} catch (Throwable t) {
					try {
						context.stop();
						connector.close();
						JOptionPane.showMessageDialog(null, "Server is already running");
						serverMainView.dispose();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		};
		serverThread = new Thread(serverTask);
		serverThread.start();
	}

	/**
	 * Stops the server and sets the configuration
	 */
	@Override
	public void stopServer() {
		try {
			context.stop();
			connector.close();
			server.stop();
			serverThread.join();
			/*
			 * ServerModelSingleton.getInstance().setAutoReset(false);
			 * ServerModelSingleton.getInstance().setOneTimeSend(false);
			 * ServerModelSingleton.getInstance().setFaceData(new FaceData());
			 * ServerModelSingleton.getInstance().setStateInterval(ServerConstants.
			 * STATE_INTERVAL);
			 */
			// ServerSocketEndpointController.queue = new ConcurrentLinkedQueue<Session>();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, ServerConstants.STOP_SERVER_EXCEPTION_MESSAGE);
		}
	}
}