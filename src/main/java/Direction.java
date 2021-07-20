import java.util.Map;

public class Direction {

    private final char value;

    public static final Direction NORTH = new Direction('N');
    public static final Direction EAST = new Direction('E');
    public static final Direction SOUTH = new Direction('S');
    public static final Direction WEST = new Direction('W');

    private static final Map<Direction, Direction> directionToTheRight =
            Map.of(NORTH, EAST,
                    EAST, SOUTH,
                    SOUTH, WEST,
                    WEST, NORTH);

    private static final Map<Direction, Direction> directionToTheLeft =
            Map.of(NORTH, WEST,
                    WEST, SOUTH,
                    SOUTH, EAST,
                    EAST, NORTH);


    private Direction(char value) {
        this.value = value;
    }

    public static Direction initial() {
        return NORTH;
    }

    boolean isFacingNorth() {
        return this == NORTH;
    }

    boolean isFacingEast() {
        return this == EAST;
    }

    boolean isFacingSouth() {
        return this == SOUTH;
    }

    boolean isFacingWest() {
        return this == WEST;
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
