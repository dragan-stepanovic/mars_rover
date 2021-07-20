import java.util.Objects;

public class Coordinate {

    public int value;

    public Coordinate(int value) {
        this.value = value;
    }

    static Coordinate wrapAroundMax(Grid grid) {
        return grid.maximumValue().decrement();
    }

    boolean offGridUnderMin() {
        return this.lessThan(Grid.minimumValue());
    }

    boolean lessThan(Coordinate that) {
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

    boolean offGridAboveMax(Grid grid) {
        return this.equals(grid.maximumValue());
    }

    Coordinate wrapIfNeeded(Grid grid) {
        if (offGridAboveMax(grid)) {
            return wrapAroundMin();
        }
        if (offGridUnderMin()) {
            return wrapAroundMax(grid);
        }
        return this;
    }

    public String asString() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
