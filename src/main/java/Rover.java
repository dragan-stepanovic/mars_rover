public class Rover {

    private Direction direction = Direction.north();
    private final Position position = new Position(0, 0, direction);

    public String execute(String commands, int[] gridSize) {
        return executeWithSquareGrid(commands, gridSize);
    }

    private String executeWithSquareGrid(String commands, int[] gridSize) {
        for (char command : commands.toCharArray())
            execute(command, gridSize);

        return new Position(position.x(), position.y(), direction).asString();
    }

    public String execute(String commands) {
        return this.execute(commands, new int[]{100, 100});
    }

    private void execute(char issuedCommand, int[] grid) {
        switch (issuedCommand) {
            case Command.ROTATE_LEFT:
                rotateLeft();
                break;
            case Command.ROTATE_RIGHT:
                rotateRight();
                break;
            case Command.MOVE:
                moveOn(grid);
                break;
        }
    }

    private void moveOn(int[] grid) {
        if (direction.movingToSouth()) {
            position.decrementY(grid[1]);
        } else if (direction.movingToWest()) {
            position.decrementX(grid[1]);
        } else if (direction.movingToEast()) {
            position.incrementX(grid[1]);
        } else if (direction.movingToNorth()) {
            position.incrementY(grid[1]);
        }
    }

    private void rotateRight() {
        direction = direction.rightOfIt();
    }

    private void rotateLeft() {
        direction = direction.leftOfIt();
    }
}
