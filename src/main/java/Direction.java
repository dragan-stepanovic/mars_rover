public class Direction {

    public static final char NORTH = 'N';
    public static final char WEST = 'W';
    private final char value;

    public Direction(char value) {
        this.value = value;
    }

    public static boolean movingToWest(char direction) {
        return direction == WEST;
    }

    boolean movingToNorth() {
        return value == NORTH;
    }

    public static Direction north() {
        return new Direction(NORTH);
    }
}
