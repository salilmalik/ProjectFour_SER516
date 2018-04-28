package server.services;

import server.constants.ServerConstants;
import server.listener.DetectionListenerInterface;
import server.model.ServerModelSingleton;
import server.view.ServerView;

/**
 * The DetectionListenerService class implements the Detection Listener that changes the nature of data being sent to
 * client for eg. the parameters for upper face , lower face, eye and performance metric values.
 * 
 * @author Team 06
 * @version 1.0
 */
public class DetectionListenerService implements DetectionListenerInterface {
	ServerView serverView;

	/**
	 * changes counter value on serverview
	 * 
	 * @param counter
	 *            for clock value
	 */
	@Override
	public void changeCounter(double counter) {
		serverView.changeClockCounter(counter);
	}

	public void setServerView(ServerView serverView) {
		this.serverView = serverView;
	}

	/**
	 * Updates the lowerface expression data based on the selected combobox and
	 * spinner values.
	 * 
	 * @param exp,
	 *            val exp
	 */

	public void changeLowerface(String exp, float val) {
		resetLowerface();
		if (exp.equals(ServerConstants.SMILE)) {
			ServerModelSingleton.getInstance().getData().getFaceData().getExpressiveData().setSmile(val);
		} else if (exp.equals(ServerConstants.CLENCH)) {
			ServerModelSingleton.getInstance().getData().getFaceData().getExpressiveData().setClench(val);
		} else if (exp.equals(ServerConstants.SMIRK_LEFT)) {
			ServerModelSingleton.getInstance().getData().getFaceData().getExpressiveData().setSmirkLeft(val);
		} else if (exp.equals(ServerConstants.SMIRK_RIGHT)) {
			ServerModelSingleton.getInstance().getData().getFaceData().getExpressiveData().setSmirkRight(val);
		} else if (exp.equals(ServerConstants.LAUGH)) {
			ServerModelSingleton.getInstance().getData().getFaceData().getExpressiveData().setLaugh(val);
		}
	}

	/**
	 * Updates the upperface expression data based on the selected combobox and
	 * spinner values.
	 * 
	 * @param exp,
	 *            float
	 */
	public void changeUpperface(String exp, float val) {
		resetUpperface();
		if (exp.equals(ServerConstants.RAISE_BROW)) {
			ServerModelSingleton.getInstance().getData().getFaceData().getExpressiveData().setRaiseBrow(val);
		} else if (exp.equals(ServerConstants.FURROW_BROW)) {
			ServerModelSingleton.getInstance().getData().getFaceData().getExpressiveData().setFurrowBrow(val);
		}
	}

	/**
	 * Updates the performance Matrics affective data based on the selected combobox
	 * and spinner values.
	 * 
	 * @param exp,val
	 */
	public void changePerformanceMatrics(String exp, float val) {
		resetPerformanceMetrics();
		if (exp.equals(ServerConstants.INTEREST)) {
			ServerModelSingleton.getInstance().getData().getFaceData().getAffectiveData().setInterest(val);
		} else if (exp.equals(ServerConstants.ENGAGEMENT)) {
			ServerModelSingleton.getInstance().getData().getFaceData().getAffectiveData().setEngagement(val);
		} else if (exp.equals(ServerConstants.STRESS)) {
			ServerModelSingleton.getInstance().getData().getFaceData().getAffectiveData().setStress(val);
		} else if (exp.equals(ServerConstants.RELAXATION)) {
			ServerModelSingleton.getInstance().getData().getFaceData().getAffectiveData().setRelaxation(val);
		} else if (exp.equals(ServerConstants.EXCITEMENT)) {
			ServerModelSingleton.getInstance().getData().getFaceData().getAffectiveData().setExcitement(val);
		} else if (exp.equals(ServerConstants.FOCUS)) {
			ServerModelSingleton.getInstance().getData().getFaceData().getAffectiveData().setFocus(val);
		}
	}

