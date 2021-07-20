public class Coordinate {

    public int value;

    public Coordinate(int value) {
        this.value = value;
    }

    boolean offGridAboveMax(int gridSize) {
        return this.value == new Grid(gridSize).maximumValue();
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
        return new Coordinate(new Grid(gridSize).maximumValue()).decrement();
    }

    Coordinate wrapIfNeeded(int gridSize) {
        if (offGridAboveMax(gridSize)) {
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
