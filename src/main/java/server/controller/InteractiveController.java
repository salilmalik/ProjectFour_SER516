package server.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import server.model.InteractiveModel;
import server.view.InteractiveView;

public class InteractiveController {

	InteractiveView interactiveView;
	InteractiveModel interactiveModel;

	public InteractiveController(InteractiveView interactiveView, InteractiveModel interactiveModel) {
		this.interactiveView = interactiveView;
		this.interactiveModel = interactiveModel;
		this.interactiveView.addInteractiveActionListeners(new InteractiveListener());
		this.interactiveView.addInteractiveChangeListener(new InteractiveListener());
	}

	public class InteractiveListener implements ActionListener, ChangeListener {
		@Override
		public void stateChanged(ChangeEvent e) {
			interactiveView.stateChanged(e);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			interactiveView.actionPerformed(e);
		}
	}
}
