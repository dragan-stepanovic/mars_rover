public class Rover {

    private Coordinates coordinates = Coordinates.initial();
    private Direction direction = Direction.initial();

    public String execute(String commands) {
        return execute(commands, Grid.INFINITE_ENOUGH);
    }

    public String execute(String commands, Grid grid) {
        for (char command : split(commands))
            execute(command, grid);

        return positionAsString();
    }

    private void execute(char issuedCommand, Grid grid) {
        switch (issuedCommand) {
            case Command.ROTATE_LEFT:
                this.direction = direction.toTheLeft();
                break;
            case Command.ROTATE_RIGHT:
                this.direction = direction.toTheRight();
                break;
            case Command.MOVE:
                this.coordinates = moveOn(grid);
                break;
        }
    }

    private Coordinates moveOn(Grid grid) {
        switch (direction) {
            case NORTH:
                return coordinates.incrementY(grid);
            case EAST:
                return coordinates.incrementX(grid);
            case SOUTH:
                return coordinates.decrementY(grid);
            default:
                return coordinates.decrementX(grid);
        }
    }

    private char[] split(String commands) {
        return commands.toCharArray();
    }

    public String positionAsString() {
        return coordinates.asString() + ":" + direction.asChar();
    }
}
