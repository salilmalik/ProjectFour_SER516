package server.controller;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import server.model.*;
import server.view.ConsoleView;
import server.view.DetectionView;
import server.view.InteractiveView;
import server.view.ServerMainView;

public class ServerMainController implements ServerControllerInterface {

	private InteractiveController interactiveController;
	private DetectionController detectionController;
	private ConsoleController consoleController;
	private DetectionModel detectionModel;
	private InteractiveModel interactiveModel;
	private ConsoleView consoleView;
	private DetectionView detectionView;
	private InteractiveView interactiveView;
	private ServerMainView serverMainView;
	private ServerSocketEndpointController serverSocketEndpointController;
	private ServerDataModel serverDataModel;
	private AffectiveDataModel affectiveDataModel;
	private ExpressiveDataModel expressiveDataModel;

	public ServerMainController(String port, String typeServer) {
		initilizeModels();
		initializeViews();
		initializeControllers();
		new ServerSocketController().startServer(serverMainView,serverSocketEndpointController);
	}

	@Override
	public void initializeViews() {
		consoleView = new ConsoleView();
		detectionView = new DetectionView(detectionModel);
		interactiveView = new InteractiveView(interactiveModel);
		serverMainView = new ServerMainView(consoleView, detectionView, interactiveView);
		ServerFactory.setServerMainView(serverMainView);
		serverMainView.addWindowListener(new ServerMainListener());
	}

	@Override
	public void initilizeModels() {
		affectiveDataModel = new AffectiveDataModel();
		expressiveDataModel = new ExpressiveDataModel();
		detectionModel = new DetectionModel(affectiveDataModel, expressiveDataModel);
		interactiveModel = new InteractiveModel();
		serverDataModel = new ServerDataModel(detectionModel, interactiveModel);
		ServerFactory.setServerDataModel(serverDataModel);
	}

	@Override
	public void initializeControllers() {
		consoleController = new ConsoleController(consoleView);
		detectionController = new DetectionController(detectionView, detectionModel);
		interactiveController = new InteractiveController(interactiveView, interactiveModel);
		//serverSocketEndpointController = new ServerSocketEndpointController(serverMainView, serverDataModel);
	}

	public class ServerMainListener implements WindowListener {

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowClosing(WindowEvent e) {
			new ServerSocketController().stopServer();
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub

		}

	}
}