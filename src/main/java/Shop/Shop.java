package Shop;

import Behaviours.ISell;
import Instruments.Instrument;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class Shop{
    private ArrayList<ISell> stock;

    public Shop(ArrayList<ISell> stock) {
        this.stock = stock;
    }

    public void addToStock(ISell item){
        this.stock.add(item);
    }

    public void removeFromStock(ISell item){
        this.stock.remove(item);
    }

    public int getstockSize() {
        return this.stock.size();
    }

    //todo count each product method
    public HashMap<String, Double> getItemCount(){
        HashMap<String, Double> itemCount= new HashMap<>();
        String sellItem;
        double count = 0.00;

            for (ISell item : stock) {
                sellItem = item.getClass().getSimpleName();


                if (itemCount.containsKey(sellItem)) {
                    count += 1;
                }
                itemCount.get(sellItem);
                itemCount.put(sellItem, count+1);
            }


        return itemCount;

    }

    //todo these are used to work out the weighting of each item

    public HashMap<String, Double> getWeightings(){
        HashMap<String, Double> itemWeight= new HashMap<>();

        this.getItemCount().forEach((item, count)->{

            Double result = (count/this.getstockSize());
            itemWeight.put(item, result);
        });

        return itemWeight;
    }

    public double sumCostPrice(){
        double sum = 0;
        for(ISell item:stock){sum+=item.getCostPrice();}
        return sum;
    }

    //todo % of total stock that each product accounts for * percentage markup of product. Do the same for each
    //todo  product and get weighted average

    public double getTotalProfit() {
        //this has to be a simplistic version that assume every clarinet is the same otherwise this doesn't work.
        // different makes and quality would give different profit margins but I got to play with hashmaps!
        double totalProfit = 0.00;
        double totalPercentage = 0.00;


        ArrayList<String> alreadyDone = new ArrayList<>();

            for(ISell item:stock){

                if(this.getWeightings().containsKey(item.getClass().getSimpleName())&&(!alreadyDone.contains(item.getClass().getSimpleName()))) {
                    alreadyDone.add(item.getClass().getSimpleName());
                    totalProfit += (((item.calculateMarkup()) * ((this.getWeightings().get(item.getClass().getSimpleName()))))*this.sumCostPrice());

                }

            }

        return totalProfit;
        }


}
