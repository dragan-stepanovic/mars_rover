public class Rover {

    private int xCoordinate = 0;
    private int yCoordinate = 0;
    private Direction direction = Direction.north();

    public static final char ROTATE_LEFT = 'L';
    public static final char ROTATE_RIGHT = 'R';
    public static final char MOVE = 'M';

    public String execute(String commands) {
        for (char command : commands.toCharArray())
            execute(command);

        return new Position(xCoordinate, yCoordinate, direction).asString();
    }

    private void execute(char command) {
        switch (command) {
            case ROTATE_LEFT:
                rotateLeft();
                break;
            case ROTATE_RIGHT:
                rotateRight();
                break;
            case MOVE:
                move();
                break;
        }
    }

    private void move() {
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

    private void rotateRight() {
        direction = direction.rightOfIt();
    }

    private void rotateLeft() {
        direction = direction.leftOfIt();
    }

    @Override
    public String toString() {
        return "Rover{" +
                "xCoordinate=" + xCoordinate +
                ", yCoordinate=" + yCoordinate +
                ", direction=" + direction +
                '}';
    }
}
