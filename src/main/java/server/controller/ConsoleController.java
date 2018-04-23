package server.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import server.view.ConsoleView;

public class ConsoleController {

	private ConsoleView consoleView;

	public ConsoleController(ConsoleView consoleView) {
		this.consoleView = consoleView;
	}

	public class ConsoleListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			consoleView.actionPerformed(actionEvent);
		}
	}
}