public class Coordinate {

    public int value;

    public Coordinate(int value) {
        this.value = value;
    }

    boolean offGridAboveMax(Grid grid) {
        return this.value == grid.maximumValue();
    }

    static boolean offGridUnderMin(int nextPosition) {
        return nextPosition < Grid.MINIMUM_VALUE;
    }

    Coordinate increment() {
        return new Coordinate(value + 1);
    }

    Coordinate decrement() {
        return new Coordinate(value - 1);
    }

    static Coordinate wrapAroundMin() {
        return Grid.minimumValue();
    }

    static Coordinate wrapAroundMax(Grid grid) {
        return new Coordinate(grid.maximumValue()).decrement();
    }

    Coordinate wrapIfNeeded(int gridSize) {
        if (offGridAboveMax(new Grid(gridSize))) {
            return wrapAroundMin();
        }
        if (offGridUnderMin(value)) {
            return wrapAroundMax(new Grid(gridSize));
        }
        return this;
    }

    public String asString() {
        return String.valueOf(value);
    }
}
