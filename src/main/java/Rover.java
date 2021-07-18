public class Rover {

    public static final int INFINITE_ENOUGH_GRID_SIZE = 10000;

    private final Position position = Position.initial();

    public String execute(String commands) {
        return this.execute(commands, INFINITE_ENOUGH_GRID_SIZE);
    }

    public String execute(String commands, int gridSize) {
        for (char command : split(commands))
            execute(command, gridSize);

        return new Position(position.x(), position.y(), position.direction()).asString();
    }

    private void execute(char issuedCommand, int gridSize) {
        switch (issuedCommand) {
            case Command.ROTATE_LEFT:
                position.rotateLeft();
                break;
            case Command.ROTATE_RIGHT:
                position.rotateRight();
                break;
            case Command.MOVE:
                moveOnGridWith(gridSize, position.direction());
                break;
        }
    }

    private void moveOnGridWith(int gridSize, Direction direction) {
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

    private char[] split(String commands) {
        return commands.toCharArray();
    }
}
