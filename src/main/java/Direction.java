import java.util.Map;

public class Direction {

    public static final char NORTH = 'N';
    public static final char EAST = 'E';
    public static final char SOUTH = 'S';
    public static final char WEST = 'W';
    private final char value;

    private final Map<Character, Character> directionToRightOfIt =
            Map.of(Direction.NORTH, Direction.EAST,
                    Direction.EAST, Direction.SOUTH,
                    Direction.SOUTH, Direction.WEST,
                    Direction.WEST, Direction.NORTH);


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

    Direction rightOfIt() {
        return new Direction(directionToRightOfIt.get(value));
    }

    public static Direction north() {
        return new Direction(NORTH);
    }

    char asChar() {
        return value;
    }
}
