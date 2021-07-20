public class Coordinates {

    private int x;
    private int y;

    public static final int GRID_MINIMUM_VALUE = 0;

    private Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    static Coordinates initial() {
        return new Coordinates(GRID_MINIMUM_VALUE, GRID_MINIMUM_VALUE);
    }

    void incrementX(int gridSize) {
        this.x = wrapIfNeeded(increment(x), gridSize);
    }

    void incrementY(int gridSize) {
        this.y = wrapIfNeeded(increment(y), gridSize);
    }

    private int increment(int value) {
        return new Coordinate(value + 1).value;
    }

    void decrementX(int gridSize) {
        this.x = wrapIfNeeded(decrement(x), gridSize);
    }

    void decrementY(int gridSize) {
        this.y = wrapIfNeeded(decrement(y), gridSize);
    }

    private int decrement(int value) {
        return value - 1;
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

    static boolean offGridAboveMax(int nextPosition, int gridSize) {
        return nextPosition == gridMaximumValue(gridSize);
    }

    static boolean offGridUnderMin(int nextPosition) {
        return nextPosition < GRID_MINIMUM_VALUE;
    }

    int wrapAroundMax(int gridSize) {
        return decrement(gridMaximumValue(gridSize));
    }

    static int wrapAroundMin() {
        return GRID_MINIMUM_VALUE;
    }

    static int gridMaximumValue(int gridSize) {
        return gridSize;
    }

    String asString() {
        return x + ":" + y;
    }
}
