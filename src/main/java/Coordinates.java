public class Coordinates {

    private Coordinate x;
    private int y;

    private Coordinates(int x, int y) {
        this.x = new Coordinate(x);
        this.y = y;
    }

    static Coordinates initial() {
        return new Coordinates(Coordinate.GRID_MINIMUM_VALUE, Coordinate.GRID_MINIMUM_VALUE);
    }

    void incrementX(int gridSize) {
        this.x = x.increment().wrapIfNeeded(gridSize);
    }

    void incrementY(int gridSize) {
        this.y = new Coordinate(y).increment().wrapIfNeeded(gridSize).value;
    }

    void decrementX(int gridSize) {
        this.x = x.decrement().wrapIfNeeded(gridSize);
    }

    void decrementY(int gridSize) {
        this.y = new Coordinate(y).decrement().wrapIfNeeded(gridSize).value;
    }

    String asString() {
        return x.value + ":" + y;
    }
}
