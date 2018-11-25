package Instruments;


import Behaviours.ISell;

public class Clarinet extends Instrument{
    private String reedType;

    public Clarinet(String colour, String mainMaterial, Type type, double costPrice, double sellPrice) {
        super(colour, mainMaterial, type, costPrice, sellPrice);
        this.reedType = reedType;
    }

    public String getReedType() {
        return reedType;
    }

    public void setReedType(String reedType) {
        this.reedType = reedType;
    }

    public String play() {
        return super.play() + " a Clarinet";
    }

}
