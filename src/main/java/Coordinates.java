public class Coordinates {

    private Coordinate x;
    private Coordinate y;

    private Coordinates(Coordinate x, Coordinate y) {
        this.x = x;
        this.y = y;
    }

    static Coordinates initial() {
        return new Coordinates(Grid.gridMinimumValue(), Grid.gridMinimumValue());
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
