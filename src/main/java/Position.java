public class Position {

    private final int x;
    private final int y;
    private final Direction direction;

    public Position(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public static int increment(int value) {
        return value + 1;
    }

    public static int decrement(int value) {
        return value - 1;
    }

    String asString() {
        return x + ":" + y + ":" + this.direction.asChar();
    }
}
