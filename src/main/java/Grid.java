public class Grid {

    public static final Grid INFINITE_ENOUGH = new Grid(10000);
    private final int size;

    public Grid(int size) {
        this.size = size;
    }

    static Coordinate minimumValue() {
        return new Coordinate(0);
    }

    Coordinate maximumValue() {
        return new Coordinate(this.size);
    }

    boolean coordinateIsOffGridAboveMax(Coordinate coordinate) {
        return coordinate.isGreaterOrEqualTo(maximumValue());
    }

    boolean coordinateIsOffGridUnderMin(Coordinate coordinate) {
        return coordinate.isLessThan(minimumValue());
    }
}
