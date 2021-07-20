public class Rover {

    private final Coordinates coordinates = Coordinates.initial();
    private final Direction direction = Direction.initial();

    public String execute(String commands) {
        return execute(commands, Grid.INFINITE_ENOUGH_GRID_SIZE);
    }

    public String execute(String commands, Grid grid) {
        for (char command : split(commands))
            execute(command, grid);

        return toString();
    }

    private void execute(char issuedCommand, Grid grid) {
        switch (issuedCommand) {
            case Command.ROTATE_LEFT:
                direction.rotateLeft();
                break;
            case Command.ROTATE_RIGHT:
                direction.rotateRight();
                break;
            case Command.MOVE:
                moveOnGridWith(grid);
                break;
        }
    }

    private void moveOnGridWith(Grid grid) {
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
