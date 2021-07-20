public class Coordinate {
    public int value;

    public Coordinate(int value) {
        this.value = value;
    }

    Coordinate increment() {
        return new Coordinate(value + 1);
    }

    int decrement() {
        return value - 1;
    }
}
