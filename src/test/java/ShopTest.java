import AncillaryItems.SingleReed;
import Behaviours.ISell;
import Instruments.Clarinet;
import Instruments.Instrument;
import Instruments.Type;
import Shop.Shop;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class ShopTest {
    Clarinet clarinet;
    Shop shop;
    SingleReed singleReed;

    @Before
    public void setUp() throws Exception {
        clarinet = new Clarinet("Blue", "wood", Type.WOODWIND,500, 1000);
        ArrayList<Instrument> usedWith = new ArrayList<Instrument>();
        singleReed = new SingleReed(7.50, 10.00, "wood", usedWith);
        ArrayList<ISell> stock = new ArrayList<ISell>();
         shop = new Shop(stock);
    }
    @Test
    public void getstockSize() {
        shop.addToStock(clarinet);
        assertEquals(1, shop.getstockSize());
    }

    @Test
    public void addToStock() {
        shop.addToStock(clarinet);
        assertEquals(1, shop.getstockSize());
    }

    @Test
    public void removeFromStock() {
        shop.addToStock(singleReed);
        shop.addToStock(clarinet);
        shop.removeFromStock(clarinet);
        assertEquals(1, shop.getstockSize());
    }

    @Test
    public void canCalculateProfit() {
        shop.addToStock(singleReed);
        shop.addToStock(clarinet);
        assertEquals(502.50, shop.getTotalProfit(), 0.01);
    }



    @Test
    public void getItemCount() {
        shop.addToStock(singleReed);
        shop.addToStock(clarinet);
        shop.addToStock(clarinet);
        HashMap<String, Double> expected = new HashMap<String, Double>() {
            {
                put("SingleReed", 1.0);
                put("Clarinet", 2.0);
            }
        };
        assertEquals(expected, shop.getItemCount());
    }

    @Test
    public void getItemWeighting() {
        shop.addToStock(singleReed);
        shop.addToStock(clarinet);
        shop.addToStock(clarinet);
        shop.getItemCount();
        HashMap<String, Double> expected = new HashMap<String, Double>() {
            {
                put("SingleReed", 0.3333);
                put("Clarinet", 0.6666);
            }
        };
        assertEquals(expected, shop.getWeightings());

    }

    @Test
    public void getTotalProfit() {
        shop.addToStock(singleReed);
        shop.addToStock(clarinet);
//        shop.addToStock(clarinet);


        assertEquals(1002.50, shop.getTotalProfit(), 0.01);
    }


    @Test
    public void sumCostPrice() {
        shop.addToStock(singleReed);
        shop.addToStock(singleReed);
        shop.addToStock(singleReed);
        shop.addToStock(singleReed);
        shop.addToStock(singleReed);
        shop.addToStock(singleReed);
        shop.addToStock(clarinet);

        assertEquals(545.00, shop.sumCostPrice(),0.01);
    }
}
