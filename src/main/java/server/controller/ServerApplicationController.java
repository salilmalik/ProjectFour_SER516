package server.controller;

import server.constants.ServerConstants;
import server.model.Data;
import server.model.ServerModelSingleton;
import server.services.DetectionListenerService;
import server.services.InteractiveListenerService;
import server.services.ServerSocketService;
import server.view.*;

/**
 * The ServerApplicationController class sets singleton face data, connection
 * and listener services for the server.
 * 
 * @author Team 06
 * @version 1.0
 */
public class ServerApplicationController {

	DetectionPanel detectionPanel;
	ConsolePanel consolePanel;
	InteractivePanel interactivePanel;

	/**
	 * Inject dependency of view model and services
	 */
	public ServerApplicationController(String port, String serverType) {
		
		ServerView serverView = CreateServerView(serverType);
		ServerModelSingleton serverDataSingleton = ServerModelSingleton.getInstance();
		serverDataSingleton.setData(new Data());
		ServerSocketService serverSocketService = new ServerSocketService(port);
		InteractiveListenerService interactiveListenerService = new InteractiveListenerService();
		DetectionListenerService detectionListenerService = new DetectionListenerService();
		new ServerMainController(serverView, serverDataSingleton, serverSocketService, interactiveListenerService,
				detectionListenerService);
	}
	
	/**
	 * @param serverType
	 * @return Returns the ServerView for creating UI
	 */
	public ServerView CreateServerView(String serverType) {
		
		if(serverType.equals("skin"))
		{
			interactivePanel = new InteractivePanel(ServerConstants.SKINSERVERCOLOR);
			detectionPanel = new SkinDetectionPanel(ServerConstants.SKINSERVERCOLOR);
			consolePanel = new ConsolePanel(ServerConstants.SKINSERVERCOLOR);
		}
		else if(serverType.equals("heart"))
		{
			interactivePanel = new InteractivePanel(ServerConstants.HEARTSERVERCOLOR);
			detectionPanel = new HeartDetectionPanel(ServerConstants.HEARTSERVERCOLOR);
			consolePanel = new ConsolePanel(ServerConstants.HEARTSERVERCOLOR);
		}
		else
		{
			interactivePanel = new InteractivePanel(ServerConstants.FACESERVERCOLOR);
			detectionPanel = new FaceDetectionPanel(ServerConstants.FACESERVERCOLOR);
			consolePanel = new ConsolePanel(ServerConstants.FACESERVERCOLOR);
		}
		
		ServerView serverView = new ServerView(interactivePanel, detectionPanel, consolePanel);
		
		return serverView;
	}
}
