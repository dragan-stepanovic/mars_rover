public class Rover {

    private int xCoordinate = 0;
    private int yCoordinate = 0;
    private Direction direction = Direction.north();
    private Position position = new Position(xCoordinate, yCoordinate, direction);

    public String execute(String commands, int[] grid) {
        for (char command : commands.toCharArray())
            execute(command, grid);

        return new Position(xCoordinate, yCoordinate, direction).asString();
    }

    public String execute(String commands) {
        return this.execute(commands, new int[]{100, 100});
    }

    private void execute(char issuedCommand, int[] grid) {
        switch (issuedCommand) {
            case Command.ROTATE_LEFT:
                rotateLeft();
                break;
            case Command.ROTATE_RIGHT:
                rotateRight();
                break;
            case Command.MOVE:
                moveOn(grid);
                break;
        }
    }

    private void moveOn(int[] grid) {
        if (direction.movingToSouth()) {
            yCoordinate = Position.decrement(yCoordinate);
        } else if (direction.movingToWest()) {
            xCoordinate = Position.decrement(xCoordinate);
        } else if (direction.movingToEast()) {
            xCoordinate = Position.increment(xCoordinate, grid);
            position.incrementX(grid);
        } else if (direction.movingToNorth()) {
            yCoordinate = Position.increment(yCoordinate, grid);
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
        return "Rover{xCoordinate=" + xCoordinate + ", yCoordinate=" + yCoordinate + ", direction=" + direction + '}';
    }
}
