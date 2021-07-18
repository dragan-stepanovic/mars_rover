public class Rover {

    public static final int INFINITE_ENOUGH_GRID_SIZE = 10000;

    private final Coordinates coordinates = Coordinates.initial();
    private Direction direction = Direction.initial();

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
                rotateRight();
                break;
            case Command.MOVE:
                moveOnGridWith(gridSize);
                break;
        }
    }

    private void rotateRight() {
        this.direction.rotateRight();
    }

    void rotateLeft() {
        this.direction = this.direction.rotateLeft();
    }

    private void moveOnGridWith(int gridSize) {
        if (this.direction.movingToSouth()) {
            this.coordinates.decrementY(gridSize);
        } else if (this.direction.movingToWest()) {
            this.coordinates.decrementX(gridSize);
        } else if (this.direction.movingToEast()) {
            this.coordinates.incrementX(gridSize);
        } else if (this.direction.movingToNorth()) {
            this.coordinates.incrementY(gridSize);
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
