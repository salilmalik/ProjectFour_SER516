package client.controller;

import client.view.ExpressiveView;

public class ExpressiveController {

	private ExpressiveFaceController expressiveFaceContoller;
	private ExpressiveGraphController expressiveGraphContoller;

	public ExpressiveController(ExpressiveFaceController expressiveFaceContoller,
			ExpressiveGraphController expressiveGraphContoller, ExpressiveView expressiveView) {
		this.expressiveFaceContoller = expressiveFaceContoller;
		this.expressiveGraphContoller = expressiveGraphContoller;
	}
}
