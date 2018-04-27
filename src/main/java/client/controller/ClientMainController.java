package client.controller;

import client.model.AffectiveDataModel;
import client.model.ExpressiveDataModel;
import client.model.MenuBarModel;
import client.view.AffectiveColorView;
import client.view.AffectiveGraphView;
import client.view.AffectiveView;
import client.view.ClientMainView;
import client.view.ExpressiveFaceView;
import client.view.ExpressiveGraphView;
import client.view.ExpressiveView;
import client.view.MenuBarView;

/**
 * The ClientMainController class handles web socket connection between the
 * client and the server.
 * 
 * @author Team06
 * @version 1.0
 */
public class ClientMainController implements ClientControllerInterface {
	private MenuBarView menuBarView;
	private AffectiveColorView affectiveColorView;
	private AffectiveGraphView affectiveGraphView;
	private AffectiveView affectiveView;
	private ExpressiveFaceView expressiveFaceView;
	private ExpressiveGraphView expressiveGraphView;
	private ExpressiveView expressiveView;
	private ClientMainView clientMainView;
	private AffectiveColorController affectiveColorContoller;
	private AffectiveGraphController affectiveGraphContoller;
	private AffectiveContoller affectiveContoller;
	private ExpressiveFaceController expressiveFaceContoller;
	private ExpressiveGraphController expressiveGraphContoller;
	private ExpressiveController expressiveController;
	private AffectiveDataModel affectiveColorModel;
	private ExpressiveDataModel expressiveDataModel;
	private MenuBarModel menuBarModel;
	private MenuBarController menuBarController;

	/**
	 * Starting point of client
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		ClientMainController clientMainController = new ClientMainController();
		clientMainController.initilizeModels();
		clientMainController.initializeViews();
		clientMainController.initializeControllers();
		
	}

	@Override
	public void initilizeModels() {
		affectiveColorModel = new AffectiveDataModel();
		expressiveDataModel = new ExpressiveDataModel();
		menuBarModel = new MenuBarModel();
	}

	@Override
	public void initializeControllers() {
		affectiveColorContoller = new AffectiveColorController(affectiveColorView, affectiveColorModel);
		affectiveGraphContoller = new AffectiveGraphController(affectiveGraphView, affectiveColorModel);
		affectiveContoller = new AffectiveContoller(affectiveColorContoller, affectiveGraphContoller, affectiveView);
		expressiveFaceContoller = new ExpressiveFaceController(expressiveFaceView, expressiveDataModel);
		expressiveGraphContoller = new ExpressiveGraphController(expressiveGraphView, expressiveDataModel);
		expressiveController = new ExpressiveController(expressiveFaceContoller, expressiveGraphContoller,
				expressiveView);
		menuBarController = new MenuBarController(menuBarView,menuBarModel);
	}

	@Override
	public void initializeViews() {
		menuBarView = new MenuBarView(menuBarModel);
		affectiveColorView = new AffectiveColorView(affectiveColorModel);
		affectiveGraphView = new AffectiveGraphView(affectiveColorModel);
		affectiveView = new AffectiveView(affectiveColorView, affectiveGraphView);
		expressiveFaceView = new ExpressiveFaceView(expressiveDataModel);
		expressiveGraphView = new ExpressiveGraphView(expressiveDataModel);
		expressiveView = new ExpressiveView(expressiveFaceView, expressiveGraphView);
		clientMainView = new ClientMainView(affectiveView, expressiveView, menuBarView);
	}
}