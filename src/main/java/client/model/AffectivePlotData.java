package client.model;

import java.util.ArrayList;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import client.constants.ClientConstants;

/**
 * The AffectivePlotData class distributes and stores values into the six
 * affective categories
 * 
 * @author Team06
 * @version 1.0
 */

public class AffectivePlotData {

	private static volatile AffectivePlotData affectivePlotData;
	private static Object mutex = new Object();

	ArrayList<FaceData> faceDataArrayList = new ArrayList<>();
	XYSeriesCollection dataset;

	XYSeries interestSeries = new XYSeries(ClientConstants.INTEREST);
	XYSeries engagementSeries = new XYSeries(ClientConstants.ENGAGEMENT);
	XYSeries relaxSeries = new XYSeries(ClientConstants.RELAXATION);
	XYSeries stressSeries = new XYSeries(ClientConstants.STRESS);
	XYSeries excitmentSeries = new XYSeries(ClientConstants.EXCITEMENT);
	XYSeries focusSeries = new XYSeries(ClientConstants.FOCUS);

	private int graphLength = 50;

	public int getGraphLength() {
		return graphLength;
	}

	public void setGraphLength(int graphLength) {
		this.graphLength = graphLength;
	}

	public static AffectivePlotData getInstance() {
		AffectivePlotData result = affectivePlotData;
		if (result == null) {
			synchronized (mutex) {
				result = affectivePlotData;
				if (result == null) {
					result = new AffectivePlotData();
				}
				affectivePlotData = result;
			}
		}
		return result;
	}

	public XYSeriesCollection getDataset() {
		return dataset;
	}

	/**
	 * setDataToList method sets data received from server into 6 categories
	 * 
	 * @param affectivedata
	 *            : Data received from server
	 * @param faceData
	 *            : data of face received from server
	 */
	public void setDataToList(AffectiveData affectivedata, FaceData faceData) {
		faceDataArrayList.add(faceData);
		double faceDataCounter = faceData.getCounter();
		dataset = new XYSeriesCollection();
		interestSeries.add(graphLength - faceDataCounter, affectivedata.getInterest());
		engagementSeries.add(graphLength - faceDataCounter, affectivedata.getEngagement());
		relaxSeries.add(graphLength - faceDataCounter, affectivedata.getRelaxation());
		stressSeries.add(graphLength - faceDataCounter, affectivedata.getStress());
		excitmentSeries.add(graphLength - faceDataCounter, affectivedata.getExcitement());
		focusSeries.add(graphLength - faceDataCounter, affectivedata.getFocus());
		dataset.addSeries(focusSeries);
		dataset.addSeries(stressSeries);
		dataset.addSeries(interestSeries);
		dataset.addSeries(engagementSeries);
		dataset.addSeries(relaxSeries);
		dataset.addSeries(excitmentSeries);
	}

	/**
	 * regenerateDataSet method generates next values from current values
	 */
	public XYSeriesCollection regenerateDataSet() {
		XYSeries interestSeries = new XYSeries(ClientConstants.INTEREST);
		XYSeries engagementSeries = new XYSeries(ClientConstants.ENGAGEMENT);
		XYSeries relaxSeries = new XYSeries(ClientConstants.RELAXATION);
		XYSeries stressSeries = new XYSeries(ClientConstants.STRESS);
		XYSeries excitmentSeries = new XYSeries(ClientConstants.EXCITEMENT);
		XYSeries focusSeries = new XYSeries(ClientConstants.FOCUS);
		XYSeriesCollection dataset = new XYSeriesCollection();
		for (int i = 0; i < faceDataArrayList.size(); i++) {
			AffectiveData affectiveData = faceDataArrayList.get(i).getAffectiveData();
			double counter = faceDataArrayList.get(i).getCounter();
			interestSeries.add(graphLength - counter, affectiveData.getInterest());
			engagementSeries.add(graphLength - counter, affectiveData.getEngagement());
			relaxSeries.add(graphLength - counter, affectiveData.getRelaxation());
			stressSeries.add(graphLength - counter, affectiveData.getStress());
			excitmentSeries.add(graphLength - counter, affectiveData.getExcitement());
			focusSeries.add(graphLength - counter, affectiveData.getFocus());
		}
		dataset.addSeries(focusSeries);
		dataset.addSeries(stressSeries);
		dataset.addSeries(interestSeries);
		dataset.addSeries(engagementSeries);
		dataset.addSeries(relaxSeries);
		dataset.addSeries(excitmentSeries);
		this.interestSeries = interestSeries;
		this.engagementSeries = engagementSeries;
		this.relaxSeries = relaxSeries;
		this.stressSeries = stressSeries;
		this.excitmentSeries = excitmentSeries;
		this.focusSeries = focusSeries;
		this.dataset = dataset;
		return dataset;
	}
}