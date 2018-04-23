package server.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import server.constants.ServerConstants;
import server.model.DetectionModel;

public class DetectionView extends JPanel {

	JTextField timeTxtField;
	JComboBox<String> upperfaceComboBox;
	JSpinner upperfaceSpinner;
	JComboBox<String> lowerfaceComboBox;
	JComboBox<String> eyeComboBox;
	JCheckBox eyeAutoResetCheckBox;
	JCheckBox activateCheckBox;
	JRadioButton eyeActivateRadioButton;
	JComboBox<String> performanceMetricsComboBox;
	JSpinner performanceMetricsSpinner;
	JSpinner lowerfaceSpinner;
	private DetectionModel detectionModel;

	/**
	 * Design and component setting for the detection panel
	 */
	public DetectionView(DetectionModel detectionModel) {
		this.detectionModel = detectionModel;
		this.setBackground(Color.LIGHT_GRAY);
		this.setBorder(new TitledBorder(null, ServerConstants.DETECTION, TitledBorder.LEADING, TitledBorder.TOP,
				ServerConstants.TEXT_FONT, null));
		this.setBounds(11, 130, 474, 267);
		this.setLayout(null);
		timeDetectionPanelSetup();
		upperFaceDetectionPanel();
		lowerFaceDetectionPanelSetup();
		eyeDetectionPanelSetup();
		performanceMetricSetup();
	}

	/**
	 * timeDetectionPanelSetup sets up the detection panel UI for the time
	 */
	private void timeDetectionPanelSetup() {
		JLabel timeLabel = new JLabel(ServerConstants.TIME);
		timeLabel.setFont(ServerConstants.TEXT_FONT);
		timeLabel.setForeground(Color.WHITE);
		timeLabel.setBounds(14, 24, 41, 33);
		this.add(timeLabel);
		timeTxtField = new JTextField();
		timeTxtField.setForeground(Color.WHITE);
		timeTxtField.setBackground(Color.DARK_GRAY);
		timeTxtField.setEditable(false);
		timeTxtField.setText("0");
		timeTxtField.setBounds(53, 29, 50, 25);
		this.add(timeTxtField);
		timeTxtField.setColumns(10);
		JLabel secondsLabel = new JLabel(ServerConstants.SECONDS);
		secondsLabel.setFont(ServerConstants.TEXT_FONT);
		secondsLabel.setForeground(Color.WHITE);
		secondsLabel.setBounds(113, 24, 64, 33);
		this.add(secondsLabel);
	}

	/**
	 * upperFaceDetectionPanel sets up the detection panel UI for the upper face
	 */
	private void upperFaceDetectionPanel() {
		JLabel upperFaceLabel = new JLabel(ServerConstants.UPPER_FACE);
		upperFaceLabel.setFont(ServerConstants.TEXT_FONT);
		upperFaceLabel.setForeground(Color.WHITE);
		upperFaceLabel.setBounds(14, 68, 139, 33);
		this.add(upperFaceLabel);
		String[] upperfaceItems = new String[] { ServerConstants.RAISE_BROW, ServerConstants.FURROW_BROW };
		upperfaceComboBox = new JComboBox<>(upperfaceItems);
		upperfaceComboBox.setBounds(14, 98, 139, 25);
		this.add(upperfaceComboBox);
		upperfaceSpinner = new JSpinner();
		upperfaceSpinner.setModel(new SpinnerNumberModel(0.00, 0.00, 1.00, 0.1));
		upperfaceSpinner.setBackground(Color.WHITE);
		upperfaceSpinner.setBounds(161, 97, 55, 25);
		this.add(upperfaceSpinner);
	}

