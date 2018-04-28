package server.model;

public class ExpressiveDataModel {

    private float raiseBrow = 0;
    private float furrowBrow = 0;
    private float smile = 0;
    private float clench = 0;
    private float smirkLeft = 0;
    private float smirkRight = 0;
    private float laugh = 0;
    private boolean winkLeft = false;
    private boolean winkRight = false;
    private boolean lookLeft = false;
    private boolean lookRight = false;
    private boolean blink = true;

    public float getRaiseBrow() {
        return raiseBrow;
    }

    public void setRaiseBrow(float raiseBrow) {
        this.raiseBrow = raiseBrow;
    }

    public float getFurrowBrow() {
        return furrowBrow;
    }

    public void setFurrowBrow(float furrowBrow) {
        this.furrowBrow = furrowBrow;
    }

    public float getSmile() {
        return smile;
    }

    public void setSmile(float smile) {
        this.smile = smile;
    }

    public float getClench() {
        return clench;
    }

    public void setClench(float clench) {
        this.clench = clench;
    }

    public float getSmirkLeft() {
        return smirkLeft;
    }

    public void setSmirkLeft(float smirkLeft) {
        this.smirkLeft = smirkLeft;
    }

    public float getSmirkRight() {
        return smirkRight;
    }

    public void setSmirkRight(float smirkRight) {
        this.smirkRight = smirkRight;
    }

    public float getLaugh() {
        return laugh;
    }

    public void setLaugh(float laugh) {
        this.laugh = laugh;
    }

    public boolean isBlink() {
        return blink;
    }

    public void setBlink(boolean blink) {
        this.blink = blink;
    }

    public boolean isWinkLeft() {
        return winkLeft;
    }

    public void setWinkLeft(boolean winkLeft) {
        this.winkLeft = winkLeft;
    }

    public boolean isWinkRight() {
        return winkRight;
    }

    public void setWinkRight(boolean winkRight) {
        this.winkRight = winkRight;
    }

    public boolean isLookLeft() {
        return lookLeft;
    }

    public void setLookLeft(boolean lookLeft) {
        this.lookLeft = lookLeft;
    }

    public boolean isLookRight() {
        return lookRight;
    }

    public void setLookRight(boolean lookRight) {
        this.lookRight = lookRight;
    }

    @Override
    public String toString() {
        return "ExpressiveData{" +
                "raiseBrow=" + raiseBrow +
                ", furrowBrow=" + furrowBrow +
                ", smile=" + smile +
                ", clench=" + clench +
                ", smirkLeft=" + smirkLeft +
                ", smirkRight=" + smirkRight +
                ", laugh=" + laugh +
                ", winkLeft=" + winkLeft +
                ", winkRight=" + winkRight +
                ", lookLeft=" + lookLeft +
                ", lookRight=" + lookRight +
                ", blink=" + blink +
                '}';
    }
}
