package AncillaryItems;

import Behaviours.ISell;
import Instruments.Instrument;

import java.util.ArrayList;

public abstract class AncillaryItem implements ISell {

    private double costPrice;
    private double sellPrice;
    private String material;
    private ArrayList<Instrument> usedWith;

    public AncillaryItem(double costPrice, double sellPrice, String material, ArrayList<Instrument> usedWith) {
        this.costPrice = costPrice;
        this.sellPrice = sellPrice;
        this.material = material;
        this.usedWith = new ArrayList<Instrument>();
    }

    public double getCostPrice() {
        return costPrice;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public String getMaterial() {
        return material;
    }

    public void setCostPrice(double costPrice) {
        this.costPrice = costPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public void addInstrument(Instrument instrument){
        this.usedWith.add(instrument);
    }

    public int getArrayLength(){
        return this.usedWith.size();
    }
    public double calculateMarkup(){
        return (this.getSellPrice()-this.getCostPrice())/this.getCostPrice();
    }
}
