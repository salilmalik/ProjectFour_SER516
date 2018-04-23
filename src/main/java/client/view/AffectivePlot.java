package client.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeriesCollection;

import client.constants.ClientConstants;
import client.model.AffectiveDataModel;
import client.model.AffectivePlotData;

/**
 * The AffectivePlot class sets up the the graph plot for AffectivePanel GUI.
 * 
 * @author Team06
 * @version 1.0
 */
public class AffectivePlot extends JPanel {
	private AffectiveDataModel affectiveDataModel;
	JPanel affectivePanel = new JPanel();
	private GraphPlot graphPlot;
	private Integer length = 50;

	public AffectivePlot(AffectiveDataModel affectiveDataModel) {
		this.setPreferredSize(new Dimension(500, 500));
		this.setLayout(new BorderLayout());
		affectivePanel.setLayout(new GridLayout(1, 1, 1, 1));
		affectivePanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.affectiveDataModel = affectiveDataModel;
		this.add(affectivePanel);
	}

	/**
	 * changedisplayLengthLabel changes label on the graph plot
	 */
	public void changedisplayLengthLabel() {
		plotAffectiveGraph(AffectivePlotData.getInstance().regenerateDataSet());
	}

	/**
	 * plotAffectiveGraph1 method provides implementation of plotting values on
	 * AffectiveGraph
	 * 
	 * @param dataset
	 *            XYSeriesCollection values to plot in 2d
	 */
	public void plotAffectiveGraph(XYSeriesCollection dataset) {
		JFreeChart chart = ChartFactory.createXYLineChart(ClientConstants.EMPTY, ClientConstants.EMPTY,
				ClientConstants.EMPTY, dataset, PlotOrientation.VERTICAL, false, true, false);
		XYPlot plot = chart.getXYPlot();
		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
		ValueAxis range = plot.getRangeAxis();
		range = plot.getDomainAxis();
		range.setRange(0, AffectivePlotData.getInstance().getGraphLength());
		range = plot.getRangeAxis();
		range.setRange(0, 1);
		ArrayList<Color> colors = affectiveDataModel.getAffectiveColors();
		for (int i = 0; i < colors.size(); i++) {
			renderer.setSeriesPaint(i, colors.get(i));
			renderer.setSeriesShapesVisible(i, false);
		}
		plot.setRenderer(renderer);
		plot.setRangeGridlinesVisible(false);
		plot.setDomainGridlinesVisible(false);
		affectivePanel.removeAll();
		affectivePanel.add(new ChartPanel(chart));
		affectivePanel.repaint();
		affectivePanel.revalidate();
	}
}