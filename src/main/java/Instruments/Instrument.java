package Instruments;

import Behaviours.IPlay;
import Behaviours.ISell;

public abstract class Instrument implements IPlay, ISell {
    private String colour;
    private String mainMaterial;
    private Type type;
    private double costPrice;
    private double sellPrice;

    public Instrument(String colour, String mainMaterial, Type type, double costPrice, double sellPrice) {
        this.colour = colour;
        this.mainMaterial = mainMaterial;
        this.type = type;
        this.costPrice = costPrice;
        this.sellPrice = sellPrice;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setCostPrice(double costPrice) {
        this.costPrice = costPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getColour() {
        return colour;
    }

    public String getMainMaterial() {
        return mainMaterial;
    }

    public Type getType() {
        return type;
    }

    public String play(){
        return "Sounds like";
    }

    public double calculateMarkup(){
        return ((this.getSellPrice()/this.getCostPrice())-1);
    }
}
