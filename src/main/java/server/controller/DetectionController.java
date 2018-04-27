package server.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import server.model.DetectionModel;
import server.view.DetectionView;

public class DetectionController {

	private DetectionView detectionView;
	private DetectionModel detectionModel;
	
	public DetectionController(DetectionView detectionView, DetectionModel detectionModel) {
		this.detectionModel = detectionModel;
		this.detectionView = detectionView;
		this.detectionView.addDetectionActionListeners(new DetectionListener());
		this.detectionView.addDetectionChangeListener(new DetectionListener());
	}

	public class DetectionListener implements ActionListener, ChangeListener{

		@Override
		public void stateChanged(ChangeEvent e) {
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
		}
		
	}
}
