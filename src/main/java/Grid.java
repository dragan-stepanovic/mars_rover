public class Grid {

    public static final int MINIMUM_VALUE = 0;
    public static final Grid INFINITE_ENOUGH = new Grid(10000);
    private final int size;

    public Grid(int size) {
        this.size = size;
    }

    static Coordinate minimumValue() {
        return new Coordinate(MINIMUM_VALUE);
    }

    Coordinate maximumValue() {
        return new Coordinate(this.size);
    }
}
