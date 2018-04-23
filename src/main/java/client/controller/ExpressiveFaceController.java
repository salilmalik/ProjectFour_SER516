package client.controller;

import client.model.ExpressiveDataModel;
import client.view.ExpressiveFaceView;

public class ExpressiveFaceController {

	private ExpressiveFaceView expressiveFaceView;
	private ExpressiveDataModel expressiveDataModel;

	public ExpressiveFaceController(ExpressiveFaceView expressiveFaceView, ExpressiveDataModel expressiveDataModel) {
		this.expressiveFaceView = expressiveFaceView;
		this.expressiveDataModel = expressiveDataModel;
	}
}
