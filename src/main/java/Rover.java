import java.util.Map;

public class Rover {

    public static final char SOUTH = 'S';

    private final Map<Character, Character> directionToRightOfIt =
            Map.of(Direction.NORTH, Direction.EAST,
                    Direction.EAST, SOUTH,
                    SOUTH, Direction.WEST,
                    Direction.WEST, Direction.NORTH);

    private int xCoordinate = 0;
    private int yCoordinate = 0;
    private char direction = Direction.NORTH;
    private Direction directionDomain = Direction.north();

    public void move() {
        if (movingToSouth()) {
            yCoordinate = decrement(yCoordinate);
        } else if (directionDomain.movingToWest()) {
            xCoordinate = decrement(xCoordinate);
        } else if (directionDomain.movingToEast(direction)) {
            xCoordinate = increment(xCoordinate);
        } else if (directionDomain.movingToNorth()) {
            yCoordinate = increment(yCoordinate);
        }
    }

    private boolean movingToSouth() {
        return direction == SOUTH;
    }

    private int increment(int value) {
        return value + 1;
    }

    private int decrement(int value) {
        return value - 1;
    }

    public void rotateRight() {
        directionDomain = new Direction(directionToRightOfIt.get(direction));
        direction = directionToRightOfIt.get(direction);
    }

    String position() {
        return asString(xCoordinate, yCoordinate, direction);
    }

    private String asString(int xCoordinate, int yCoordinate, Character direction) {
        return "(" + xCoordinate + "," + yCoordinate + "," + direction + ")";
    }
}
