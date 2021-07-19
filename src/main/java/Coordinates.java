public class Coordinates {
    int x;
    int y;

    public static final int GRID_MINIMUM_VALUE = 0;

    private Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    static Coordinates initial() {
        return new Coordinates(GRID_MINIMUM_VALUE, GRID_MINIMUM_VALUE);
    }

    void incrementX(int gridSize) {
        this.x = wrapIfNeeded(x + 1, gridSize);
    }

    void incrementY(int gridSize) {
        this.y = wrapIfNeeded(y + 1, gridSize);
    }

    void decrementX(int gridSize) {
        this.x = wrapIfNeeded(x - 1, gridSize);
    }

    void decrementY(int gridSize) {
        this.y = wrapIfNeeded(y - 1, gridSize);
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

    static int gridMaximumValue(int gridSize) {
        return gridSize;
    }

    static boolean offGridUnderMin(int nextPosition) {
        return nextPosition < GRID_MINIMUM_VALUE;
    }

    static boolean offGridAboveMax(int nextPosition, int gridSize) {
        return nextPosition == gridMaximumValue(gridSize);
    }

    static int wrapAroundMin() {
        return GRID_MINIMUM_VALUE;
    }

    int wrapAroundMax(int gridSize) {
        return gridMaximumValue(gridSize) - 1;
    }

    String asString() {
        return x + ":" + y;
    }
}
