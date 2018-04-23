package server.model;

public class InteractiveModel extends InteractiveBaseModel {
	private boolean autoResetCheckBox;
	private String lastTimeStamp;

	public boolean isAutoResetCheckBox() {
		return autoResetCheckBox;
	}

	public void setAutoResetCheckBox(boolean autoResetCheckBox) {
		this.autoResetCheckBox = autoResetCheckBox;
	}

	public String getLastTimeStamp() {
		return lastTimeStamp;
	}

	public void setLastTimeStamp(String lastTimeStamp) {
		this.lastTimeStamp = lastTimeStamp;
	}
}
