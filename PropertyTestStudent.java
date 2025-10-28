import static org.junit.Assert.*;
import org.junit.Test;

public class PropertyTestStudent {

    @Test
    public void testDefaultConstructor() {
        Property p = new Property();
        assertEquals("", p.getPropertyName());
        assertEquals("", p.getCity());
        assertEquals(0.0, p.getRentAmount(), 0.001);
        assertEquals("", p.getOwner());
        assertEquals("0,0,1,1", p.getPlot().toString()); // default Plot
    }

    @Test
    public void testFullConstructorWithPlot() {
        Property p = new Property("Villa", "Miami", 2500.0, "Alice", 1, 2, 3, 4);
        assertEquals("Villa", p.getPropertyName());
        assertEquals("Miami", p.getCity());
        assertEquals(2500.0, p.getRentAmount(), 0.001);
        assertEquals("Alice", p.getOwner());
        assertEquals("1,2,3,4", p.getPlot().toString());
    }

    @Test
    public void testFullConstructorWithoutPlot() {
        Property p = new Property("Condo", "Chicago", 1800.0, "Bob");
        assertEquals("Condo", p.getPropertyName());
        assertEquals("Chicago", p.getCity());
        assertEquals(1800.0, p.getRentAmount(), 0.001);
        assertEquals("Bob", p.getOwner());
        assertEquals("0,0,1,1", p.getPlot().toString()); // default Plot
    }

    @Test
    public void testCopyConstructor() {
        Property original = new Property("Cabin", "Denver", 1200.0, "Carol", 5, 5, 2, 2);
        Property copy = new Property(original);
        assertEquals("Cabin", copy.getPropertyName());
        assertEquals("Denver", copy.getCity());
        assertEquals(1200.0, copy.getRentAmount(), 0.001);
        assertEquals("Carol", copy.getOwner());
        assertEquals("5,5,2,2", copy.getPlot().toString());
    }

    @Test
    public void testToString() {
        Property p = new Property("Loft", "Seattle", 3000.0, "Dave", 0, 0, 2, 2);
        assertEquals("Loft,Seattle,Dave,3000.0", p.toString());
    }
}
