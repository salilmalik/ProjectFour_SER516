package client.controller;

import client.view.AffectiveView;

public class AffectiveContoller {
	AffectiveColorController affectiveColorContoller;
	AffectiveGraphController affectiveGraphContoller;

	public AffectiveContoller(AffectiveColorController affectiveColorContoller,
			AffectiveGraphController affectiveGraphContoller, AffectiveView affectiveView) {
		this.affectiveColorContoller = affectiveColorContoller;
		this.affectiveGraphContoller = affectiveGraphContoller;
	}
}
