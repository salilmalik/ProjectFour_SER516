package server.view;

import server.constants.ServerConstants;
import server.services.InteractiveListenerService;
import server.services.ServerSocketService;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The InteractivePanel class creates the Interactive Panel display that sets up
 * the time interval for communication with the client also sets up the auto
 * reset or one time send to the client.
 * 
 * @author Team 06
 * @version 1.0
 */
public class InteractivePanel extends JPanel implements ActionListener, ChangeListener {

	JCheckBox autoResetCheckBox;
	JSpinner emoStateSpinner;
	JButton sendButton;
	InteractiveListenerService interactiveListenerService;
	ServerSocketService serverSocketService;

	/**
	 * Creates new form InteractivePanel.
	 */
	public InteractivePanel(Color color) {
		this.setBorder(new TitledBorder(null, ServerConstants.INTERACTIVE, TitledBorder.LEADING, TitledBorder.TOP,
				ServerConstants.TEXT_FONT, null));
		this.setBackground(color);
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
		autoResetCheckBox.addActionListener(this);
		sendButton = new JButton(ServerConstants.SEND);
		sendButton.setBackground(Color.LIGHT_GRAY);
		sendButton.setContentAreaFilled(false);
		sendButton.setOpaque(true);
		sendButton.setFont(ServerConstants.TEXT_FONT);
		sendButton.setBounds(302, 61, 107, 25);
		this.add(sendButton);
		sendButton.addActionListener(this);
		emoStateSpinner = new JSpinner();
		emoStateSpinner.setModel(new SpinnerNumberModel(ServerConstants.STATE_INTERVAL, 0.25, 100.00, 0.50));
		emoStateSpinner.setBounds(324, 29, 55, 25);
		emoStateSpinner.addChangeListener(this);
		this.add(emoStateSpinner);
	}

	/**
	 * Action Listener implementation for auto-reset or one time send
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == autoResetCheckBox && sendButton.getActionCommand() == ServerConstants.STOP) {
			if (!autoResetCheckBox.isSelected()) {
				interactiveListenerService.stateSpinnerChange(autoResetCheckBox.isSelected());
				sendButton.setActionCommand(ServerConstants.SEND);
			}
		}
		if (e.getSource() == sendButton && autoResetCheckBox.isSelected()) {
			interactiveListenerService.stateSpinnerChange(autoResetCheckBox.isSelected());
			sendButton.setActionCommand(ServerConstants.STOP);
		}
		if (e.getSource() == sendButton && !autoResetCheckBox.isSelected()) {
			interactiveListenerService.stateSpinnerChange(autoResetCheckBox.isSelected());
		}
	}

	/**
	 * Change state listener for the state change spinner
	 */
	@Override
	public void stateChanged(ChangeEvent e) {
		if (e.getSource() == emoStateSpinner) {
			String stateValue = emoStateSpinner.getValue().toString();
			interactiveListenerService.autoResetChange(stateValue);
		}

	}

	public void setInteractiveListener(InteractiveListenerService interactiveListenerService) {
		this.interactiveListenerService = interactiveListenerService;
	}
}
