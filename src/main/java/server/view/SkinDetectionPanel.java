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
 * clock timer along with the colorLabel, sensitivity and skinType features, also
 * setting the Performance metrics.
 * 
 * @author Team 06
 * @version 1.0
 */
public class SkinDetectionPanel extends JPanel implements ChangeListener, ActionListener ,DetectionPanel {

    JTextField timeTxtField;
    JComboBox<String> colorComboBox;
    JSpinner colorLabelSpinner;
    JComboBox<String> sensitivityComboBox;
    JComboBox<String> skinTypeComboBox;
    JCheckBox skinTypeAutoResetCheckBox;
    JCheckBox activateCheckBox;
    JRadioButton skinTypeActivateRadioButton;
    JComboBox<String> performanceMetricsComboBox;
    JSpinner performanceMetricsSpinner;
    DetectionListenerService detectionListenerService;
    JSpinner sensitivitySpinner;

    /**
     * Design and component setting for the detection panel
     */
    public SkinDetectionPanel(Color color) {
        this.setBackground(color);
        this.setBorder(new TitledBorder(null, ServerConstants.DETECTION, TitledBorder.LEADING, TitledBorder.TOP,
                ServerConstants.TEXT_FONT, null));
        this.setBounds(11, 130, 474, 267);
        this.setLayout(null);
        timeDetectionPanelSetup();
        colorPanel();
        sensitivityPanel();
        skinTypePanel();
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
     * colorLabelDetectionPanel sets up the detection panel UI for the upper face
     */
    private void colorPanel() {
        JLabel colorLabel = new JLabel(ServerConstants.COLOUR);
        colorLabel.setFont(ServerConstants.TEXT_FONT);
        colorLabel.setForeground(Color.WHITE);
        colorLabel.setBounds(14, 68, 139, 33);
        this.add(colorLabel);
        String[] colorItems = new String[] { ServerConstants.FAIR, ServerConstants.DARK, ServerConstants.PINK, ServerConstants.GOLDEN };
        colorComboBox = new JComboBox<>(colorItems);
        colorComboBox.setBounds(14, 98, 139, 25);
        colorComboBox.addActionListener(this);
        this.add(colorComboBox);
        /*colorLabelSpinner = new JSpinner();
        colorLabelSpinner.setModel(new SpinnerNumberModel(0.00, 0.00, 1.00, 0.1));
        colorLabelSpinner.setBackground(Color.WHITE);
        colorLabelSpinner.setBounds(161, 97, 55, 25);
//      colorLabelSpinner.addChangeListener(this);
        this.add(colorLabelSpinner);*/
    }

    /**
     * sensitivityDetectionPanelSetup sets up the detection panel UI for the lower
     * face
     */
    private void sensitivityPanel() {
        JLabel sensitivity = new JLabel(ServerConstants.SENSITIVITY);
        sensitivity.setFont(ServerConstants.TEXT_FONT);
        sensitivity.setForeground(Color.WHITE);
        sensitivity.setBounds(250, 68, 73, 33);
        this.add(sensitivity);
        String[] sensitivityItems = new String[] { ServerConstants.DUST, ServerConstants.HEAT,
                ServerConstants.COLD};
        sensitivityComboBox = new JComboBox<>(sensitivityItems);
        sensitivityComboBox.setBounds(250, 98, 123, 25);
        sensitivityComboBox.addActionListener(this);
        this.add(sensitivityComboBox);
        sensitivitySpinner = new JSpinner();
        sensitivitySpinner.setModel(new SpinnerNumberModel(0.00, 0.00, 1.00, 0.1));
        sensitivitySpinner.setForeground(Color.WHITE);
        sensitivitySpinner.setBounds(383, 97, 52, 25);
        sensitivitySpinner.addChangeListener(this);
        this.add(sensitivitySpinner);
    }

    /**
     * skinTypePanelSetup sets up the detection panel UI for the skinType
     */
    private void skinTypePanel() {
        JLabel skinType = new JLabel(ServerConstants.SKIN_TYPE);
        skinType.setFont(ServerConstants.TEXT_FONT);
        skinType.setForeground(Color.WHITE);
        skinType.setBounds(14, 134, 115, 33);
        this.add(skinType);
        String[] skinTypeItems = new String[] { ServerConstants.NORMAL, ServerConstants.DRY, ServerConstants.OILY,
                ServerConstants.COMBINATION};
        skinTypeComboBox = new JComboBox<>(skinTypeItems);
        skinTypeComboBox.setBounds(14, 163, 139, 25);
        skinTypeComboBox.addActionListener(this);
        this.add(skinTypeComboBox);
/*        skinTypeActivateRadioButton = new JRadioButton(ServerConstants.ACTIVATE);
        skinTypeActivateRadioButton.setFont(ServerConstants.TEXT_FONT);
        skinTypeActivateRadioButton.setBackground(Color.GRAY);
        skinTypeActivateRadioButton.setForeground(Color.WHITE);
        skinTypeActivateRadioButton.setBounds(185, 164, 95, 25);
        skinTypeActivateRadioButton.addActionListener(this);
        this.add(skinTypeActivateRadioButton);
       */
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
        if (e.getSource() == sensitivitySpinner) {
            float sensitivityValue = (float) ((double) sensitivitySpinner.getValue());
            String sensitivityExp = (String) sensitivityComboBox.getSelectedItem();
            detectionListenerService.changeSkinSensitivity(sensitivityExp, sensitivityValue);
        }
    }

    /**
     * Contains the event associated to onclick listener on the view
     * 
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == colorComboBox) {
            String colorLabelExp = (String) colorComboBox.getSelectedItem();
            detectionListenerService.changeSkinColor(colorLabelExp);
        } else if (e.getSource() == sensitivityComboBox) {
            float sensitivityValue = (float) ((double) sensitivitySpinner.getValue());
            String sensitivityExp = (String) sensitivityComboBox.getSelectedItem();
            detectionListenerService.changeSkinSensitivity(sensitivityExp, sensitivityValue);
        }else if (e.getSource() == skinTypeComboBox) {
            String skinType = (String) skinTypeComboBox.getSelectedItem();
            if (skinTypeActivateRadioButton.isSelected()) {
                detectionListenerService.changeSkinType(skinType);
            }
        } else if (e.getSource() == skinTypeActivateRadioButton) {
            String skinType = (String) skinTypeComboBox.getSelectedItem();
            if (skinTypeActivateRadioButton.isSelected()) {
                detectionListenerService.changeSkinType(skinType);
            }
        }
    }

    /**
     * Disables the skinType active and skinType auto reset
     */
    public void disableActive() {
        skinTypeActivateRadioButton.setSelected(false);
    }
}
