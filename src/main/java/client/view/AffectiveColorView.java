package client.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentListener;

import client.constants.ClientConstants;
import client.model.AffectiveDataModel;

public class AffectiveColorView extends JPanel {
	JButton btnFocus;
	JButton btnStress;
	JButton btnInterest;
	JButton btnEngagement;
	JButton btnRelaxation;
	JButton btnExcitement;
	JPanel focusColorDisplay;
	JPanel stressColorDisplay;
	JPanel interestColorDisplay;
	JPanel engagementColorDisplay;
	JPanel relaxationColorDisplay;
	JPanel excitementColorDisplay;
	JPanel panel7;
	JTextField displayLength;
	JButton buttonComponent;
	private AffectiveDataModel affectiveColorModel;

	public AffectiveColorView(AffectiveDataModel affectiveColorModel) {
		this.affectiveColorModel = affectiveColorModel;
		buildPanel();
	}

	/**
	 * affectivePanelComponents configures the Panel with colors and button
	 * 
	 * @param panelComponent
	 *            Panel object on which other components should be integrated
	 * @param colorComponent
	 *            Color component on Affective Panel
	 * @param buttonComponent
	 *            Button for colors on panel
	 * @return
	 */
	private Component affectivePanelComponents(JPanel panelComponent, Color colorComponent, JButton buttonComponent) {
		Color defaultColorFocus = colorComponent;
		panelComponent.setBackground(defaultColorFocus);
		buttonComponent.setFont(ClientConstants.TEXT_FONT);
		buttonComponent.setPreferredSize(ClientConstants.BUTTON_DIMENSION);
		panelComponent.add(buttonComponent);
		return panelComponent;
	}

	/**
	 * This function builds a panel with 6 performance metrics. They are Focus,
	 * Stress, Interest, Engagement, Relaxation.
	 *
	 * @return returns JPanel object with integrated 6 performance matrix
	 */
	public JPanel buildPanel() {
		setLayout(new BorderLayout());
		setBackground(ClientConstants.LIGHT_BLUE);
		JLabel performanceMetricHead = new JLabel(ClientConstants.PERFORMANCE_METRICS, JLabel.CENTER);
		performanceMetricHead.setFont(ClientConstants.TEXT_FONT);
		add(performanceMetricHead, BorderLayout.NORTH);
		JPanel performanceMetricBody = new JPanel(new GridLayout(4, 2));
		performanceMetricBody.setBackground(ClientConstants.LIGHT_GREY);
		focusColorDisplay = new JPanel();
		btnFocus = new JButton(ClientConstants.FOCUS);
		stressColorDisplay = new JPanel();
		btnStress = new JButton(ClientConstants.STRESS);
		interestColorDisplay = new JPanel();
		btnInterest = new JButton(ClientConstants.INTEREST);
		engagementColorDisplay = new JPanel();
		btnEngagement = new JButton(ClientConstants.ENGAGEMENT);
		relaxationColorDisplay = new JPanel();
		btnRelaxation = new JButton(ClientConstants.RELAXATION);
		excitementColorDisplay = new JPanel();
		btnExcitement = new JButton(ClientConstants.EXCITEMENT);
		performanceMetricBody
				.add(affectivePanelComponents(focusColorDisplay, ClientConstants.FOCUS_COLOR_DEFAULT, btnFocus));
		performanceMetricBody
				.add(affectivePanelComponents(stressColorDisplay, ClientConstants.STRESS_COLOR_DEFAULT, btnStress));
		performanceMetricBody.add(
				affectivePanelComponents(interestColorDisplay, ClientConstants.INTEREST_COLOR_DEFAULT, btnInterest));
		performanceMetricBody.add(affectivePanelComponents(engagementColorDisplay,
				ClientConstants.ENGAGEMENT_COLOR_DEFAULT, btnEngagement));
		performanceMetricBody.add(affectivePanelComponents(relaxationColorDisplay,
				ClientConstants.RELAXATION_COLOR_DEFAULT, btnRelaxation));
		performanceMetricBody.add(affectivePanelComponents(excitementColorDisplay,
				ClientConstants.EXCITEMENT_COLOR_DEFAULT, btnExcitement));
		JPanel displayLengthPanel = new JPanel(new GridBagLayout());
		displayLength = new JTextField(10);
		displayLength.setText(String.valueOf(50));
		displayLengthPanel.add(displayLength, setConstraints(displayLengthPanel));
		performanceMetricBody.add(displayLengthPanel);
		performanceMetricBody.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		performanceMetricBody.setBorder(BorderFactory.createEtchedBorder());
		add(performanceMetricBody, BorderLayout.CENTER);
		return this;
	}

	/**
	 * setConstraints method configures the UI constraints on Panel object
	 * 
	 * @param displayLengthPanel
	 *            panel object to set constraints
	 * @return Panel object with constraints
	 */
	private GridBagConstraints setConstraints(JPanel displayLengthPanel) {
		displayLengthPanel.setBackground(ClientConstants.LIGHT_GREY);
		GridBagConstraints displayLengthDimensions = new GridBagConstraints();
		displayLengthDimensions.gridx = 0;
		displayLengthDimensions.gridy = 0;
		JLabel displayLengthLabel = new JLabel(ClientConstants.DISPLAY_LENGTH);
		displayLengthLabel.setFont(ClientConstants.TEXT_FONT);
		displayLengthPanel.add(displayLengthLabel, displayLengthDimensions);
		displayLengthDimensions.gridx = 1;
		displayLengthDimensions.gridy = 0;
		return displayLengthDimensions;
	}

	public void updateBackground() {
		focusColorDisplay.setBackground(affectiveColorModel.getFocusColorDisplay());
		interestColorDisplay.setBackground(affectiveColorModel.getInterestColorDisplay());
		stressColorDisplay.setBackground(affectiveColorModel.getStressColorDisplay());
		engagementColorDisplay.setBackground(affectiveColorModel.getEngagementColorDisplay());
		excitementColorDisplay.setBackground(affectiveColorModel.getExcitementColorDisplay());
		relaxationColorDisplay.setBackground(affectiveColorModel.getRelaxationColorDisplay());
	}

	public void addLengthListener(DocumentListener documentListener) {
		displayLength.getDocument().addDocumentListener(documentListener);
	}

	public JTextField getDisplayLength() {
		return displayLength;
	}

	public void setDisplayLength(JTextField displayLength) {
		this.displayLength = displayLength;
	}

	public void addFocusButtonListener(ActionListener actionListener) {
		btnFocus.addActionListener(actionListener);
	}

	public void addStressButtonListener(ActionListener actionListener) {
		btnStress.addActionListener(actionListener);
	}

	public void addInterestButtonListener(ActionListener actionListener) {
		btnInterest.addActionListener(actionListener);
	}

	public void addEngagementButtonListener(ActionListener actionListener) {
		btnEngagement.addActionListener(actionListener);
	}

	public void addRelaxationButtonListener(ActionListener actionListener) {
		btnRelaxation.addActionListener(actionListener);
	}

	public void addExcitementButtonListener(ActionListener actionListener) {
		btnExcitement.addActionListener(actionListener);
	}
}