public class Coordinate {
    public int value;

    public Coordinate(int value) {
        this.value = value;
    }

    int increment() {
        return incrementNew().value;
    }

    private Coordinate incrementNew() {
        return new Coordinate(value + 1);
    }
}
