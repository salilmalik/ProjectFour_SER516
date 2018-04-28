package server.view;

import server.constants.ServerConstants;
import server.listener.ServerListenerInterface;
import server.services.DetectionListenerService;
import server.services.InteractiveListenerService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * The ServerView class class creates the server main window. Main frame for the server that adds the Interactive,
 * detection and the console panels.
 * 
 * @author Team 06
 * @version 1.0
 */
public class ServerView extends JFrame {
	DetectionPanel detectionPanel;
	ConsolePanel consolePanel;
	InteractivePanel interactivePanel;
	ServerListenerInterface serverListenerInterface;

	/**
	 * Creates new form ServerUI.
	 */
	public ServerView(InteractivePanel interactivePanel, DetectionPanel detectionPanel, ConsolePanel consolePanel) {
		this.setTitle(ServerConstants.TITLE);
		this.getContentPane().setBackground(Color.LIGHT_GRAY);
		this.setResizable(true);
		this.setBounds(100, 100, 500, 600);
		this.setMinimumSize(new Dimension(512, 610));
		this.getContentPane().setLayout(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				serverListenerInterface.stopServer();
			}
		});
		
		this.interactivePanel = interactivePanel;
		this.detectionPanel = detectionPanel;
		this.consolePanel = consolePanel;
		this.getContentPane().add(interactivePanel);
		this.getContentPane().add((Component) detectionPanel);
		this.getContentPane().add(consolePanel);
	}

	/**
	 * Initializes the components for the server view
	 */
	private void initComponents() {
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 400, Short.MAX_VALUE));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 300, Short.MAX_VALUE));
		pack();
	}

	public void logMessage(String message) {
		consolePanel.appendLogMessage(message);
	}

	public void changeClockCounter(double counter) {
		detectionPanel.changeClockCounter(counter);
	}

	public void setInteractiveListener(InteractiveListenerService interactiveListenerService) {
		interactivePanel.setInteractiveListener(interactiveListenerService);
	}

	public void setDetectionListenerService(DetectionListenerService detectionListenerService) {
		detectionPanel.setDetectionListenerService(detectionListenerService);
	}

	public void setServerListener(ServerListenerInterface serverListenerInterface) {
		this.serverListenerInterface = serverListenerInterface;
	}

	public void disableActive() {
		detectionPanel.disableActive();
	}
}
