package server.model;

public class HeartData {
    private float systolicValue;
    private float dystolicValue;
    private float heartbeatValue;
    BloodMetricsData bloodMetricsData = new BloodMetricsData();

    public float getSystolicValue() {
        return systolicValue;
    }

    public void setSystolicValue(float systolicValue) {
        this.systolicValue = systolicValue;
    }

    public float getDystolicValue() {
        return dystolicValue;
    }

    public void setDystolicValue(float dystolicValue) {
        this.dystolicValue = dystolicValue;
    }

    public float getHeartbeatValue() {
        return heartbeatValue;
    }

    public void setHeartbeatValue(float heartbeatValue) {
        this.heartbeatValue = heartbeatValue;
    }

    public BloodMetricsData getBloodMetricsData() {
        return bloodMetricsData;
    }

    public void setBloodMetricsData(BloodMetricsData bloodMetricsData) {
        this.bloodMetricsData = bloodMetricsData;
    }
}
