public class Coordinates {

    private Coordinate x;
    private Coordinate y;

    private Coordinates(int x, int y) {
        this.x = new Coordinate(x);
        this.y = new Coordinate(y);
    }

    static Coordinates initial() {
        return new Coordinates(Coordinate.GRID_MINIMUM_VALUE, Coordinate.GRID_MINIMUM_VALUE);
    }

    void incrementX(int gridSize) {
        this.x = x.increment().wrapIfNeeded(gridSize);
    }

    void incrementY(int gridSize) {
        this.y = y.increment().wrapIfNeeded(gridSize);
    }

    void decrementX(int gridSize) {
        this.x = x.decrement().wrapIfNeeded(gridSize);
    }

    void decrementY(int gridSize) {
        this.y = y.decrement().wrapIfNeeded(gridSize);
    }

    String asString() {
        return x.asString() + ":" + y.asString();
    }
}
