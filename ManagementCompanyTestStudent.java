import static org.junit.Assert.*;
import org.junit.Test;

public class ManagementCompanyTestStudent {

    @Test
    public void testConstructorAndGetters() {
        ManagementCompany mc = new ManagementCompany("AlphaMgmt", "123456789", 10.0);
        assertEquals("AlphaMgmt", mc.getName());
        assertEquals("123456789", mc.getTaxID());
        assertEquals(10.0, mc.getMgmFee(), 0.001);
        assertEquals(5, mc.getMAX_PROPERTY());
    }

    @Test
    public void testAddPropertyAndTotalRent() {
        ManagementCompany mc = new ManagementCompany("RentCorp", "987654321", 5.0);
        Property p1 = new Property("Apt1", "NYC", 1200.0, "Alice");
        Property p2 = new Property("Apt2", "LA", 1500.0, "Bob");
        Property p3 = new Property("Apt3", "Chicago", 1000.0, "Carol");

        assertEquals(0, mc.addProperty(p1));
        assertEquals(1, mc.addProperty(p2));
        assertEquals(2, mc.addProperty(p3));
        assertEquals(3700.0, mc.getTotalRent(), 0.001);
    }

    @Test
    public void testAddPropertyBeyondLimit() {
        ManagementCompany mc = new ManagementCompany("LimitTest", "000000000", 8.0);
        for (int i = 0; i < mc.getMAX_PROPERTY(); i++) {
            mc.addProperty(new Property("P" + i, "City", 1000.0 + i * 100, "Owner"));
        }
        // Try to add one more beyond capacity
        Property extra = new Property("Overflow", "City", 2000.0, "ExtraOwner");
        assertEquals(-1, mc.addProperty(extra));
    }

    @Test
    public void testGetHighestRentProperty() {
        ManagementCompany mc = new ManagementCompany("HighRent", "555555555", 12.0);
        mc.addProperty(new Property("Low", "City", 800.0, "L"));
        mc.addProperty(new Property("Mid", "City", 1200.0, "M"));
        mc.addProperty(new Property("High", "City", 2000.0, "H"));

        Property highest = mc.getHighestRentProperty();
        assertNotNull(highest);
        assertEquals("High", highest.getPropertyName());
        assertEquals(2000.0, highest.getRentAmount(), 0.001);
    }

    @Test
    public void testToStringIncludesTotalRent() {
        ManagementCompany mc = new ManagementCompany("PrintTest", "111111111", 7.5);
        mc.addProperty(new Property("One", "City", 1000.0, "A"));
        mc.addProperty(new Property("Two", "City", 1500.0, "B"));

        String output = mc.toString();
        assertTrue(output.contains("PrintTest Property List:"));
        assertTrue(output.contains("One,City,A,1000.0"));
        assertTrue(output.contains("Two,City,B,1500.0"));
        assertTrue(output.contains("Total Rent: $2500.0"));
    }
}

