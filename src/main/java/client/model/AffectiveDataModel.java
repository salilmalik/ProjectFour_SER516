package client.model;

import java.awt.Color;
import java.util.ArrayList;

import client.constants.ClientConstants;

public class AffectiveDataModel {
	private Color focusColorDisplay = ClientConstants.FOCUS_COLOR_DEFAULT;
	private Color stressColorDisplay = ClientConstants.STRESS_COLOR_DEFAULT;
	private Color interestColorDisplay = ClientConstants.INTEREST_COLOR_DEFAULT;
	private Color engagementColorDisplay = ClientConstants.ENGAGEMENT_COLOR_DEFAULT;
	private Color relaxationColorDisplay = ClientConstants.RELAXATION_COLOR_DEFAULT;
	private Color excitementColorDisplay = ClientConstants.EXCITEMENT_COLOR_DEFAULT;
	private ArrayList<Color> affectiveColors = new ArrayList<Color>();

	public Color getFocusColorDisplay() {
		return focusColorDisplay;
	}

	public void setFocusColorDisplay(Color focusColorDisplay) {
		this.focusColorDisplay = focusColorDisplay;
	}

	public Color getStressColorDisplay() {
		return stressColorDisplay;
	}

	public void setStressColorDisplay(Color stressColorDisplay) {
		this.stressColorDisplay = stressColorDisplay;
	}

	public Color getInterestColorDisplay() {
		return interestColorDisplay;
	}

	public void setInterestColorDisplay(Color interestColorDisplay) {
		this.interestColorDisplay = interestColorDisplay;
	}

	public Color getEngagementColorDisplay() {
		return engagementColorDisplay;
	}

	public void setEngagementColorDisplay(Color engagementColorDisplay) {
		this.engagementColorDisplay = engagementColorDisplay;
	}

	public Color getRelaxationColorDisplay() {
		return relaxationColorDisplay;
	}

	public void setRelaxationColorDisplay(Color relaxationColorDisplay) {
		this.relaxationColorDisplay = relaxationColorDisplay;
	}

	public Color getExcitementColorDisplay() {
		return excitementColorDisplay;
	}

	public void setExcitementColorDisplay(Color excitementColorDisplay) {
		this.excitementColorDisplay = excitementColorDisplay;
	}

	public ArrayList<Color> getAffectiveColors() {
		return affectiveColors;
	}

	public void setAffectiveColors(ArrayList<Color> affectiveColors) {
		this.affectiveColors = affectiveColors;
	}

}