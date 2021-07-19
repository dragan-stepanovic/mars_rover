public class Rover {

    public static final int INFINITE_ENOUGH_GRID_SIZE = 10000;

    private final Coordinates coordinates = Coordinates.initial();
    private final Direction direction = Direction.initial();

    public String execute(String commands) {
        return execute(commands, INFINITE_ENOUGH_GRID_SIZE);
    }

    public String execute(String commands, int gridSize) {
        for (char command : split(commands))
            execute(command, gridSize);

        return toString();
    }

    private void execute(char issuedCommand, int gridSize) {
        switch (issuedCommand) {
            case Command.ROTATE_LEFT:
                direction.rotateLeft();
                break;
            case Command.ROTATE_RIGHT:
                direction.rotateRight();
                break;
            case Command.MOVE:
                moveOnGridWith(gridSize);
                break;
        }
    }

    private void moveOnGridWith(int gridSize) {
        if (direction.isFacingSouth()) {
            coordinates.decrementY(gridSize);
        } else if (direction.isFacingWest()) {
            coordinates.decrementX(gridSize);
        } else if (direction.isFacingEast()) {
            coordinates.incrementX(gridSize);
        } else if (direction.isFacingNorth()) {
            coordinates.incrementY(gridSize);
        }
    }

    private char[] split(String commands) {
        return commands.toCharArray();
    }

    @Override
    public String toString() {
        return coordinates.asString() + ":" + direction.asChar();
    }
}
