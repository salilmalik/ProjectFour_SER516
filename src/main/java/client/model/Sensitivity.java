package client.model;

public class Sensitivity {
    private String hot;
    private String cold;

    public String getHot() {
        return hot;
    }

    public void setHot(String hot) {
        this.hot = hot;
    }

    public String getCold() {
        return cold;
    }

    public void setCold(String cold) {
        this.cold = cold;
    }

    public String getDust() {
        return dust;
    }

    public void setDust(String dust) {
        this.dust = dust;
    }

    private String dust;

    @Override
    public String toString() {
        return "Sensitivity{" +
                "hot='" + hot + '\'' +
                ", cold='" + cold + '\'' +
                ", dust='" + dust + '\'' +
                '}';
    }
}