	/**
	 * lowerFaceDetectionPanelSetup sets up the detection panel UI for the lower
	 * face
	 */
	private void lowerFaceDetectionPanelSetup() {
		JLabel lowerfaceLabel = new JLabel(ServerConstants.LOWERFACE);
		lowerfaceLabel.setFont(ServerConstants.TEXT_FONT);
		lowerfaceLabel.setForeground(Color.WHITE);
		lowerfaceLabel.setBounds(250, 68, 139, 33);
		this.add(lowerfaceLabel);
		String[] lowerfaceItems = new String[] { ServerConstants.LAUGH, ServerConstants.CLENCH,
				ServerConstants.SMIRK_LEFT, ServerConstants.SMIRK_RIGHT, ServerConstants.SMILE };
		lowerfaceComboBox = new JComboBox<>(lowerfaceItems);
		lowerfaceComboBox.setBounds(250, 98, 123, 25);
		this.add(lowerfaceComboBox);
		lowerfaceSpinner = new JSpinner();
		lowerfaceSpinner.setModel(new SpinnerNumberModel(0.00, 0.00, 1.00, 0.1));
		lowerfaceSpinner.setForeground(Color.WHITE);
		lowerfaceSpinner.setBounds(383, 97, 52, 25);
		this.add(lowerfaceSpinner);
	}

	/**
	 * eyeDetectionPanelSetup sets up the detection panel UI for the eye
	 */
	private void eyeDetectionPanelSetup() {
		JLabel eyeLabel = new JLabel(ServerConstants.EYE);
		eyeLabel.setFont(ServerConstants.TEXT_FONT);
		eyeLabel.setForeground(Color.WHITE);
		eyeLabel.setBounds(14, 134, 115, 33);
		this.add(eyeLabel);
		String[] eyeItems = new String[] { ServerConstants.BLINK, ServerConstants.WINK_LEFT, ServerConstants.WINK_RIGHT,
				ServerConstants.LOOK_LEFT, ServerConstants.LOOK_RIGHT };
		eyeComboBox = new JComboBox<>(eyeItems);
		eyeComboBox.setBounds(14, 163, 139, 25);
		this.add(eyeComboBox);
		eyeActivateRadioButton = new JRadioButton(ServerConstants.ACTIVATE);
		eyeActivateRadioButton.setFont(ServerConstants.TEXT_FONT);
		eyeActivateRadioButton.setBackground(Color.GRAY);
		eyeActivateRadioButton.setForeground(Color.WHITE);
		eyeActivateRadioButton.setBounds(185, 164, 95, 25);
		this.add(eyeActivateRadioButton);
		eyeAutoResetCheckBox = new JCheckBox(ServerConstants.AUTO_RESETS);
		eyeAutoResetCheckBox.setForeground(Color.WHITE);
		eyeAutoResetCheckBox.setFont(ServerConstants.TEXT_FONT);
		eyeAutoResetCheckBox.setBackground(Color.GRAY);
		eyeAutoResetCheckBox.setBounds(294, 164, 95, 25);
		this.add(eyeAutoResetCheckBox);
	}

	/**
	 * performanceMetricSetup sets up the detection panel UI for the performance
	 * metric
	 */
	private void performanceMetricSetup() {
		JLabel performanceMetricsLabel = new JLabel(ServerConstants.PERFORMANCE_METRICS);
		performanceMetricsLabel.setFont(ServerConstants.TEXT_FONT);
		performanceMetricsLabel.setForeground(Color.WHITE);
		performanceMetricsLabel.setBounds(14, 199, 131, 33);
		this.add(performanceMetricsLabel);
		String[] pfMetricItems = new String[] { ServerConstants.INTEREST, ServerConstants.ENGAGEMENT,
				ServerConstants.STRESS, ServerConstants.RELAXATION, ServerConstants.EXCITEMENT, ServerConstants.FOCUS };
		performanceMetricsComboBox = new JComboBox<>(pfMetricItems);
		performanceMetricsComboBox.setBounds(14, 229, 139, 25);
		this.add(performanceMetricsComboBox);
		performanceMetricsSpinner = new JSpinner();
		performanceMetricsSpinner.setModel(new SpinnerNumberModel(0.00, 0.00, 1.00, 0.1));
		performanceMetricsSpinner.setBounds(161, 229, 55, 25);
		this.add(performanceMetricsSpinner);
	}

