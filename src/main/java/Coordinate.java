public class Coordinate {
    public int value;

    public Coordinate(int value) {
        this.value = value;
    }

    Coordinate increment() {
        return new Coordinate(value + 1);
    }

    Coordinate decrement() {
        return new Coordinate(value - 1);
    }

    int wrapIfNeeded(int gridSize, Coordinates coordinates) {
        if (Coordinates.offGridAboveMax(value, gridSize)) {
            return Coordinates.wrapAroundMin();
        }
        if (Coordinates.offGridUnderMin(value)) {
            return coordinates.wrapAroundMax(gridSize);
        }
        return value;
    }
}
