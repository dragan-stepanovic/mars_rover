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
        this.x = wrapIfNeeded(new Coordinate(x).increment().value, gridSize);
    }

    void incrementY(int gridSize) {
        this.y = wrapIfNeeded(new Coordinate(y).increment().value, gridSize);
    }

    void decrementX(int gridSize) {
        this.x = wrapIfNeeded(new Coordinate(x).decrement(), gridSize);
    }

    void decrementY(int gridSize) {
        this.y = wrapIfNeeded(new Coordinate(y).decrement(), gridSize);
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
        return new Coordinate(gridMaximumValue(gridSize)).decrement();
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
