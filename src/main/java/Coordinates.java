public class Coordinates {

    private int x;
    private int y;

    private Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    static Coordinates initial() {
        return new Coordinates(Coordinate.GRID_MINIMUM_VALUE, Coordinate.GRID_MINIMUM_VALUE);
    }

    void incrementX(int gridSize) {
        this.x = new Coordinate(x).increment().wrapIfNeeded(gridSize).value;
    }

    void incrementY(int gridSize) {
        this.y = new Coordinate(y).increment().wrapIfNeeded(gridSize).value;
    }

    void decrementX(int gridSize) {
        this.x = new Coordinate(x).decrement().wrapIfNeeded(gridSize).value;
    }

    void decrementY(int gridSize) {
        this.y = new Coordinate(y).decrement().wrapIfNeeded(gridSize).value;
    }

    String asString() {
        return x + ":" + y;
    }
}
