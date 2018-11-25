import Instruments.Type;
import org.junit.Before;
import org.junit.Test;
import Instruments.Clarinet;
import org.junit.experimental.theories.suppliers.TestedOn;


import static org.junit.Assert.assertEquals;


public class ClarinetTest {

    Clarinet clarinet;

    @Before
    public void setUp() throws Exception {
        clarinet = new Clarinet("black", "wood", Type.WOODWIND, 590.99, 650.00);
        clarinet.setReedType("single");
    }

    @Test
    public void getReedType() {
        assertEquals("single", clarinet.getReedType());
    }

    @Test
    public void setReedType() {
        clarinet.setReedType("double");
        assertEquals("double", clarinet.getReedType());

    }

    @Test
    public void getCostprice(){
        assertEquals(590.99, clarinet.getCostPrice(), 0.01);
    }

    @Test
    public void setCostPrice(){
        clarinet.setCostPrice(400.0);
        assertEquals(400.00, clarinet.getCostPrice(), 0.01);

    }
    @Test
    public void play() {
        assertEquals("Sounds like a Clarinet", clarinet.play());
    }

    @Test
    public void getColour() {
        assertEquals("black", clarinet.getColour());
    }

    @Test
    public void getMainMaterial() {
        assertEquals("wood", clarinet.getMainMaterial());
    }

    @Test
    public void getType() {
        assertEquals("WOODWIND", clarinet.getType().toString());
    }

    @Test
    public void getSellPrice() {
        assertEquals(650.00, clarinet.getSellPrice(), 0.01);
    }


    @Test
    public void setSellPrice() {
        clarinet.setSellPrice(700.00);
        assertEquals(700.00, clarinet.getSellPrice(), 0.01);
    }

    @Test
    public void getMarkup() {
        Clarinet clarinet1;
        clarinet1 = new Clarinet("Green", "wood", Type.WOODWIND, 500, 1000);
        assertEquals(1.00, clarinet1.calculateMarkup(), 0.01);
    }
}