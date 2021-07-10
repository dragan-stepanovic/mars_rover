import java.util.Map;

public class Rover {

    public static final char NORTH = 'N';
    public static final char EAST = 'E';
    public static final char SOUTH = 'S';
    public static final char WEST = 'W';

    public static final String INITIAL_POSITION = "(0,0," + NORTH + ")";

    private final Map<Character, Character> directionToRightOfIt =
            Map.of(NORTH, EAST,
                    EAST, SOUTH,
                    SOUTH, WEST,
                    WEST, NORTH);

    private String position = INITIAL_POSITION;
    private Character direction = NORTH;
    private final int xCoordinate = 0;

    public String move() {

        if (movingToSouth()) {
            position = "(" + xCoordinateOf(position) + "," + decrement(yCoordinateOf(position)) + "," + direction + ")";
            return position;
        }

        if (movingToWest()) {
            position = "(" + decrement(xCoordinateOf(position)) + "," + yCoordinateOf(position) + "," + direction + ")";
            return position;
        }

        if (movingToEast()) {
            position = "(" + increment(xCoordinateOf(position)) + "," + yCoordinateOf(position) + "," + direction + ")";
            return position;
        }

        position = "(" + xCoordinateOf(position) + "," + increment(yCoordinateOf(position)) + "," + direction + ")";
        return position;
    }

    private boolean movingToSouth() {
        return direction == SOUTH;
    }

    private boolean movingToWest() {
        return direction == WEST;
    }

    private boolean movingToEast() {
        return direction == EAST;
    }

    public String rotateRight() {
        direction = directionToRightOfIt.get(direction);
        position = withDirection(direction);
        return position;
    }

    private int increment(int value) {
        return value + 1;
    }

    private int decrement(int value) {
        return value - 1;
    }

    private int xCoordinateOf(String position) {
        return Character.getNumericValue(position.charAt(1));
    }

    private int yCoordinateOf(String position) {
        return Character.getNumericValue(position.charAt(3));
    }

    private String withDirection(Character direction) {
        return "(" + xCoordinateOf(position) + "," + yCoordinateOf(position) + "," + direction + ")";
    }
}
