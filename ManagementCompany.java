
public class ManagementCompany {
    private String name;
    private String taxID;
    private double mgmFee;
    private Property[] properties;
    public final int MAX_PROPERTY = 5;

    public ManagementCompany(String name, String taxID, double mgmFee) {
        this.name = name;
        this.taxID = taxID;
        this.mgmFee = mgmFee;
        this.properties = new Property[MAX_PROPERTY];
    }

    public int addProperty(Property p) {
        for (int i = 0; i < MAX_PROPERTY; i++) {
            if (properties[i] == null) {
                properties[i] = new Property(p);  // deep copy
                return i;  // return index where it was added
            }
        }
        return -1;  // signal failure
    }

    public double totalRent() {
        double total = 0;
        for (Property p : properties) {
            if (p != null) total += p.getRentAmount();
        }
        return total;
    }
    public double getTotalRent() {
        return totalRent();
    }

    public int getMAX_PROPERTY() {
        return MAX_PROPERTY;
    }
    public String getName() {
        return name;
    }

    public String getTaxID() {
        return taxID;
    }

    public double getMgmFee() {
        return mgmFee;
    }

    // Stub method added to satisfy GUI call; not used in core logic
    public Plot getPlot() {
        return new Plot();
    }

    public Property getHighestRentProperty() {
        Property highest = null;
        for (Property p : properties) {
            if (p != null) {
                if (highest == null || p.getRentAmount() > highest.getRentAmount()) {
                    highest = p;
                }
            }
        }
        return highest;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name + " Property List:\n");
        for (Property p : properties) {
            if (p != null) sb.append(p.toString()).append("\n");
        }
        sb.append("Total Rent: $").append(totalRent());
        return sb.toString();
    }
}

