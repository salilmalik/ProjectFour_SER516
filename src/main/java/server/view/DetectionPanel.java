package server.view;

import server.services.DetectionListenerService;

public interface DetectionPanel{
	
	public void changeClockCounter(double counter);
	public void setDetectionListenerService(DetectionListenerService detectionListenerService);
	public void disableActive();
}
