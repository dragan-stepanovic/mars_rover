public class Coordinate {

    public int value;

    public Coordinate(int value) {
        this.value = value;
    }

    static Coordinate wrapAroundMax(Grid grid) {
        return grid.maximumValue().decrement();
    }

    public boolean isGreaterOrEqualTo(Coordinate that) {
        return this.value >= that.value;
    }

    boolean isLessThan(Coordinate that) {
        return this.value < that.value;
    }

    Coordinate increment() {
        return new Coordinate(value + 1);
    }

    Coordinate decrement() {
        return new Coordinate(value - 1);
    }

    Coordinate wrapAroundMin() {
        return Grid.minimumValue();
    }

    Coordinate wrapIfNeeded(Grid grid) {
        if (grid.coordinateIsOffGridAboveMax(this)) {
            return wrapAroundMin();
        }
        if (grid.coordinateIsOffGridUnderMin(this)) {
            return wrapAroundMax(grid);
        }
        return this;
    }

    public String asString() {
        return String.valueOf(value);
    }
}
