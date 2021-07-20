public class Grid {

    public static final int MINIMUM_VALUE = 0;
    public static final Grid INFINITE_ENOUGH_GRID_SIZE = new Grid(10000);
    private final int size;

    public Grid(int size) {
        this.size = size;
    }

    static Coordinate minimumValue() {
        return new Coordinate(MINIMUM_VALUE);
    }

    int maximumValue() {
        return this.size;
    }
}
