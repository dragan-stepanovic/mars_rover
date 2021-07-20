public class Coordinate {

    public int value;

    public Coordinate(int value) {
        this.value = value;
    }

    static boolean offGridAboveMax(int nextPosition, int gridSize) {
        return nextPosition == new Grid(gridSize).maximumValue(gridSize);
    }

    static boolean offGridUnderMin(int nextPosition) {
        return nextPosition < Grid.MINIMUM_VALUE;
    }

    Coordinate increment() {
        return new Coordinate(value + 1);
    }

    Coordinate decrement() {
        return new Coordinate(value - 1);
    }

    static Coordinate wrapAroundMin() {
        return Grid.minimumValue();
    }

    static Coordinate wrapAroundMax(int gridSize) {
        return new Coordinate(Grid.maximumValue(gridSize)).decrement();
    }

    Coordinate wrapIfNeeded(int gridSize) {
        if (offGridAboveMax(value, gridSize)) {
            return wrapAroundMin();
        }
        if (offGridUnderMin(value)) {
            return wrapAroundMax(gridSize);
        }
        return this;
    }

    public String asString() {
        return String.valueOf(value);
    }
}