	/**
	 * Updates the eye expression data based on the selected combobox values.
	 * 
	 * @param eye
	 *            the current eye value
	 */
	public void changeEye(String eye) {
		resetEye();
		if (eye.equals(ServerConstants.BLINK)) {
			ServerModelSingleton.getInstance().getData().getFaceData().getExpressiveData().setBlink(true);
		} else if (eye.equals(ServerConstants.WINK_LEFT)) {
			ServerModelSingleton.getInstance().getData().getFaceData().getExpressiveData().setWinkLeft(true);
		} else if (eye.equals(ServerConstants.WINK_RIGHT)) {
			ServerModelSingleton.getInstance().getData().getFaceData().getExpressiveData().setWinkRight(true);
		} else if (eye.equals(ServerConstants.LOOK_LEFT)) {
			ServerModelSingleton.getInstance().getData().getFaceData().getExpressiveData().setLookLeft(true);
		} else if (eye.equals(ServerConstants.LOOK_RIGHT)) {
			ServerModelSingleton.getInstance().getData().getFaceData().getExpressiveData().setLookRight(true);
		}
	}

	/**
	 * resets all eye expression data to false
	 */
	public void resetEye() {
		ServerModelSingleton.getInstance().getData().getFaceData().getExpressiveData().setBlink(false);
		ServerModelSingleton.getInstance().getData().getFaceData().getExpressiveData().setWinkLeft(false);
		ServerModelSingleton.getInstance().getData().getFaceData().getExpressiveData().setWinkRight(false);
		ServerModelSingleton.getInstance().getData().getFaceData().getExpressiveData().setLookLeft(false);
		ServerModelSingleton.getInstance().getData().getFaceData().getExpressiveData().setLookRight(false);
	}

	/**
	 * resets all upperface expression data to 0
	 */
	public void resetUpperface() {
		ServerModelSingleton.getInstance().getData().getFaceData().getExpressiveData().setRaiseBrow(0);
		ServerModelSingleton.getInstance().getData().getFaceData().getExpressiveData().setFurrowBrow(0);
	}

	/**
	 * resets all lowerface expression data to 0
	 */
	public void resetLowerface() {
		ServerModelSingleton.getInstance().getData().getFaceData().getExpressiveData().setSmile(0);
		ServerModelSingleton.getInstance().getData().getFaceData().getExpressiveData().setClench(0);
		ServerModelSingleton.getInstance().getData().getFaceData().getExpressiveData().setSmirkLeft(0);
		ServerModelSingleton.getInstance().getData().getFaceData().getExpressiveData().setSmirkRight(0);
		ServerModelSingleton.getInstance().getData().getFaceData().getExpressiveData().setLaugh(0);
	}

	/**
	 * resets all performance Metrics expression data to 0
	 */
	public void resetPerformanceMetrics() {
		ServerModelSingleton.getInstance().getData().getFaceData().getAffectiveData().setInterest(0);
		ServerModelSingleton.getInstance().getData().getFaceData().getAffectiveData().setEngagement(0);
		ServerModelSingleton.getInstance().getData().getFaceData().getAffectiveData().setStress(0);
		ServerModelSingleton.getInstance().getData().getFaceData().getAffectiveData().setRelaxation(0);
		ServerModelSingleton.getInstance().getData().getFaceData().getAffectiveData().setRelaxation(0);
		ServerModelSingleton.getInstance().getData().getFaceData().getAffectiveData().setExcitement(0);
	}

	/**
	 * disables eye checkbox and radio button
	 */
	@Override
	public void disableActive() {
		serverView.disableActive();
	}

	/**
	 * resets Eye checkbox
	 */
	@Override
	public void setEyeAutoResetCheckBox(boolean flag) {
		ServerModelSingleton.getInstance().getData().getFaceData().getExpressiveData().setAutoReset(flag);
	}
	public void changeSystolic(float systolicValue) {
		ServerModelSingleton.getInstance().getData().getHeartData().setSystolicValue(systolicValue);
	}

	public void changeDiastolic(float dystolicValue) {
		ServerModelSingleton.getInstance().getData().getHeartData().setDystolicValue(dystolicValue);
	}

