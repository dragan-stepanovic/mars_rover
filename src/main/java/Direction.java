import java.util.Map;

enum Direction {
    NORTH('N'),
    EAST('E'),
    WEST('W'),
    SOUTH('S');

    private final char value;

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

    Direction toTheRight() {
        return directionToTheRight.get(this);
    }

    public Direction toTheLeft() {
        return directionToTheLeft.get(this);
    }

    char asChar() {
        return value;
    }
}
