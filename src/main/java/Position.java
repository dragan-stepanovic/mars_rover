public class Position {

    private final Coordinates coordinates;
    private Direction direction;

    public Position(int x, int y, Direction direction) {
        this.coordinates = new Coordinates(x, y);
        this.direction = direction;
    }

    static Position initial() {
        return new Position(Coordinates.GRID_MINIMUM_VALUE, Coordinates.GRID_MINIMUM_VALUE, Direction.north());
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

    private static int wrapAroundMin() {
        return Coordinates.GRID_MINIMUM_VALUE;
    }

    private int wrapAroundMax(int gridSize) {
        return Coordinates.gridMaximumValue(gridSize) - 1;
    }

    private int wrapIfNeeded(int nextPosition, int gridSize) {
        if (Coordinates.offGridAboveMax(nextPosition, gridSize)) {
            return wrapAroundMin();
        }
        if (Coordinates.offGridUnderMin(nextPosition)) {
            return wrapAroundMax(gridSize);
        }
        return nextPosition;
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