	public void addDetectionActionListeners(ActionListener detectionActionListener) {
		upperfaceComboBox.addActionListener(detectionActionListener);
		eyeActivateRadioButton.addActionListener(detectionActionListener);
		eyeAutoResetCheckBox.addActionListener(detectionActionListener);
		eyeAutoResetCheckBox.addActionListener(detectionActionListener);
		performanceMetricsComboBox.addActionListener(detectionActionListener);
		eyeComboBox.addActionListener(detectionActionListener);
		lowerfaceComboBox.addActionListener(detectionActionListener);
		upperfaceComboBox.addActionListener(detectionActionListener);
	}

	public void addDetectionChangeListener(ChangeListener detectionChangeListener) {
		performanceMetricsSpinner.addChangeListener(detectionChangeListener);
		lowerfaceSpinner.addChangeListener(detectionChangeListener);
		upperfaceSpinner.addChangeListener(detectionChangeListener);
	}

	/**
	 * Sets clock value
	 * 
	 * @params counter
	 */
	public void changeClockCounter(double counter) {
		timeTxtField.setText(String.valueOf(counter));
	}

	/**
	 * Figures which operation is performed and performs operations on state change
	 * listener
	 * 
	 * @param e
	 *            Contains the event associated to the view
	 */
	public void stateChanged(ChangeEvent e) {
		if (e.getSource() == lowerfaceSpinner) {
			float lowerfaceValue = (float) ((double) lowerfaceSpinner.getValue());
			String lowerfaceExp = (String) lowerfaceComboBox.getSelectedItem();
			detectionModel.setLowerfaceValue(lowerfaceValue);
			detectionModel.setLowerfaceExp(lowerfaceExp);
		} else if (e.getSource() == upperfaceSpinner) {
			float upperfaceValue = (float) ((double) upperfaceSpinner.getValue());
			String upperfaceExp = (String) upperfaceComboBox.getSelectedItem();
			detectionModel.setUpperfaceExp(upperfaceExp);
			detectionModel.setUpperfaceValue(upperfaceValue);
		} else if (e.getSource() == performanceMetricsSpinner) {
			float metricsValue = (float) ((double) performanceMetricsSpinner.getValue());
			String metricsExp = (String) performanceMetricsComboBox.getSelectedItem();
			detectionModel.setMetricsExp(metricsExp);
			detectionModel.setMetricsValue(metricsValue);
		}
	}

	/**
	 * Contains the event associated to onclick listener on the view
	 * 
	 * @param e
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == upperfaceComboBox) {
			float upperfaceValue = (float) ((double) upperfaceSpinner.getValue());
			String upperfaceExp = (String) upperfaceComboBox.getSelectedItem();
			detectionModel.setUpperfaceExp(upperfaceExp);
			detectionModel.setUpperfaceValue(upperfaceValue);
		} else if (e.getSource() == lowerfaceComboBox) {
			float lowerfaceValue = (float) ((double) lowerfaceSpinner.getValue());
			String lowerfaceExp = (String) lowerfaceComboBox.getSelectedItem();
			detectionModel.setLowerfaceValue(lowerfaceValue);
			detectionModel.setLowerfaceExp(lowerfaceExp);
		} else if (e.getSource() == performanceMetricsComboBox) {
			float metricsValue = (float) ((double) performanceMetricsSpinner.getValue());
			String metricsExp = (String) performanceMetricsComboBox.getSelectedItem();
			detectionModel.setMetricsExp(metricsExp);
			detectionModel.setMetricsValue(metricsValue);
		} else if (e.getSource() == eyeComboBox) {
			String eye = (String) eyeComboBox.getSelectedItem();
			if (eyeActivateRadioButton.isSelected()) {
				detectionModel.setEye(eye);
			}
		} else if (e.getSource() == eyeActivateRadioButton) {
			String eye = (String) eyeComboBox.getSelectedItem();
			if (eyeActivateRadioButton.isSelected()) {
				detectionModel.setEye(eye);
			}
		} else if (e.getSource() == eyeAutoResetCheckBox) {
			if (eyeAutoResetCheckBox.isSelected()) {
				detectionModel.setEyeAutoResetCheckBox(true);
			}
		}
	}

	/**
	 * Disables the eye active and eye auto reset
	 */
	public void disableActive() {
		eyeActivateRadioButton.setSelected(false);
		eyeAutoResetCheckBox.setSelected(false);
	}
}