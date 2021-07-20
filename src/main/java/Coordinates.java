public class Coordinates {

    private final Coordinate x;
    private final Coordinate y;

    private Coordinates(Coordinate x, Coordinate y) {
        this.x = x;
        this.y = y;
    }

    static Coordinates initial() {
        return new Coordinates(Grid.minimumValue(), Grid.minimumValue());
    }

    Coordinates incrementX(Grid grid) {
        return new Coordinates(x.increment().wrapIfNeeded(grid), y);
    }

    Coordinates incrementY(Grid grid) {
        return new Coordinates(x, y.increment().wrapIfNeeded(grid));
    }

    Coordinates decrementX(Grid grid) {
        return new Coordinates(x.decrement().wrapIfNeeded(grid), y);
    }

    Coordinates decrementY(Grid grid) {
        return new Coordinates(x, y.decrement().wrapIfNeeded(grid));
    }

    String asString() {
        return x.asString() + ":" + y.asString();
    }
}
