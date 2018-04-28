package server.model;



public class DetectionModel extends DetectionBaseModel {
	private boolean eyeAutoResetCheckBox;
	private PrimaryDataModel primaryDataModel;



	public DetectionModel(PrimaryDataModel primaryDataModel ){
		this.primaryDataModel = primaryDataModel;
	}
	public boolean isEyeAutoResetCheckBox() {
		return eyeAutoResetCheckBox;
	}

	public void setEyeAutoResetCheckBox(boolean eyeAutoResetCheckBox) {
		this.eyeAutoResetCheckBox = eyeAutoResetCheckBox;
	}

	public PrimaryDataModel getPrimaryDataModel() {
		return primaryDataModel;
	}

	public void setPrimaryDataModel(PrimaryDataModel primaryDataModel) {
		this.primaryDataModel = primaryDataModel;
	}
}
