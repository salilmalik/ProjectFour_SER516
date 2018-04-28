package client.model;

public class BloodMetricsData {
    private float rbc = 0;
    private float wbc = 0;
    private float platelets = 0;
    private float haemoglobin = 0;

    public float getRbc() {
        return rbc;
    }

    public void setRbc(float rbc) {
        this.rbc = rbc;
    }

    public float getWbc() {
        return wbc;
    }

    public void setWbc(float wbc) {
        this.wbc = wbc;
    }

    public float getPlatelets() {
        return platelets;
    }

    public void setPlatelets(float platelets) {
        this.platelets = platelets;
    }

    public float getHaemoglobin() {
        return haemoglobin;
    }

    public void setHaemoglobin(float haemoglobin) {
        this.haemoglobin = haemoglobin;
    }

    @Override
    public String toString() {
        return "BloodMetricsData{" +
                "rbc=" + rbc +
                ", wbc=" + wbc +
                ", platelets=" + platelets +
                ", haemoglobin=" + haemoglobin +
                '}';
    }
}
