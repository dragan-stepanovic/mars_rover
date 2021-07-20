public class Coordinate {
    public int value;

    public Coordinate(int value) {
        this.value = value;
    }

    int increment() {
        return new Coordinate(value + 1).value;
    }
}
