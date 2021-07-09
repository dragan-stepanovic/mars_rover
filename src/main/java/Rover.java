import java.util.Map;

public class Rover {

    public static final Character NORTH = 'N';
    public static final Character EAST = 'E';
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

    public String move() {
        direction = directionOf(position);
        if (movingToSouth()) {
            position = "(" + xCoordinateOf(position) + "," + decrement(yCoordinateOf(position)) + "," + SOUTH + ")";
            return position;
        }

        if (movingToWest()) {
            position = "(" + decrement(xCoordinateOf(position)) + "," + yCoordinateOf(position) + "," + WEST + ")";
            return position;
        }

        if (movingToEast()) {
            position = "(" + increment(xCoordinateOf(position)) + "," + yCoordinateOf(position) + "," + EAST + ")";
            return position;
        }

        position = "(" + xCoordinateOf(position) + "," + increment(yCoordinateOf(position)) + "," + NORTH + ")";
        return position;
    }

    private boolean movingToSouth() {
        return directionOf(this.position) == SOUTH;
    }

    private boolean movingToWest() {
        return directionOf(this.position) == WEST;
    }

    private boolean movingToEast() {
        return directionOf(this.position) == EAST;
    }

    public String rotateRight() {
        position = withDirection(directionToRightOfIt.get(directionOf(position)));
        return position;
    }

    private int increment(int value) {
        return value + 1;
    }

    private int decrement(int value) {
        return value - 1;
    }

    private String withDirection(Character direction) {
        return "(" + xCoordinateOf(position) + "," + yCoordinateOf(position) + "," + direction + ")";
    }

    private char directionOf(String position) {
        return position.charAt(5);
    }

    private int xCoordinateOf(String position) {
        return Character.getNumericValue(position.charAt(1));
    }

    private int yCoordinateOf(String position) {
        return Character.getNumericValue(position.charAt(3));
    }
}
