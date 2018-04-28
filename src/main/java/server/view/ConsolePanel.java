package server.view;

import server.constants.ServerConstants;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The ConsolePanel class setup attributes of log console on server frame
 * 
 * @author Team 06
 * @version 1.0
 */
public class ConsolePanel extends javax.swing.JPanel {

	/**
	 * Creates new form ConsolePanel.
	 */
	JButton buttonClearLog;
	JTextArea consoleTextArea;

	public ConsolePanel(Color color) {
		this.setBackground(color);
		this.setBorder(new TitledBorder(null, ServerConstants.CONSOLE_LOG, TitledBorder.LEADING, TitledBorder.TOP,
				ServerConstants.TEXT_FONT, Color.BLACK));
		this.setBounds(11, 408, 474, 152);
		this.setLayout(null);
		buttonClearLog = new JButton(ServerConstants.CLEAR_LOG);
		buttonClearLog.setBounds(140, 119, 171, 25);
		buttonClearLog.setBackground(Color.LIGHT_GRAY);
		buttonClearLog.setContentAreaFilled(false);
		buttonClearLog.setOpaque(true);
		consoleTextArea = new JTextArea();
		buttonClearLog.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				consoleTextArea.setText(ServerConstants.EMPTY);
			}
		});
		JScrollPane scrollPane = new JScrollPane(consoleTextArea);
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(10, 26, 454, 86);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		this.add(buttonClearLog);
		this.add(scrollPane);
	}

	/**
	 * Sets group component layout for the console panel
	 */
	private void initComponents() {
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 400, Short.MAX_VALUE));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 300, Short.MAX_VALUE));
	}

	/**
	 * Displays messages on the console log
	 * @param message
	 */
	public void appendLogMessage(String message) {
		message = message + "\n";
		consoleTextArea.append(message);
	}
}
