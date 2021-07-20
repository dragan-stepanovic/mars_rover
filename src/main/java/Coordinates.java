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
        this.x = new Coordinate(x).increment().wrapIfNeeded(gridSize, this);
    }

    void incrementY(int gridSize) {
        this.y = new Coordinate(y).increment().wrapIfNeeded(gridSize, this);
    }

    void decrementX(int gridSize) {
        this.x = new Coordinate(x).decrement().wrapIfNeeded(gridSize, this);
    }

    void decrementY(int gridSize) {
        this.y = new Coordinate(y).decrement().wrapIfNeeded(gridSize, this);
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
