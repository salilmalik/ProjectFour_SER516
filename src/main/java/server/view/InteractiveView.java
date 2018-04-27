package server.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import server.constants.ServerConstants;
import server.controller.InteractiveController.InteractiveListener;
import server.model.InteractiveModel;

public class InteractiveView extends JPanel {

	JCheckBox autoResetCheckBox;
	JSpinner timeInterval;
	JButton sendButton;
	private InteractiveModel interactiveModel;
	private boolean oneTimeSend = false;

	public JButton getSendButton() {
		return sendButton;
	}

	public void setSendButton(JButton sendButton) {
		this.sendButton = sendButton;
	}

	/**
	 * Creates new form InteractivePanel.
	 */
	public InteractiveView(InteractiveModel interactiveModel) {
		this.interactiveModel = interactiveModel;
		this.setBackground(Color.LIGHT_GRAY);
		this.setBorder(new TitledBorder(null, ServerConstants.INTERACTIVE, TitledBorder.LEADING, TitledBorder.TOP,
				ServerConstants.TEXT_FONT, null));
		this.setBounds(11, 11, 474, 104);
		this.setLayout(null);
		JLabel emoStateLabel = new JLabel(ServerConstants.TIME_INTERVAL);
		emoStateLabel.setForeground(Color.WHITE);
		emoStateLabel.setFont(ServerConstants.TEXT_FONT);
		emoStateLabel.setBounds(175, 29, 124, 25);
		this.add(emoStateLabel);
		autoResetCheckBox = new JCheckBox(ServerConstants.AUTO_RESETS);
		autoResetCheckBox.setForeground(Color.WHITE);
		autoResetCheckBox.setBackground(Color.GRAY);
		autoResetCheckBox.setFont(ServerConstants.TEXT_FONT);
		autoResetCheckBox.setBounds(175, 61, 101, 25);
		this.add(autoResetCheckBox);
		sendButton = new JButton(ServerConstants.SEND);
		sendButton.setBackground(Color.LIGHT_GRAY);
		sendButton.setContentAreaFilled(false);
		sendButton.setOpaque(true);
		sendButton.setFont(ServerConstants.TEXT_FONT);
		sendButton.setBounds(302, 61, 107, 25);
		this.add(sendButton);
		timeInterval = new JSpinner();
		timeInterval.setModel(new SpinnerNumberModel(ServerConstants.STATE_INTERVAL, 0.25, 100.00, 0.50));
		timeInterval.setBounds(324, 29, 55, 25);
		this.add(timeInterval);
	}

	public void addInteractiveActionListeners(ActionListener actionListener) {
		autoResetCheckBox.addActionListener(actionListener);
		sendButton.addActionListener(actionListener);

	}

	public void addInteractiveChangeListener(ChangeListener changeListener) {
		timeInterval.addChangeListener(changeListener);
	}

	/**
	 * Action Listener implementation for auto-reset or one time send
	 */
	public void actionPerformed(ActionEvent actionEvent) {
		if (actionEvent.getSource() == autoResetCheckBox && sendButton.getActionCommand() == ServerConstants.STOP) {
			if (!autoResetCheckBox.isSelected()) {
				interactiveModel.setAutoResetCheckBox(autoResetCheckBox.isSelected());
				sendButton.setActionCommand(ServerConstants.SEND);
			}
		}
		if (actionEvent.getSource() == sendButton && autoResetCheckBox.isSelected()) {
			interactiveModel.setAutoResetCheckBox(autoResetCheckBox.isSelected());
			sendButton.setActionCommand(ServerConstants.STOP);
		}
		if (actionEvent.getSource() == sendButton && !autoResetCheckBox.isSelected()) {
			oneTimeSend = true;
		}
	}

	/**
	 * Change state listener for the state change spinner
	 */
	public void stateChanged(ChangeEvent changeEvent) {
		if (changeEvent.getSource() == timeInterval) {
			interactiveModel.setLastTimeStamp(Float.parseFloat(timeInterval.getValue().toString()));
		}
	}

	public boolean isOneTimeSend() {
		return oneTimeSend;
	}

	public void setOneTimeSend(boolean oneTimeSend) {
		this.oneTimeSend = oneTimeSend;
	}

	public JCheckBox getAutoResetCheckBox() {
		return autoResetCheckBox;
	}

	public JSpinner getTimeInterval() {
		return timeInterval;
	}

	public void setTimeInterval(JSpinner timeInterval) {
		this.timeInterval = timeInterval;
	}

}