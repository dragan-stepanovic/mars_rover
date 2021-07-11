import java.util.Map;

public class Direction {

    private final char value;

    public static final char NORTH = 'N';
    public static final char EAST = 'E';
    public static final char SOUTH = 'S';
    public static final char WEST = 'W';

    private final Map<Character, Character> directionToRightOfIt =
            Map.of(NORTH, EAST,
                    EAST, SOUTH,
                    SOUTH, WEST,
                    WEST, NORTH);
    private final Map<Character, Character> directionToLeftOfIt =
            Map.of(NORTH, WEST,
                    WEST, SOUTH,
                    SOUTH, EAST,
                    EAST, NORTH);


    private Direction(char value) {
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

    public Direction leftOfIt() {
        return new Direction(directionToLeftOfIt.get(value));
    }

    public static Direction north() {
        return new Direction(NORTH);
    }

    char asChar() {
        return value;
    }

    @Override
    public String toString() {
        return "Direction{" +
                "value=" + value +
                '}';
    }
}
