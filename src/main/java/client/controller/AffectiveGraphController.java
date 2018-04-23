package client.controller;

import client.model.AffectiveDataModel;
import client.view.AffectiveGraphView;

public class AffectiveGraphController {

	private AffectiveGraphView affectiveGraphView;
	private AffectiveDataModel affectiveDataModel;

	public AffectiveGraphController(AffectiveGraphView affectiveGraphView, AffectiveDataModel affectiveDataModel) {
		this.affectiveGraphView = affectiveGraphView;
		this.affectiveDataModel = affectiveDataModel;
	}
}
