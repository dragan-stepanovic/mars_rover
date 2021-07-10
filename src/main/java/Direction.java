public class Direction {

    public static final char NORTH = 'N';
    private final char value;

    public Direction(char value) {
        this.value = value;
    }

    boolean movingToNorth() {
        return value == NORTH;
    }

    public static Direction north() {
        return new Direction(NORTH);
    }
}
