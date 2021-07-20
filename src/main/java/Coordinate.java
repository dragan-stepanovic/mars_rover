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

    static Coordinate wrapAroundMin() {
        return new Coordinate(GRID_MINIMUM_VALUE);
    }

    static Coordinate wrapAroundMax(int gridSize) {
        return new Coordinate(gridMaximumValue(gridSize)).decrement();
    }

    int wrapIfNeededOld(int gridSize) {
        if (offGridAboveMax(value, gridSize)) {
            return wrapAroundMin().value;
        }
        if (offGridUnderMin(value)) {
            return wrapAroundMax(gridSize).value;
        }
        return value;
    }
}
