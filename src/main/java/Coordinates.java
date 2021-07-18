public class Coordinates {
    public static final int GRID_MINIMUM_VALUE = 0;
    int x;
    int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    static int gridMaximumValue(int gridSize) {
        return gridSize;
    }

    static boolean offGridAboveMax(int nextPosition, int gridSize) {
        return nextPosition == gridMaximumValue(gridSize);
    }

    static boolean offGridUnderMin(int nextPosition) {
        return nextPosition < GRID_MINIMUM_VALUE;
    }

    static int wrapAroundMin() {
        return GRID_MINIMUM_VALUE;
    }

    int wrapAroundMax(int gridSize) {
        return gridMaximumValue(gridSize) - 1;
    }

    int wrapIfNeeded(int nextPosition, int gridSize) {
        if (offGridAboveMax(nextPosition, gridSize)) {
            return wrapAroundMin();
        }
        if (offGridUnderMin(nextPosition)) {
            return wrapAroundMax(gridSize);
        }
        return nextPosition;
    }

    int decrement(int value, int gridSize) {
        var nextPosition = value - 1;
        nextPosition = wrapIfNeeded(nextPosition, gridSize);
        return nextPosition;
    }

    public int increment(int value, int gridSize) {
        int nextPosition = value + 1;
        nextPosition = wrapIfNeeded(nextPosition, gridSize);
        return nextPosition;
    }

    void incrementXNew(int gridSize) {
        this.x = increment(x, gridSize);
    }
}
