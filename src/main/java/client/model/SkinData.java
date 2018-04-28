package client.model;

import server.model.Sensitivity;

public class SkinData {
    private String skinColor;
    private String skinType;
    Sensitivity sensitivity = new Sensitivity();

    public String getSkinColor() {
        return skinColor;
    }

    public void setSkinColor(String skinColor) {
        this.skinColor = skinColor;
    }

    public String getSkinType() {
        return skinType;
    }

    public void setSkinType(String skinType) {
        this.skinType = skinType;
    }

    public Sensitivity getSensitivity() {
        return sensitivity;
    }

    public void setSensitivity(Sensitivity sensitivity) {
        this.sensitivity = sensitivity;
    }

    @Override
    public String toString() {
        return "SkinData{" +
                "skinColor='" + skinColor + '\'' +
                ", skinType='" + skinType + '\'' +
                ", sensitivity=" + sensitivity +
                '}';
    }
}
