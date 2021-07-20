public class Grid {

    public static final int MINIMUM_VALUE = 0;
    private int size;

    public Grid(int size) {
        this.size = size;
    }

    static Coordinate minimumValue() {
        return new Coordinate(MINIMUM_VALUE);
    }

    int maximumValue(int gridSize) {
        return gridSize;
    }
}
