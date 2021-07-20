import java.util.Map;

enum Direction {

    NORTH('N'),
    EAST('E'),
    WEST('W'),
    SOUTH('S');

    private final char value;

//    public static final Direction NORTH = new Direction('N');
//    public static final Direction EAST = new Direction('E');
//    public static final Direction SOUTH = new Direction('S');
//    public static final Direction WEST = new Direction('W');

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


    Direction(char value) {
        this.value = value;
    }

    public static Direction initial() {
        return NORTH;
    }

    Direction toRight() {
        return directionToTheRight.get(this);
    }

    public Direction toLeft() {
        return directionToTheLeft.get(this);
    }

    char asChar() {
        return value;
    }
}
