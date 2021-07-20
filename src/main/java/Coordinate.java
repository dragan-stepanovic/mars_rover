public class Coordinate {
    public static final int GRID_MINIMUM_VALUE = 0;
    public int value;

    public Coordinate(int value) {
        this.value = value;
    }

    static boolean offGridAboveMax(int nextPosition, int gridSize) {
        return nextPosition == gridMaximumValue(gridSize);
    }

    static boolean offGridUnderMin(int nextPosition) {
        return nextPosition < GRID_MINIMUM_VALUE;
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

    int wrapIfNeeded(int gridSize) {
        if (offGridAboveMax(value, gridSize)) {
            return wrapAroundMin();
        }
        if (offGridUnderMin(value)) {
            return wrapAroundMax(gridSize);
        }
        return value;
    }

    static int wrapAroundMax(int gridSize) {
        return new Coordinate(gridMaximumValue(gridSize)).decrement().value;
    }

    static int wrapAroundMin() {
        return GRID_MINIMUM_VALUE;
    }
}
