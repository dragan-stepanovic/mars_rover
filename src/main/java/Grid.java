public class Grid {

    private final int size;

    public static final Grid INFINITE_ENOUGH = new Grid(10000);

    public Grid(int size) {
        this.size = size;
    }

    static Coordinate minimumValue() {
        return new Coordinate(0);
    }

    Coordinate maximumValue() {
        return new Coordinate(this.size);
    }

    boolean isOffAboveMax(Coordinate coordinate) {
        return coordinate.isGreaterOrEqualTo(maximumValue());
    }

    boolean isOffUnderMin(Coordinate coordinate) {
        return coordinate.isLessThan(minimumValue());
    }
}
