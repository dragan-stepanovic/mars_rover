public class Rover {

    private Coordinates coordinates = Coordinates.initial();
    private Direction direction = Direction.initial();

    public String execute(String commands) {
        return execute(commands, Grid.INFINITE_ENOUGH);
    }

    public String execute(String commands, Grid grid) {
        for (char command : split(commands))
            execute(command, grid);

        return toString();
    }

    private void execute(char issuedCommand, Grid grid) {
        switch (issuedCommand) {
            case Command.ROTATE_LEFT:
                this.direction = direction.rotateLeft();
                break;
            case Command.ROTATE_RIGHT:
                this.direction = direction.rotateRight();
                break;
            case Command.MOVE:
                this.coordinates = moveOn(grid);
                break;
        }
    }

    private Coordinates moveOn(Grid grid) {
        if (direction == Direction.NORTH) return coordinates.incrementY(grid);
        if (direction == Direction.EAST) return coordinates.incrementX(grid);
        if (direction == Direction.SOUTH) return coordinates.decrementY(grid);
        return coordinates.decrementX(grid);
    }

    private char[] split(String commands) {
        return commands.toCharArray();
    }

    @Override
    public String toString() {
        return coordinates.asString() + ":" + direction.asChar();
    }
}
