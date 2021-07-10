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
    private int xCoordinate = 0;
    private int yCoordinate = 0;

    public String move() {

        if (movingToSouth()) {
            yCoordinate = decrement(yCoordinate);
        } else if (movingToWest()) {
            xCoordinate = decrement(xCoordinate);
        } else if (movingToEast()) {
            xCoordinate = increment(xCoordinate);
        } else if (movingToNorth()) {
            yCoordinate = increment(yCoordinate);
        }

        return "(" + xCoordinate + "," + yCoordinate + "," + direction + ")";
    }

    private boolean movingToNorth() {
        return direction == NORTH;
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
        position = "(" + xCoordinate + "," + yCoordinate + "," + direction + ")";
        return position;
    }

    private int increment(int value) {
        return value + 1;
    }

    private int decrement(int value) {
        return value - 1;
    }

}
