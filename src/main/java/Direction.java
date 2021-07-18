import java.util.Map;

public class Direction {

    private char value;

    public static final char FACING_NORTH = 'N';
    public static final char FACING_EAST = 'E';
    public static final char FACING_SOUTH = 'S';
    public static final char FACING_WEST = 'W';

    private final Map<Character, Character> directionToRightOfIt =
            Map.of(FACING_NORTH, FACING_EAST,
                    FACING_EAST, FACING_SOUTH,
                    FACING_SOUTH, FACING_WEST,
                    FACING_WEST, FACING_NORTH);
    private final Map<Character, Character> directionToLeftOfIt =
            Map.of(FACING_NORTH, FACING_WEST,
                    FACING_WEST, FACING_SOUTH,
                    FACING_SOUTH, FACING_EAST,
                    FACING_EAST, FACING_NORTH);


    private Direction(char value) {
        this.value = value;
    }

    public static Direction initial() {
        return new Direction(FACING_NORTH);
    }

    boolean facingNorth() {
        return value == FACING_NORTH;
    }

    boolean facingEast() {
        return value == FACING_EAST;
    }

    boolean facingSouth() {
        return value == FACING_SOUTH;
    }

    boolean facingWest() {
        return value == FACING_WEST;
    }

    void rotateRight() {
        value = directionToRightOfIt.get(value);
    }

    public void rotateLeft() {
        value = directionToLeftOfIt.get(value);
    }

    char asChar() {
        return value;
    }
}
