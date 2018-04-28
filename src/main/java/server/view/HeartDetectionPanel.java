package server.view;

import server.constants.ServerConstants;
import server.services.DetectionListenerService;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The DetectionPanel class creates the Detection Panel display that sets the
 * clock timer along with the upperface, lowerface and eye features, also
 * setting the Performance metrics.
 * 
 * @author Team 06
 * @version 1.0
 */
public class HeartDetectionPanel extends JPanel implements ChangeListener, ActionListener,DetectionPanel {

	JTextField timeTxtField;
	JSpinner systolicBPSpinner;
	JSpinner diastolicBPSpinner;
	JSpinner heartBeatSpinner;
	JComboBox<String> eyeComboBox;
	JComboBox<String> bloodMetricsComboBox;
	JSpinner bloodMetricsSpinner;
	DetectionListenerService detectionListenerService;
	JSpinner lowerfaceSpinner;

	/**
	 * Design and component setting for the detection panel
	 */
	public HeartDetectionPanel(Color color) {
		this.setBackground(color);
		this.setBorder(new TitledBorder(null, ServerConstants.DETECTION, TitledBorder.LEADING, TitledBorder.TOP,
				ServerConstants.TEXT_FONT, null));
		this.setBounds(11, 130, 474, 267);
		this.setLayout(null);
		showTime();
		addBloodPressureOperations();
		addHeartBeatOperations();
		bloodMetricSetup();
	}

	
	/**
	 * timeDetectionPanelSetup sets up the detection panel UI for the time
	 */
	private void showTime() {
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
	private void addBloodPressureOperations() {
		
		JLabel bloodPressureLabel = new JLabel(ServerConstants.BP);
		bloodPressureLabel.setFont(ServerConstants.TEXT_FONT);
		bloodPressureLabel.setBounds(175, 61, 101, 25);
		this.add(bloodPressureLabel);
		
		JLabel systolicBPLabel = new JLabel(ServerConstants.SYS_BP);
		systolicBPLabel.setFont(ServerConstants.TEXT_FONT);
		systolicBPLabel.setForeground(Color.WHITE);
		systolicBPLabel.setBounds(14, 98, 200, 33);
		this.add(systolicBPLabel);
		systolicBPSpinner = new JSpinner();
		systolicBPSpinner.setModel(new SpinnerNumberModel(0.00, 0.00, 1.00, 0.1));
		systolicBPSpinner.setBackground(Color.WHITE);
		systolicBPSpinner.setBounds(80, 103, 55, 25);
		systolicBPSpinner.addChangeListener(this);
		this.add(systolicBPSpinner);
		
		JLabel diastolicBPLabel = new JLabel(ServerConstants.DIA_BP);
		diastolicBPLabel.setFont(ServerConstants.TEXT_FONT);
		diastolicBPLabel.setForeground(Color.WHITE);
		diastolicBPLabel.setBounds(250, 98, 139, 33);
		this.add(diastolicBPLabel);
		diastolicBPSpinner = new JSpinner();
		diastolicBPSpinner.setModel(new SpinnerNumberModel(0.00, 0.00, 1.00, 0.1));
		diastolicBPSpinner.setForeground(Color.WHITE);
		diastolicBPSpinner.setBounds(316, 103, 52, 25);
		diastolicBPSpinner.addChangeListener(this);
		this.add(diastolicBPSpinner);
		
	}

	/**
	 * eyeDetectionPanelSetup sets up the detection panel UI for the eye
	 */
	private void addHeartBeatOperations() {
		JLabel hearBeatLabel = new JLabel(ServerConstants.HEART_BEAT);
		hearBeatLabel.setFont(ServerConstants.TEXT_FONT);
		hearBeatLabel.setForeground(Color.WHITE);
		hearBeatLabel.setBounds(14, 160, 115, 33);
		this.add(hearBeatLabel);
		heartBeatSpinner = new JSpinner();
		heartBeatSpinner.setModel(new SpinnerNumberModel(0.00, 0.00, 1.00, 0.1));
		heartBeatSpinner.setForeground(Color.WHITE);
		heartBeatSpinner.setBounds(120, 164, 52, 25);
		heartBeatSpinner.addChangeListener(this);
		this.add(heartBeatSpinner);
	}

	/**
	 * performanceMetricSetup sets up the detection panel UI for the performance
	 * metric
	 */
	private void bloodMetricSetup() {
		JLabel bloodMetricsLabel = new JLabel(ServerConstants.BLOOD_METRICS);
		bloodMetricsLabel.setFont(ServerConstants.TEXT_FONT);
		bloodMetricsLabel.setForeground(Color.WHITE);
		bloodMetricsLabel.setBounds(14, 199, 131, 33);
		this.add(bloodMetricsLabel);
		String[] bMetricItems = new String[] { ServerConstants.RBC, ServerConstants.WBC,
				ServerConstants.HAEMO, ServerConstants.PLATELETS};
		bloodMetricsComboBox = new JComboBox<>(bMetricItems);
		bloodMetricsComboBox.setBounds(14, 229, 139, 25);
		bloodMetricsComboBox.addActionListener(this);
		this.add(bloodMetricsComboBox);
		bloodMetricsSpinner = new JSpinner();
		bloodMetricsSpinner.setModel(new SpinnerNumberModel(0.00, 0.00, 1.00, 0.1));
		bloodMetricsSpinner.setBounds(161, 229, 55, 25);
		bloodMetricsSpinner.addChangeListener(this);
		this.add(bloodMetricsSpinner);
	}

	/**
	 * 
	 * Sets group component layout for the detection panel
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
	 * Sets clock value
	 * 
	 * @params counter
	 */
	public void changeClockCounter(double counter) {
		timeTxtField.setText(String.valueOf(counter));
	}

	/**
	 * Sets the detection listener
	 * 
	 * @param detectionListenerService
	 */
	public void setDetectionListenerService(DetectionListenerService detectionListenerService) {
		this.detectionListenerService = detectionListenerService;
	}

	/**
	 * Figures which operation is performed and performs operations on state change
	 * listener
	 * 
	 * @param e
	 *            Contains the event associated to the view
	 */
	@Override
	public void stateChanged(ChangeEvent e) {
//		if (e.getSource() == lowerfaceSpinner) {
//			float lowerfaceValue = (float) ((double) lowerfaceSpinner.getValue());
//			String lowerfaceExp = (String) lowerfaceComboBox.getSelectedItem();
//			detectionListenerService.changeLowerface(lowerfaceExp, lowerfaceValue);
//		} 
//		else if (e.getSource() == upperfaceSpinner) {
//			float upperfaceValue = (float) ((double) upperfaceSpinner.getValue());
//			String upperfaceExp = (String) upperfaceComboBox.getSelectedItem();
//			detectionListenerService.changeUpperface(upperfaceExp, upperfaceValue);
//		} 
		
		if(e.getSource() == systolicBPSpinner)
		{
			float systolicValue = (float)((double) systolicBPSpinner.getValue());
			detectionListenerService.changeSystolic(systolicValue);
		}
		else if(e.getSource() == diastolicBPSpinner) {
			float diastolicValue = (float)((double) diastolicBPSpinner.getValue());
			detectionListenerService.changeDiastolic(diastolicValue);
		}
		else if(e.getSource() == heartBeatSpinner) {
			float heartBeatValue = (float)((double) heartBeatSpinner.getValue());
			detectionListenerService.changeHeartBeat(heartBeatValue);
		}
	}

	/**
	 * Contains the event associated to onclick listener on the view
	 * 
	 * @param e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == bloodMetricsComboBox) {
			float bloodMetricsValue = (float) ((double) bloodMetricsSpinner.getValue());
			String bloodMetricsType = (String) bloodMetricsComboBox.getSelectedItem();
			detectionListenerService.changeBloodMetrics(bloodMetricsType, bloodMetricsValue);
		} 
	}

	/**
	 * Disables the eye active and eye auto reset
	 */
	public void disableActive() {
		
	}
}
