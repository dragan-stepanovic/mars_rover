public class Position {

    public static final int GRID_MINIMUM_VALUE = 0;

    private final Coordinates coordinates;
    private Direction direction;

    public Position(int x, int y, Direction direction) {
        this.coordinates = new Coordinates(x, y);
        this.direction = direction;
    }

    static Position initial() {
        return new Position(GRID_MINIMUM_VALUE, GRID_MINIMUM_VALUE, Direction.north());
    }

    public void incrementX(int gridSize) {
        coordinates.x = increment(coordinates.x, gridSize);
    }

    public void incrementY(int gridSize) {
        coordinates.y = increment(coordinates.y, gridSize);
    }

    public void decrementX(int gridSize) {
        coordinates.x = decrement(coordinates.x, gridSize);
    }

    public void decrementY(int gridSize) {
        coordinates.y = decrement(coordinates.y, gridSize);
    }

    public int increment(int value, int gridSize) {
        int nextPosition = value + 1;
        nextPosition = wrapIfNeeded(nextPosition, gridSize);
        return nextPosition;
    }

    private int decrement(int value, int gridSize) {
        var nextPosition = value - 1;
        nextPosition = wrapIfNeeded(nextPosition, gridSize);
        return nextPosition;
    }

    private int wrapIfNeeded(int nextPosition, int gridSize) {
        if (offGridAboveMax(nextPosition, gridSize)) {
            return wrapAroundMin();
        }
        if (offGridUnderMin(nextPosition)) {
            return wrapAroundMax(gridSize);
        }
        return nextPosition;
    }

    private static int gridMaximumValue(int gridSize) {
        return gridSize;
    }

    private static boolean offGridAboveMax(int nextPosition, int gridSize) {
        return nextPosition == gridMaximumValue(gridSize);
    }

    private static boolean offGridUnderMin(int nextPosition) {
        return nextPosition < GRID_MINIMUM_VALUE;
    }

    private int wrapAroundMax(int gridSize) {
        return gridMaximumValue(gridSize) - 1;
    }

    private static int wrapAroundMin() {
        return GRID_MINIMUM_VALUE;
    }

    void rotateRight() {
        this.direction = this.direction.rightOfIt();
    }

    void rotateLeft() {
        this.direction = this.direction.leftOfIt();
    }

    boolean movingToSouth() {
        return this.direction.movingToSouth();
    }

    boolean movingToWest() {
        return this.direction.movingToWest();
    }

    boolean movingToEast() {
        return this.direction.movingToEast();
    }

    boolean movingToNorth() {
        return this.direction.movingToNorth();
    }

    String asString() {
        return this.coordinates.x + ":" + this.coordinates.y + ":" + this.direction.asChar();
    }
}
