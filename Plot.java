public class Plot {
    // Instance variables
    private int x;
    private int y;
    private int width;
    private int depth;

    // Constructors

    // Default constructor
    public Plot() {
        this.x = 0;
        this.y = 0;
        this.width = 1;
        this.depth = 1;
    }

    // Parameterized constructor
    public Plot(int x, int y, int width, int depth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.depth = depth;
    }

    // Copy constructor
    public Plot(Plot otherPlot) {
        this.x = otherPlot.x;
        this.y = otherPlot.y;
        this.width = otherPlot.width;
        this.depth = otherPlot.depth;
    }

    // Getter and Setter methods
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    // Method to check if this plot overlaps with another
    public boolean overlaps(Plot other) {
        return !(this.x + this.width <= other.x ||
                other.x + other.width <= this.x ||
                this.y + this.depth <= other.y ||
                other.y + other.depth <= this.y);
    }

    // Method to check if this plot encompasses another
    public boolean encompasses(Plot other) {
        return (this.x <= other.x &&
                this.y <= other.y &&
                this.x + this.width >= other.x + other.width &&
                this.y + this.depth >= other.y + other.depth);
    }

    // toString method
    @Override
    public String toString() {
        return x + "," + y + "," + width + "," + depth;
    }
}
