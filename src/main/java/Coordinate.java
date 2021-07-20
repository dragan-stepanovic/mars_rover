public class Coordinate {

    public int value;

    public Coordinate(int value) {
        this.value = value;
    }

    boolean isLessThan(Coordinate that) {
        return this.value < that.value;
    }

    static Coordinate wrapAroundMax(Grid grid) {
        return grid.maximumValue().decrement();
    }

    Coordinate increment() {
        return new Coordinate(value + 1);
    }

    Coordinate decrement() {
        return new Coordinate(value - 1);
    }

    Coordinate wrapIfNeeded(Grid grid) {
        if (grid.isOffAboveMax(this)) {
            return wrapAroundMin();
        }
        if (grid.isOffUnderMin(this)) {
            return wrapAroundMax(grid);
        }
        return this;
    }

    public boolean isGreaterOrEqualTo(Coordinate that) {
        return this.value >= that.value;
    }

    Coordinate wrapAroundMin() {
        return Grid.minimumValue();
    }

    public String asString() {
        return String.valueOf(value);
    }
}
