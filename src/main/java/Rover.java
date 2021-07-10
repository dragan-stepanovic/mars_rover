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

    public static boolean movingToWest(char direction) {
        return direction == WEST;
    }

    private boolean movingToSouth() {
        return direction == SOUTH;
    }

    public void move() {
        if (movingToSouth()) {
            yCoordinate = decrement(yCoordinate);
        } else if (movingToWest(direction)) {
            xCoordinate = decrement(xCoordinate);
        } else if (movingToEast()) {
            xCoordinate = increment(xCoordinate);
        } else if (directionDomain.movingToNorth()) {
            yCoordinate = increment(yCoordinate);
        }
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
