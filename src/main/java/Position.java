public class Position {

    private final int x;
    private final int y;
    private final Direction direction;

    public Position(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public static int increment(int value, int[] grid) {
        final int nextPosition = value + 1;
        if (nextPosition == grid[1])
            return 0;

        return nextPosition;
    }

    public static int decrement(int value, int[] grid) {
        return value - 1;
    }

    String asString() {
        return x + ":" + y + ":" + this.direction.asChar();
    }
}
