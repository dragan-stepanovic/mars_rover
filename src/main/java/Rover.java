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
                moveOnGridWith(gridSize, new Grid(gridSize));
                break;
        }
    }

    private void moveOnGridWith(int gridSize, Grid grid) {
        if (direction.isFacingNorth()) {
            coordinates.incrementY(grid);
        } else if (direction.isFacingEast()) {
            coordinates.incrementX(grid);
        } else if (direction.isFacingSouth()) {
            coordinates.decrementY(grid);
        } else if (direction.isFacingWest()) {
            coordinates.decrementX(grid);
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
