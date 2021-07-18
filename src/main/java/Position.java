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
        coordinates.incrementX(gridSize);
    }

    public void incrementY(int gridSize) {
        coordinates.incrementY(gridSize);
    }

    public void decrementX(int gridSize) {
        coordinates.decrementX(gridSize);
    }

    public void decrementY(int gridSize) {
        coordinates.decrementY(gridSize);
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
