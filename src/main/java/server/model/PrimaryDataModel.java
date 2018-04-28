package server.model;

public class PrimaryDataModel {
    private float counter;
    private AffectiveDataModel affectiveDataModel;
    private ExpressiveDataModel expressiveDataModel;

    public PrimaryDataModel(AffectiveDataModel affectiveDataModel, ExpressiveDataModel expressiveDataModel) {
        this.affectiveDataModel = affectiveDataModel;
        this.expressiveDataModel = expressiveDataModel;
    }

    public float getCounter() {
        return counter;
    }

    public void setCounter(float counter) {
        this.counter = counter;
    }

    public AffectiveDataModel getAffectiveDataModel() {
        return affectiveDataModel;
    }

    public void setAffectiveDataModel(AffectiveDataModel affectiveDataModel) {
        this.affectiveDataModel = affectiveDataModel;
    }

    public ExpressiveDataModel getExpressiveDataModel() {
        return expressiveDataModel;
    }

    public void setExpressiveDataModel(ExpressiveDataModel expressiveDataModel) {
        this.expressiveDataModel = expressiveDataModel;
    }
}
