import java.util.Map;

public class Direction {

    private final char value;

    public static final Direction FACING_NORTH = new Direction('N');
    public static final Direction FACING_EAST = new Direction('E');
    public static final Direction FACING_SOUTH = new Direction('S');
    public static final Direction FACING_WEST = new Direction('W');

    private static final Map<Direction, Direction> directionToTheRight =
            Map.of(FACING_NORTH, FACING_EAST,
                    FACING_EAST, FACING_SOUTH,
                    FACING_SOUTH, FACING_WEST,
                    FACING_WEST, FACING_NORTH);

    private static final Map<Direction, Direction> directionToTheLeft =
            Map.of(FACING_NORTH, FACING_WEST,
                    FACING_WEST, FACING_SOUTH,
                    FACING_SOUTH, FACING_EAST,
                    FACING_EAST, FACING_NORTH);


    private Direction(char value) {
        this.value = value;
    }

    public static Direction initial() {
        return FACING_NORTH;
    }

    boolean isFacingNorth() {
        return this == FACING_NORTH;
    }

    boolean isFacingEast() {
        return this == FACING_EAST;
    }

    boolean isFacingSouth() {
        return this == FACING_SOUTH;
    }

    boolean isFacingWest() {
        return this == FACING_WEST;
    }

    Direction rotateRight() {
        return directionToTheRight.get(this);
    }

    public Direction rotateLeft() {
        return directionToTheLeft.get(this);
    }

    char asChar() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Direction direction = (Direction) o;

        return value == direction.value;
    }

    @Override
    public int hashCode() {
        return value;
    }


}
