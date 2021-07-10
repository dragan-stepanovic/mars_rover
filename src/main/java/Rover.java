public class Rover {

    private int xCoordinate = 0;
    private int yCoordinate = 0;
    private Direction direction = Direction.north();

    public String doCommands(String commandsAsString) {
        for (char command : commandsAsString.toCharArray()) {
            if (command == 'L') {
                rotateLeft();
            } else if (command == 'M') {
                move();
            } else if (command == 'R') {
                rotateRight();
            }
        }

        return position();
    }

    public void move() {
        if (direction.movingToSouth()) {
            yCoordinate = decrement(yCoordinate);
        } else if (direction.movingToWest()) {
            xCoordinate = decrement(xCoordinate);
        } else if (direction.movingToEast()) {
            xCoordinate = increment(xCoordinate);
        } else if (direction.movingToNorth()) {
            yCoordinate = increment(yCoordinate);
        }
    }

    private int increment(int value) {
        return value + 1;
    }

    private int decrement(int value) {
        return value - 1;
    }

    public void rotateRight() {
        direction = direction.rightOfIt();
    }

    public void rotateLeft() {
        direction = direction.leftOfIt();
    }

    String position() {
        return asString(xCoordinate, yCoordinate, direction);
    }

    private String asString(int xCoordinate, int yCoordinate, Direction directionDomain) {
        return "(" + xCoordinate + "," + yCoordinate + "," + directionDomain.asChar() + ")";
    }

    @Override
    public String toString() {
        return "Rover{" +
                "xCoordinate=" + xCoordinate +
                ", yCoordinate=" + yCoordinate +
                ", direction=" + direction +
                '}';
    }
}
