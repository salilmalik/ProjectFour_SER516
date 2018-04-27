package server.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

import server.constants.ServerConstants;

/**
 * The ServerView class class creates the server main window. Main frame for the
 * server that adds the Interactive, detection and the console panels.
 * 
 * @author Team 06
 * @version 1.0
 */
public class ServerMainView extends JFrame {
	ConsoleView consoleView;
	InteractiveView interactiveView;
	DetectionView detectionView;

	/**
	 * Creates new form ServerUI.
	 * 
	 * @param interactiveView2
	 * @param detectionView2
	 * @param consoleView2
	 */
	public ServerMainView(ConsoleView consoleView, DetectionView detectionView, InteractiveView interactiveView) {
		this.interactiveView = interactiveView;
		this.detectionView = detectionView;
		this.setTitle(ServerConstants.TITLE);
		this.getContentPane().setBackground(Color.LIGHT_GRAY);
		this.setResizable(true);
		this.setBounds(100, 100, 500, 600);
		this.getContentPane().setLayout(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().add(interactiveView);
		this.getContentPane().add(detectionView);
		this.getContentPane().add(consoleView);
		pack();
		setSize(1300, 700);
		setResizable(true);
		setVisible(true);
	}

	public ConsoleView getConsoleView() {
		return consoleView;
	}

	public void setConsoleView(ConsoleView consoleView) {
		this.consoleView = consoleView;
	}

	public InteractiveView getInteractiveView() {
		return interactiveView;
	}

	public void setInteractiveView(InteractiveView interactiveView) {
		this.interactiveView = interactiveView;
	}

	public DetectionView getDetectionView() {
		return detectionView;
	}

	public void setDetectionView(DetectionView detectionView) {
		this.detectionView = detectionView;
	}

	public void addWindowListener(WindowListener windowListener) {
		// this.addWindowListener(windowListener);
	}

	public void logMessage(String message) {
		consoleView.appendLogMessage(message);
	}

	public void changeClockCounter(double counter) {
		detectionView.changeClockCounter(counter);
	}

	public void disableActive() {
		detectionView.disableActive();
	}
}