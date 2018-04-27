package server.model;

public class ServerDataModel {
	private InteractiveModel interactiveModel;
	private DetectionModel detectionModel;
	private float timestamp;
	public ServerDataModel(DetectionModel detectionModel, InteractiveModel interactiveModel) {
		this.interactiveModel = interactiveModel;
		this.detectionModel = detectionModel;
	}

	public InteractiveModel getInteractiveModel() {
		return interactiveModel;
	}

	public void setInteractiveModel(InteractiveModel interactiveModel) {
		this.interactiveModel = interactiveModel;
	}

	public DetectionModel getDetectionModel() {
		return detectionModel;
	}

	public void setDetectionModel(DetectionModel detectionModel) {
		this.detectionModel = detectionModel;
	}

	public float getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(float timestamp) {
		this.timestamp = timestamp;
	}
}
