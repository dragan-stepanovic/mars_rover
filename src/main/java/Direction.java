public class Direction {

    public static final char NORTH = 'N';
    public static final char WEST = 'W';
    public static final char EAST = 'E';
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

    boolean movingToSouth(char direction) {
        return value == Rover.SOUTH;
    }

    boolean movingToWest() {
        return value == WEST;
    }

    public static Direction north() {
        return new Direction(NORTH);
    }
}
