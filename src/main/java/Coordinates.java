public class Coordinates {

    private Coordinate x;
    private Coordinate y;

    private Coordinates(Coordinate x, Coordinate y) {
        this.x = x;
        this.y = y;
    }

    static Coordinates initial() {
        return new Coordinates(Grid.minimumValue(), Grid.minimumValue());
    }

    void incrementX(int gridSize) {
        this.x = x.increment().wrapIfNeeded(new Grid(gridSize));
    }

    void incrementY(int gridSize) {
        this.y = y.increment().wrapIfNeeded(new Grid(gridSize));
    }

    void decrementX(int gridSize) {
        this.x = x.decrement().wrapIfNeeded(new Grid(gridSize));
    }

    void decrementY(int gridSize) {
        this.y = y.decrement().wrapIfNeeded(new Grid(gridSize));
    }

    String asString() {
        return x.asString() + ":" + y.asString();
    }
}