	public void changeHeartBeat(float heartBeatValue) {
		ServerModelSingleton.getInstance().getData().getHeartData().setHeartbeatValue(heartBeatValue);
	}

	public void changeBloodMetrics(String bloodMetricsType, float bloodMetricsValue) {

		resetBloodMetrics();
		if (bloodMetricsType.equals(ServerConstants.RBC)) {
			ServerModelSingleton.getInstance().getData().getHeartData().getBloodMetricsData().
					setRbc(bloodMetricsValue);
		} else if (bloodMetricsType.equals(ServerConstants.WBC)) {
			ServerModelSingleton.getInstance().getData().getHeartData().getBloodMetricsData().
					setWbc(bloodMetricsValue);
		} else if (bloodMetricsType.equals(ServerConstants.PLATELETS)) {
			ServerModelSingleton.getInstance().getData().getHeartData().getBloodMetricsData().
					setPlatelets(bloodMetricsValue);
		} else if (bloodMetricsType.equals(ServerConstants.HAEMO)) {
			ServerModelSingleton.getInstance().getData().getHeartData().getBloodMetricsData().
					setHaemoglobin(bloodMetricsValue);
		}
	}
	public void changeSkinType(String skinType) {
		//resetSkinType();
		if (skinType.equals(ServerConstants.NORMAL)) {
			ServerModelSingleton.getInstance().getData().getSkinData().setSkinType(1);
		} else if (skinType.equals(ServerConstants.DRY)) {
			ServerModelSingleton.getInstance().getData().getSkinData().setSkinType(2);
		} else if (skinType.equals(ServerConstants.OILY)) {
			ServerModelSingleton.getInstance().getData().getSkinData().setSkinType(3);
		} else if (skinType.equals(ServerConstants.COMBINATION)) {
			ServerModelSingleton.getInstance().getData().getSkinData().setSkinType(4);
		}
	}

	public void changeSkinColor(String colorLabelExp) {
		if (colorLabelExp.equals(ServerConstants.FAIR)) {
			ServerModelSingleton.getInstance().getData().getSkinData().setSkinColor(1);
		} else if (colorLabelExp.equals(ServerConstants.DARK)) {
			ServerModelSingleton.getInstance().getData().getSkinData().setSkinColor(2);
		} else if (colorLabelExp.equals(ServerConstants.PINK)) {
			ServerModelSingleton.getInstance().getData().getSkinData().setSkinColor(3);
		} else if (colorLabelExp.equals(ServerConstants.GOLDEN)) {
			ServerModelSingleton.getInstance().getData().getSkinData().setSkinColor(4);
		}
	}

	public void changeSkinSensitivity(String sensitivityExp, float sensitivityValue) {
		resetSkinSensitivity();
		if (sensitivityExp.equals(ServerConstants.DUST)) {
			ServerModelSingleton.getInstance().getData().getSkinData().getSensitivity().setDust(sensitivityValue);
		} else if (sensitivityExp.equals(ServerConstants.COLD)) {
			ServerModelSingleton.getInstance().getData().getSkinData().getSensitivity().setCold(sensitivityValue);
		} else if (sensitivityExp.equals(ServerConstants.HEAT)) {
			ServerModelSingleton.getInstance().getData().getSkinData().getSensitivity().setHot(sensitivityValue);
		}
	}

	private void resetSkinSensitivity() {
		ServerModelSingleton.getInstance().getData().getSkinData().getSensitivity().setCold(0);
		ServerModelSingleton.getInstance().getData().getSkinData().getSensitivity().setHot(0);
		ServerModelSingleton.getInstance().getData().getSkinData().getSensitivity().setDust(0);
	}

	private void resetBloodMetrics() {

		ServerModelSingleton.getInstance().getData().getHeartData().getBloodMetricsData().setRbc(0);
		ServerModelSingleton.getInstance().getData().getHeartData().getBloodMetricsData().setWbc(0);
		ServerModelSingleton.getInstance().getData().getHeartData().getBloodMetricsData().setPlatelets(0);
		ServerModelSingleton.getInstance().getData().getHeartData().getBloodMetricsData().setHaemoglobin(0);
	}
}
