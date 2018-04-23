package client.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import client.constants.ClientConstants;
import client.model.AffectiveDataModel;

public class AffectiveGraphView extends JPanel {

	private AffectiveDataModel affectiveDataModel;

	public AffectiveGraphView(AffectiveDataModel affectiveDataModel) {
		this.affectiveDataModel = affectiveDataModel;
	}

	/**
	 * buildPanel function constructs a JPanel at the center for graph plot.
	 * 
	 * @return
	 */
	public JPanel buildPanel() {
		setLayout(new BorderLayout());
		setBackground(ClientConstants.LIGHT_YELLOW);
		JLabel graphPlotLabel = new JLabel(ClientConstants.GRAPH_PLOT, JLabel.CENTER);
		graphPlotLabel.setFont(ClientConstants.TEXT_FONT);
		add(graphPlotLabel, BorderLayout.NORTH);
		setLayout(new BorderLayout());
		AffectivePlot affectiveGraphPlot = new AffectivePlot(affectiveDataModel);
		// ClientDataSingleton.getInstance().setAffectivePlot(affectiveGraphPlot);
		affectiveGraphPlot.setBackground(Color.WHITE);
		add(affectiveGraphPlot);
		return this;
	}
}
