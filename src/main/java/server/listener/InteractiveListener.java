package server.listener;

/**
 * Interface for Interactive Panel
 * 
 * @author Team 06
 * @version 1.0
 */
public interface InteractiveListener {

	public void autoResetChange(String stateValue);

	public void stateSpinnerChange(boolean isSelected);

}
