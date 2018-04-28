package client.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import client.constants.ClientConstants;
import client.model.MenuBarModel;
import client.view.MenuBarView;

public class MenuBarController {
	private MenuBarView menuBarView;
	private MenuBarModel menuBarModel;
	private ClientServerConnectionService clientServerConnectionService;

	public MenuBarController(MenuBarView menuBarView, MenuBarModel menuBarModel,
			ClientServerConnectionService clientServerConnectionService) {
		this.menuBarView = menuBarView;
		this.menuBarModel = menuBarModel;
		this.clientServerConnectionService = clientServerConnectionService;
		this.menuBarView.addConnectionListener(new MenuBarListener());

	}

	public class MenuBarListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent connectEvent) {
			if (((JMenuItem) connectEvent.getSource()).getText() == "Face Server") {

					launchPortDialogBox("face");

			} else if (((JMenuItem) connectEvent.getSource()).getText() == "Heart Server") {

					launchPortDialogBox("heart");

			} else if (((JMenuItem) connectEvent.getSource()).getText() == "Skin Server") {

					launchPortDialogBox("skin");

			}/*else if (((JMenuItem) connectEvent.getSource()).getText() == ClientConstants.CONNECT) {
				if (clientServerConnectionService != null) {
					launchDialogBox();
				}
			}*/
		}

		/**
		 * launchPortDialogBox method provides a dialogue box for IP and port user inputs
		 * so that you can change port number to connect server on localhost
		 */
		private void launchPortDialogBox(String type) {
			JTextField ipField = new JTextField(15);
			JTextField ipPort = new JTextField(15);
			ipField.setText(ClientConstants.LOCALHOST);
			ipField.setEditable(false);
			ipPort.setText(ClientConstants.PORT_NUMBER);
			JPanel myPanel = new JPanel();
			myPanel.add(new JLabel(ClientConstants.IP_STRING));
			myPanel.add(ipField);
			myPanel.add(Box.createHorizontalStrut(15));
			myPanel.add(new JLabel(ClientConstants.PORT_STRING));
			myPanel.add(ipPort);
			int result = JOptionPane.showConfirmDialog(null, myPanel, ClientConstants.ENTER_IP,
					JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION) {
				try {
					clientServerConnectionService.initializeServer(ipPort.getText(), type);
					clientServerConnectionService.startServer(ipField.getText(), ipPort.getText());
				}catch (IOException e )
				{

				}
				}
		}

		/**
		 * launchDialogBox method provides a dialogue box for IP and port user inputs
		 */
		private void launchDialogBox() {
			JTextField ipField = new JTextField(15);
			JTextField ipPort = new JTextField(15);
			ipField.setText(ClientConstants.LOCALHOST);
			ipPort.setText(ClientConstants.PORT_NUMBER);
			JPanel myPanel = new JPanel();
			myPanel.add(new JLabel(ClientConstants.IP_STRING));
			myPanel.add(ipField);
			myPanel.add(Box.createHorizontalStrut(15));
			myPanel.add(new JLabel(ClientConstants.PORT_STRING));
			myPanel.add(ipPort);
			int result = JOptionPane.showConfirmDialog(null, myPanel, ClientConstants.ENTER_IP,
					JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION) {
				clientServerConnectionService.startServer("localhost", "8080");
			}
		}

	}
}
