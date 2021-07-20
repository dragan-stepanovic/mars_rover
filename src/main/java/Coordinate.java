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
        if (this.isOffAboveMax(grid)) {
            return wrapAroundMin();
        }
        if (isOffUnderMin()) {
            return wrapAroundMax(grid);
        }
        return this;
    }

    boolean isOffAboveMax(Grid grid) {
        return isGreaterOrEqualTo(grid.maximumValue());
    }

    boolean isOffUnderMin() {
        return isLessThan(Grid.minimumValue());
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
