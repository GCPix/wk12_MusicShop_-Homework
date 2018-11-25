package AncillaryItems;

import Instruments.Instrument;

import java.util.ArrayList;

public class SingleReed extends AncillaryItem{
    public SingleReed(double costPrice, double sellPrice, String material, ArrayList<Instrument> usedWith) {
        super(costPrice, sellPrice, material, usedWith);
    }
}
