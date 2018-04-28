package server.model;

import server.constants.ServerConstants;

/**
 * ExpressiveData Model Plain Old Java Class for setting individual expressive configurations.
 * 
 * @author Team 06
 * @version 1.0
 */
public class ExpressiveData {
	private float raiseBrow = ServerConstants.ZERO_VALUE;
	private float furrowBrow = ServerConstants.ZERO_VALUE;
	private float smile = ServerConstants.ZERO_VALUE;
	private float clench = ServerConstants.ZERO_VALUE;
	private float smirkLeft = ServerConstants.ZERO_VALUE;
	private float smirkRight = ServerConstants.ZERO_VALUE;
	private float laugh = ServerConstants.ZERO_VALUE;
	private boolean winkLeft = ServerConstants.FALSYVALUE;
	private boolean winkRight = ServerConstants.FALSYVALUE;
	private boolean lookLeft = ServerConstants.FALSYVALUE;
	private boolean lookRight = ServerConstants.FALSYVALUE;
	private boolean blink = ServerConstants.FALSYVALUE;
	private boolean autoReset;

	public boolean isAutoReset() {
		return autoReset;
	}

	public void setAutoReset(boolean autoReset) {
		this.autoReset = autoReset;
	}

	public float getRaiseBrow() {
		return raiseBrow;
	}

	public void setRaiseBrow(float raiseBrow) {
		this.raiseBrow = raiseBrow;
	}

	public float getFurrowBrow() {
		return furrowBrow;
	}

	public void setFurrowBrow(float furrowBrow) {
		this.furrowBrow = furrowBrow;
	}

	public float getSmile() {
		return smile;
	}

	public void setSmile(float smile) {
		this.smile = smile;
	}

	public float getClench() {
		return clench;
	}

	public void setClench(float clench) {
		this.clench = clench;
	}

	public float getSmirkLeft() {
		return smirkLeft;
	}

	public void setSmirkLeft(float smirkLeft) {
		this.smirkLeft = smirkLeft;
	}

	public float getSmirkRight() {
		return smirkRight;
	}

	public void setSmirkRight(float smirkRight) {
		this.smirkRight = smirkRight;
	}

	public float getLaugh() {
		return laugh;
	}

	public void setLaugh(float laugh) {
		this.laugh = laugh;
	}

	public boolean isBlink() {
		return blink;
	}

	public void setBlink(boolean blink) {
		this.blink = blink;
	}

	public boolean isWinkLeft() {
		return winkLeft;
	}

	public void setWinkLeft(boolean winkLeft) {
		this.winkLeft = winkLeft;
	}

	public boolean isWinkRight() {
		return winkRight;
	}

	public void setWinkRight(boolean winkRight) {
		this.winkRight = winkRight;
	}

	public boolean isLookLeft() {
		return lookLeft;
	}

	public void setLookLeft(boolean lookLeft) {
		this.lookLeft = lookLeft;
	}

	public boolean isLookRight() {
		return lookRight;
	}

	public void setLookRight(boolean lookRight) {
		this.lookRight = lookRight;
	}

	/**
	 * Reset wink look and blink values
	 */
	public void resetValues() {
		winkLeft = false;
		winkRight = false;
		lookLeft = false;
		lookRight = false;
		blink = false;
	}
}