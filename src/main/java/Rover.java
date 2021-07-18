public class Rover {

    public static final int INFINITE_ENOUGH_GRID_SIZE = 10000;

    private final Position position = Position.initial();

    private Direction direction = Direction.initial();
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
                rotateRight();
                break;
            case Command.MOVE:
                moveOnGridWith(gridSize);
                break;
        }
    }

    private void rotateRight() {
        this.position.direction = position.direction.rightOfIt();
        this.direction = this.direction.rightOfIt();
    }

    void rotateLeft() {
        this.position.direction = this.position.direction.leftOfIt();
        this.direction = this.direction.leftOfIt();
    }

    private void moveOnGridWith(int gridSize) {
        if (this.position.direction.movingToSouth()) {
            this.coordinates.decrementY(gridSize);
        } else if (this.position.direction.movingToWest()) {
            this.coordinates.decrementX(gridSize);
        } else if (this.position.direction.movingToEast()) {
            this.coordinates.incrementX(gridSize);
        } else if (this.position.direction.movingToNorth()) {
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
