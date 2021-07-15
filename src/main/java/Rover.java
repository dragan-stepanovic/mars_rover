public class Rover {

    public static final int INFINITE_ENOUGH_GRID_SIZE = 10000;

    private Direction direction = Direction.north();
    private final Position position = new Position(0, 0, direction);

    public String execute(String commands, int gridSize) {
        for (char command : split(commands))
            execute(command, gridSize);

        return new Position(position.x(), position.y(), direction).asString();
    }

    public String execute(String commands) {
        return this.execute(commands, INFINITE_ENOUGH_GRID_SIZE);
    }

    private void execute(char issuedCommand, int gridSize) {
        switch (issuedCommand) {
            case Command.ROTATE_LEFT:
                rotateLeft();
                break;
            case Command.ROTATE_RIGHT:
                rotateRight();
                break;
            case Command.MOVE:
                moveOnGridWith(gridSize);
                break;
        }
    }

    private void moveOnGridWith(int gridSize) {
        if (direction.movingToSouth()) {
            position.decrementY(gridSize);
        } else if (direction.movingToWest()) {
            position.decrementX(gridSize);
        } else if (direction.movingToEast()) {
            position.incrementX(gridSize);
        } else if (direction.movingToNorth()) {
            position.incrementY(gridSize);
        }
    }

    private void rotateRight() {
        direction = direction.rightOfIt();
    }

    private void rotateLeft() {
        direction = direction.leftOfIt();
    }

    private char[] split(String commands) {
        return commands.toCharArray();
    }
}
