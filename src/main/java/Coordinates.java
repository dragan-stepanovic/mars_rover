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
        final int value = new Coordinate(x).increment().value;
        this.x = wrapIfNeeded(gridSize, new Coordinate(value));
    }

    void incrementY(int gridSize) {
        final int value = new Coordinate(y).increment().value;
        this.y = wrapIfNeeded(gridSize, new Coordinate(value));
    }

    void decrementX(int gridSize) {
        this.x = wrapIfNeeded(gridSize, new Coordinate(x).decrement());
    }

    void decrementY(int gridSize) {
        this.y = wrapIfNeeded(gridSize, new Coordinate(y).decrement());
    }

    int wrapIfNeeded(int gridSize, Coordinate coordinate) {
        if (offGridAboveMax(coordinate.value, gridSize)) {
            return wrapAroundMin();
        }
        if (offGridUnderMin(coordinate.value)) {
            return wrapAroundMax(gridSize);
        }
        return coordinate.value;
    }

    static boolean offGridAboveMax(int nextPosition, int gridSize) {
        return nextPosition == gridMaximumValue(gridSize);
    }

    static boolean offGridUnderMin(int nextPosition) {
        return nextPosition < GRID_MINIMUM_VALUE;
    }

    int wrapAroundMax(int gridSize) {
        return new Coordinate(gridMaximumValue(gridSize)).decrement().value;
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
