package server.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;

import server.constants.ServerConstants;

public class ConsoleView extends JPanel {

	/**
	 * Creates new form ConsolePanel.
	 */
	JButton buttonClearLog;
	JTextArea consoleTextArea;

	public ConsoleView() {
		this.setBackground(Color.LIGHT_GRAY);
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
		JScrollPane scrollPane = new JScrollPane(consoleTextArea);
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(10, 26, 454, 86);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		this.add(buttonClearLog);
		this.add(scrollPane);
	}

	public void buttonClearLogActionListener(ActionListener actionListener) {
		buttonClearLog.addActionListener(actionListener);
	}

	public void actionPerformed(ActionEvent actionEvent) {
		consoleTextArea.setText(ServerConstants.EMPTY);
	}

	/**
	 * Displays messages on the console log
	 * 
	 * @param message
	 */
	public void appendLogMessage(String message) {
		message = message + "\n";
		consoleTextArea.append(message);
	}
}