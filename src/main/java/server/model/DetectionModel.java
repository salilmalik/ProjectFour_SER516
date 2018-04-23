package server.model;

public class DetectionModel extends DetectionBaseModel {
	private float lowerfaceValue;
	private String lowerfaceExp;
	private float upperfaceValue;
	private String upperfaceExp;
	private float metricsValue;
	private String metricsExp;
	private String eye;
	private boolean eyeAutoResetCheckBox;

	public boolean isEyeAutoResetCheckBox() {
		return eyeAutoResetCheckBox;
	}

	public void setEyeAutoResetCheckBox(boolean eyeAutoResetCheckBox) {
		this.eyeAutoResetCheckBox = eyeAutoResetCheckBox;
	}

	public String getEye() {
		return eye;
	}

	public void setEye(String eye) {
		this.eye = eye;
	}

	public float getLowerfaceValue() {
		return lowerfaceValue;
	}

	public void setLowerfaceValue(float lowerfaceValue) {
		this.lowerfaceValue = lowerfaceValue;
	}

	public String getLowerfaceExp() {
		return lowerfaceExp;
	}

	public void setLowerfaceExp(String lowerfaceExp) {
		this.lowerfaceExp = lowerfaceExp;
	}

	public float getUpperfaceValue() {
		return upperfaceValue;
	}

	public void setUpperfaceValue(float upperfaceValue) {
		this.upperfaceValue = upperfaceValue;
	}

	public String getUpperfaceExp() {
		return upperfaceExp;
	}

	public void setUpperfaceExp(String upperfaceExp) {
		this.upperfaceExp = upperfaceExp;
	}

	public float getMetricsValue() {
		return metricsValue;
	}

	public void setMetricsValue(float metricsValue) {
		this.metricsValue = metricsValue;
	}

	public String getMetricsExp() {
		return metricsExp;
	}

	public void setMetricsExp(String metricsExp) {
		this.metricsExp = metricsExp;
	}
}
