public class Rover {

    public static final int INFINITE_ENOUGH_GRID_SIZE = 10000;
    private final Position position = Position.initial();

    public String execute(String commands) {
        return this.execute(commands, INFINITE_ENOUGH_GRID_SIZE);
    }

    public String execute(String commands, int gridSize) {
        for (char command : split(commands))
            execute(command, gridSize);

        return position.asString();
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
                moveOnGridWith(gridSize);
                break;
        }
    }

    private void moveOnGridWith(int gridSize) {
        if (this.position.movingToSouth()) {
            this.position.coordinates.decrementY(gridSize);
        } else if (this.position.movingToWest()) {
            this.position.coordinates.decrementX(gridSize);
        } else if (this.position.movingToEast()) {
            this.position.coordinates.incrementX(gridSize);
        } else if (this.position.movingToNorth()) {
            this.position.coordinates.incrementY(gridSize);
        }
    }

    private char[] split(String commands) {
        return commands.toCharArray();
    }
}
