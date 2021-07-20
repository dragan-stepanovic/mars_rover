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

    void incrementX(Grid grid) {
        this.x = x.increment().wrapIfNeeded(grid);
    }

    void incrementY(Grid grid) {
        this.y = y.increment().wrapIfNeeded(grid);
    }

    void decrementX(Grid grid) {
        this.x = x.decrement().wrapIfNeeded(grid);
    }

    void decrementY(Grid grid) {
        this.y = y.decrement().wrapIfNeeded(grid);
    }

    String asString() {
        return x.asString() + ":" + y.asString();
    }
}
