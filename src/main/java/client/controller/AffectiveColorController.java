package client.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import client.constants.ClientConstants;
import client.model.AffectiveDataModel;
import client.view.AffectiveColorView;

public class AffectiveColorController {
	private AffectiveColorView affectiveColorView;
	private AffectiveDataModel affectiveDataModel;

	public AffectiveColorView getAffectiveColorView() {
		return affectiveColorView;
	}

	public void setAffectiveColorView(AffectiveColorView affectiveColorView) {
		this.affectiveColorView = affectiveColorView;
	}

	public AffectiveDataModel getAffectiveColorModel() {
		return affectiveDataModel;
	}

	public void setAffectiveColorModel(AffectiveDataModel affectiveColorModel) {
		this.affectiveDataModel = affectiveColorModel;
	}

	public AffectiveColorController(AffectiveColorView affectiveColorView, AffectiveDataModel affectiveColorModel) {
		this.affectiveColorView = affectiveColorView;
		this.affectiveDataModel = affectiveColorModel;
		this.affectiveColorView.addLengthListener(new AffectiveColorListener());
		this.affectiveColorView.addFocusButtonListener(new AffectiveColorListener());
		this.affectiveColorView.addStressButtonListener(new AffectiveColorListener());
		this.affectiveColorView.addInterestButtonListener(new AffectiveColorListener());
		this.affectiveColorView.addRelaxationButtonListener(new AffectiveColorListener());
		this.affectiveColorView.addExcitementButtonListener(new AffectiveColorListener());
		this.affectiveColorView.addEngagementButtonListener(new AffectiveColorListener());
		setDataModelColor();
	}

	private void setDataModelColor() {
		ArrayList<Color> affectiveColors = new ArrayList<Color>();
		affectiveColors.add(affectiveDataModel.getFocusColorDisplay());
		affectiveColors.add(affectiveDataModel.getStressColorDisplay());
		affectiveColors.add(affectiveDataModel.getInterestColorDisplay());
		affectiveColors.add(affectiveDataModel.getEngagementColorDisplay());
		affectiveColors.add(affectiveDataModel.getRelaxationColorDisplay());
		affectiveColors.add(affectiveDataModel.getExcitementColorDisplay());
		affectiveDataModel.setAffectiveColors(affectiveColors);
	}

	public class AffectiveColorListener implements DocumentListener, ActionListener {

		@Override
		public void changedUpdate(DocumentEvent e) {
			changedisplayLengthLabel(affectiveColorView.getDisplayLength().getText());
		}

		@Override
		public void insertUpdate(DocumentEvent e) {
			changedisplayLengthLabel(affectiveColorView.getDisplayLength().getText());
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			changedisplayLengthLabel(affectiveColorView.getDisplayLength().getText());
		}

		public void changedisplayLengthLabel(String text) {
			try {
				// AffectivePlotData.getInstance().setGraphLength(Integer.parseInt(text));
				// clientWindow.changedisplayLengthLabel();
			} catch (Exception e) {
			}
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			Color color = JColorChooser.showDialog(null, ClientConstants.CHOOSE_COLOR, null);
			if (((JButton) e.getSource()).getText() == ClientConstants.FOCUS) {
				affectiveDataModel.setFocusColorDisplay(color);
			} else if (((JButton) e.getSource()).getText() == ClientConstants.STRESS) {
				affectiveDataModel.setStressColorDisplay(color);
			} else if (((JButton) e.getSource()).getText() == ClientConstants.INTEREST) {
				affectiveDataModel.setInterestColorDisplay(color);
			} else if (((JButton) e.getSource()).getText() == ClientConstants.ENGAGEMENT) {
				affectiveDataModel.setEngagementColorDisplay(color);
			} else if (((JButton) e.getSource()).getText() == ClientConstants.RELAXATION) {
				affectiveDataModel.setRelaxationColorDisplay(color);
			} else if (((JButton) e.getSource()).getText() == ClientConstants.EXCITEMENT) {
				affectiveDataModel.setExcitementColorDisplay(color);
			}
			affectiveColorView.updateBackground();
			setDataModelColor();
		}
	}
}