public class Direction {

    public static final char NORTH = 'N';
    public static final char EAST = 'E';
    public static final char WEST = 'W';
    public static final char SOUTH = 'S';
    private final char value;

    public Direction(char value) {
        this.value = value;
    }

    boolean movingToNorth() {
        return value == NORTH;
    }

    boolean movingToEast() {
        return value == EAST;
    }

    boolean movingToSouth() {
        return value == SOUTH;
    }

    boolean movingToWest() {
        return value == WEST;
    }

    public static Direction north() {
        return new Direction(NORTH);
    }
}
