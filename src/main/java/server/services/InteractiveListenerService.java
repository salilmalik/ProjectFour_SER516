package server.services;

import server.listener.InteractiveListener;
import server.model.ServerModelSingleton;

/**
 * The InteractiveListenerService class inherits the Interactive Listener for setting the pattern of data send
 * as per the configurations set like auto reset or oe time send.
 * 
 * @author Team 06
 * @version 1.0
 */
public class InteractiveListenerService implements InteractiveListener {

	/**
	 * Changes the state interval according to the auto reset interval timer set
	 */
	@Override
	public void autoResetChange(String stateValue) {
		Double stateInterval = Double.parseDouble(stateValue);
		ServerModelSingleton.getInstance().setStateInterval(stateInterval);
	}

	/**
	 * Changes the send pattern according to auto reset or one time
	 */
	@Override
	public void stateSpinnerChange(boolean isSelected) {
		if (isSelected) {
			ServerModelSingleton.getInstance().setAutoReset(true);
			ServerModelSingleton.getInstance().setOneTimeSend(false);
		} else {
			ServerModelSingleton.getInstance().setAutoReset(false);
			ServerModelSingleton.getInstance().setOneTimeSend(true);
		}
	}
}
