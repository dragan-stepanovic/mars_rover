public class Coordinate {
    public int value;

    public Coordinate(int value) {
        this.value = value;
    }

    static boolean offGridAboveMax(int nextPosition, int gridSize) {
        return nextPosition == gridMaximumValue(gridSize);
    }

    static boolean offGridUnderMin(int nextPosition) {
        return nextPosition < Grid.MINIMUM_VALUE;
    }

    static int gridMaximumValue(int gridSize) {
        return gridSize;
    }

    Coordinate increment() {
        return new Coordinate(value + 1);
    }

    Coordinate decrement() {
        return new Coordinate(value - 1);
    }

    static Coordinate wrapAroundMin() {
        return new Coordinate(Grid.MINIMUM_VALUE);
    }

    static Coordinate wrapAroundMax(int gridSize) {
        return new Coordinate(gridMaximumValue(gridSize)).decrement();
    }

    Coordinate wrapIfNeeded(int gridSize) {
        if (offGridAboveMax(value, gridSize)) {
            return wrapAroundMin();
        }
        if (offGridUnderMin(value)) {
            return wrapAroundMax(gridSize);
        }
        return this;
    }

    public String asString() {
        return String.valueOf(value);
    }
}
