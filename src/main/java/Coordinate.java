public class Coordinate {
    public int value;

    public Coordinate(int value) {
        this.value = value;
    }

    public Coordinate incrementNew() {
        return new Coordinate(value + 1);
    }
}
