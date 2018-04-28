package server.listener;

/**
 * DetectionListenerInterface interface
 * 
 * @author Team 06
 * @version 1.0
 */
public interface DetectionListenerInterface {

	/**
	 * Changes the clock counter
	 * 
	 * @param counter
	 */
	public void changeCounter(double counter);

	/**
	 * implement to changes lower face value
	 * 
	 * @param exp
	 * @param val
	 */
	public void changeLowerface(String exp, float val);

	/**
	 * implement to Change upper face values
	 * 
	 * @param exp
	 * @param val
	 */

	public void changeUpperface(String exp, float val);

	/**
	 * Implement to Change performance metric values
	 * 
	 * @param exp
	 * @param val
	 */
	public void changePerformanceMatrics(String exp, float val);

	/**
	 * Implement to Change eye values
	 * 
	 * @param eye
	 */
	public void changeEye(String eye);

	/**
	 * Implement to Reset eye values
	 */
	public void resetEye();

	/**
	 * Implement to Reset upper face values
	 */
	public void resetUpperface();

	/**
	 * Implement to reset lower face values
	 */
	public void resetLowerface();

	/**
	 * Implement to reset performance metrics
	 */
	public void resetPerformanceMetrics();

	/**
	 * Implement to disable active values
	 */
	public void disableActive();

	/**
	 * Implement to set Eye auto reset checkbox
	 */
	void setEyeAutoResetCheckBox(boolean b);
}
