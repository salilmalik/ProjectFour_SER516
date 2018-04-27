package server.model;

public class InteractiveModel extends InteractiveBaseModel {
	private boolean autoResetCheckBox;
	private float lastTimeStamp;

	public boolean isAutoResetCheckBox() {
		return autoResetCheckBox;
	}

	public void setAutoResetCheckBox(boolean autoResetCheckBox) {
		this.autoResetCheckBox = autoResetCheckBox;
	}

	public float getLastTimeStamp() {
		return lastTimeStamp;
	}

	public void setLastTimeStamp(float lastTimeStamp) {
		this.lastTimeStamp = lastTimeStamp;
	}

}
