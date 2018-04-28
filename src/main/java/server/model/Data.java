package server.model;

public class Data {
    private double counter = 0;
    private FaceData faceData = new FaceData();
    private HeartData heartData = new HeartData();
    private SkinData skinData = new SkinData();

    public FaceData getFaceData() {
        return faceData;
    }

    public void setFaceData(FaceData faceData) {
        this.faceData = faceData;
    }

    public HeartData getHeartData() {
        return heartData;
    }

    public void setHeartData(HeartData heartData) {
        this.heartData = heartData;
    }

    public SkinData getSkinData() {
        return skinData;
    }

    public void setSkinData(SkinData skinData) {
        this.skinData = skinData;
    }

    public double getCounter() {
        return counter;
    }

    public void setCounter(double counter) {
        this.counter = counter;
    }
}
