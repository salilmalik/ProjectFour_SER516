package client.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import client.model.MenuBarModel;
import client.view.MenuBarView;

public class MenuBarController {

	private MenuBarView menuBarView;
	private MenuBarModel menuBarModel;

	public MenuBarController(MenuBarView menuBarView, MenuBarModel menuBarModel) {
		this.menuBarView = menuBarView;
		this.menuBarModel = menuBarModel;
		this.menuBarView.addConnectionListener(new MenuBarListener());
	}

	public class MenuBarListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent connectEvent) {
			menuBarView.actionPerformed(connectEvent);
		}
	}
}
