import java.util.Map;

public class Rover {

    private final Map<Character, Character> directionToRightOfIt =
            Map.of(Direction.NORTH, Direction.EAST,
                    Direction.EAST, Direction.SOUTH,
                    Direction.SOUTH, Direction.WEST,
                    Direction.WEST, Direction.NORTH);

    private int xCoordinate = 0;
    private int yCoordinate = 0;
    private Direction direction = Direction.north();

    public void move() {
        if (direction.movingToSouth()) {
            yCoordinate = decrement(yCoordinate);
        } else if (direction.movingToWest()) {
            xCoordinate = decrement(xCoordinate);
        } else if (direction.movingToEast()) {
            xCoordinate = increment(xCoordinate);
        } else if (direction.movingToNorth()) {
            yCoordinate = increment(yCoordinate);
        }
    }

    private int increment(int value) {
        return value + 1;
    }

    private int decrement(int value) {
        return value - 1;
    }

    public void rotateRight() {
        direction = new Direction(directionToRightOfIt.get(direction.asChar()));
    }

    String position() {
        return asString(xCoordinate, yCoordinate, direction);
    }

    private String asString(int xCoordinate, int yCoordinate, Direction directionDomain) {
        return "(" + xCoordinate + "," + yCoordinate + "," + directionDomain.asChar() + ")";
    }
}
