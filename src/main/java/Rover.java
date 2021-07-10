import java.util.Map;

public class Rover {

    public static final char EAST = 'E';
    public static final char SOUTH = 'S';
    public static final char WEST = 'W';

    private final Map<Character, Character> directionToRightOfIt =
            Map.of(Direction.NORTH, EAST,
                    EAST, SOUTH,
                    SOUTH, WEST,
                    WEST, Direction.NORTH);

    private int xCoordinate = 0;
    private int yCoordinate = 0;
    private char direction = Direction.NORTH;
    private final Direction directionDomain = Direction.north();

    public void move() {
        if (movingToSouth()) {
            yCoordinate = decrement(yCoordinate);
        } else if (movingToWest()) {
            xCoordinate = decrement(xCoordinate);
        } else if (movingToEast()) {
            xCoordinate = increment(xCoordinate);
        } else if (Direction.movingToNorth(direction)) {
            yCoordinate = increment(yCoordinate);
        }
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

    private int increment(int value) {
        return value + 1;
    }

    private int decrement(int value) {
        return value - 1;
    }

    public void rotateRight() {
        direction = directionToRightOfIt.get(direction);
    }

    String position() {
        return asString(xCoordinate, yCoordinate, direction);
    }

    private String asString(int xCoordinate, int yCoordinate, Character direction) {
        return "(" + xCoordinate + "," + yCoordinate + "," + direction + ")";
    }
}
