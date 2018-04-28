package server.model;

/**
 * Face Data Model Plain Old Java Class for setting affective and expressive configurations.
 * 
 * @author Team 06
 * @version 1.0
 */
public class FaceData {

	private AffectiveData affectiveData = new AffectiveData();
	private ExpressiveData expressiveData = new ExpressiveData();

	public AffectiveData getAffectiveData() {
		return affectiveData;
	}

	public void setAffectiveData(AffectiveData affectiveData) {
		this.affectiveData = affectiveData;
	}

	public ExpressiveData getExpressiveData() {
		return expressiveData;
	}

	public void setExpressiveData(ExpressiveData expressiveData) {
		this.expressiveData = expressiveData;
	}


}
