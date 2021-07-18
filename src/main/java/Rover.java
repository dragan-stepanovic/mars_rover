public class Rover {

    public static final int INFINITE_ENOUGH_GRID_SIZE = 10000;

    private final Position position = Position.initial();

    private final Direction direction = Direction.initial();
    private final Coordinates coordinates = Coordinates.initial();

    public String execute(String commands) {
        return this.execute(commands, INFINITE_ENOUGH_GRID_SIZE);
    }

    public String execute(String commands, int gridSize) {
        for (char command : split(commands))
            execute(command, gridSize);

        return this.toString();
    }

    private void execute(char issuedCommand, int gridSize) {
        switch (issuedCommand) {
            case Command.ROTATE_LEFT:
                rotateLeft();
                break;
            case Command.ROTATE_RIGHT:
                position.rotateRight();
                break;
            case Command.MOVE:
                moveOnGridWith(gridSize);
                break;
        }
    }

    void rotateLeft() {
        this.position.direction = this.position.direction.leftOfIt();
    }

    private void moveOnGridWith(int gridSize) {
        if (this.position.movingToSouth()) {
            this.coordinates.decrementY(gridSize);
        } else if (this.position.movingToWest()) {
            this.coordinates.decrementX(gridSize);
        } else if (this.position.movingToEast()) {
            this.coordinates.incrementX(gridSize);
        } else if (this.position.movingToNorth()) {
            this.coordinates.incrementY(gridSize);
        }
    }

    private char[] split(String commands) {
        return commands.toCharArray();
    }

    @Override
    public String toString() {
        return coordinates.asString() + ":" + position.direction.asChar();
    }
}
