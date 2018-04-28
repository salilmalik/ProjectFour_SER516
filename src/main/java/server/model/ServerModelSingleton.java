package server.model;

import server.constants.ServerConstants;

/**
 * ServerModelSingleton classkeeps Server Configurations
 * 
 * @author Team 06
 * @version 1.0
 */
public class ServerModelSingleton {
	private static volatile ServerModelSingleton serverDataSingleton;
	private static Object mutex = new Object();
	private Data data = new Data();
	private boolean autoReset = ServerConstants.AUTO_RESET;
	private double stateInterval = ServerConstants.STATE_INTERVAL;
	private boolean oneTimeSend = ServerConstants.ONE_TIME_SEND;

	public static ServerModelSingleton getInstance() {
		ServerModelSingleton result = serverDataSingleton;
		if (result == null) {
			synchronized (mutex) {
				result = serverDataSingleton;
				if (result == null) {
					result = new ServerModelSingleton();
				}
				serverDataSingleton = result;
			}
		}
		return result;
	}

	public double getStateInterval() {
		return stateInterval;
	}

	public void setStateInterval(double stateInterval) {
		this.stateInterval = stateInterval;
	}

	public boolean isOneTimeSend() {
		return oneTimeSend;
	}

	public void setOneTimeSend(boolean oneTimeSend) {
		this.oneTimeSend = oneTimeSend;
	}

	public boolean isAutoReset() {
		return autoReset;
	}

	public void setAutoReset(boolean autoReset) {
		this.autoReset = autoReset;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}
}
