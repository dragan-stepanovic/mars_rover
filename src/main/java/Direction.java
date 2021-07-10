public class Direction {

    public static final char NORTH = 'N';
    public static final char WEST = 'W';
    public static final char EAST = 'E';
    private final char value;

    public Direction(char value) {
        this.value = value;
    }

    static boolean movingToEast(char direction) {
        return direction == EAST;
    }

    boolean movingToWest() {
        return value == WEST;
    }

    boolean movingToNorth() {
        return value == NORTH;
    }

    public static Direction north() {
        return new Direction(NORTH);
    }
}
