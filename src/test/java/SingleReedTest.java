import AncillaryItems.SingleReed;
import Instruments.Clarinet;
import Instruments.Instrument;
import Instruments.Type;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class SingleReedTest {
    SingleReed singleReed;

    @Before
    public void setUp() throws Exception {
        ArrayList<Instrument> usedWith = new ArrayList<Instrument>();
        singleReed = new SingleReed(7.50, 10.00, "bamboo", usedWith);

    }


    @Test
    public void getCostPrice() {
        assertEquals(7.50, singleReed.getCostPrice(), 0.01);
    }

    @Test
    public void getSellPrice() {
        assertEquals(10.00, singleReed.getSellPrice(), 0.01);
    }

    @Test
    public void getMaterial() {
        assertEquals("bamboo", singleReed.getMaterial());
    }

    @Test
    public void setCostPrice() {
        singleReed.setCostPrice(6.50);
        assertEquals(6.50, singleReed.getCostPrice(), 0.01);
    }

    @Test
    public void setSellPrice() {
        singleReed.setSellPrice(9.00);
        assertEquals(9.00, singleReed.getSellPrice(), 0.01);
    }

    @Test
    public void addInstrument() {
        Clarinet clarinet = new Clarinet("black", "wood", Type.WOODWIND, 1000.00, 1400.00);
        singleReed.addInstrument(clarinet);
        assertEquals(1, singleReed.getArrayLength());
    }

    @Test
    public void canGetMarkup() {
        assertEquals(0.25, singleReed.calculateMarkup(), 0.01);
    }
}
