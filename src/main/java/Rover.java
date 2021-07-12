public class Rover {

    private int xCoordinate = 0;
    private int yCoordinate = 0;
    private Direction direction = Direction.north();

    public String execute(String commands, int[] grid) {
        return "";
    }

    public String execute(String commands) {
        for (char command : commands.toCharArray())
            execute(command);

        return new Position(xCoordinate, yCoordinate, direction).asString();
    }

    private void execute(char issuedCommand) {
        switch (issuedCommand) {
            case Command.ROTATE_LEFT:
                rotateLeft();
                break;
            case Command.ROTATE_RIGHT:
                rotateRight();
                break;
            case Command.MOVE:
                move();
                break;
        }
    }

    private void move() {
        if (direction.movingToSouth()) {
            yCoordinate = Position.decrement(yCoordinate);
        } else if (direction.movingToWest()) {
            xCoordinate = Position.decrement(xCoordinate);
        } else if (direction.movingToEast()) {
            xCoordinate = Position.increment(xCoordinate);
        } else if (direction.movingToNorth()) {
            yCoordinate = Position.increment(yCoordinate);
        }
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
