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

    Coordinate wrapIfNeeded(Grid grid) {
        if (this.isOffGridAboveMax(grid)) {
            return wrapAroundMin();
        }
        if (this.isOffGridUnderMin()) {
            return wrapAroundMax(grid);
        }
        return this;
    }

    boolean isOffGridAboveMax(Grid grid) {
        return isGreaterOrEqualTo(grid.maximumValue());
    }

    boolean isOffGridUnderMin() {
        return isLessThan(Grid.minimumValue());
    }

    Coordinate wrapAroundMax(Grid grid) {
        return grid.maximumValue().decrement();
    }

    Coordinate wrapAroundMin() {
        return Grid.minimumValue();
    }

    boolean isLessThan(Coordinate that) {
        return this.value < that.value;
    }

    public boolean isGreaterOrEqualTo(Coordinate that) {
        return this.value >= that.value;
    }

    public String asString() {
        return String.valueOf(value);
    }
}
