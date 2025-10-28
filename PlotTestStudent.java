import static org.junit.Assert.*;
import org.junit.Test;

public class PlotTestStudent {

    @Test
    public void testConstructorAndToString() {
        Plot plot = new Plot(2, 3, 10, 15);
        assertEquals("2,3,10,15", plot.toString());
    }

    @Test
    public void testOverlaps() {
        Plot p1 = new Plot(0, 0, 5, 5);
        Plot p2 = new Plot(3, 3, 5, 5);
        assertTrue(p1.overlaps(p2));
    }

    @Test
    public void testEncompasses() {
        Plot outer = new Plot(0, 0, 10, 10);
        Plot inner = new Plot(2, 2, 5, 5);
        assertTrue(outer.encompasses(inner));
    }
}
