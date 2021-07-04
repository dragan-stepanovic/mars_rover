public class Rover {

    private String position = "(0,0,N)";

    public String move() {
        position = "(0," + increment(yCoordinateOf(position)) + ",N)";
        return position;
    }

    private int increment(int value) {
        return value + 1;
    }

    public String rotateRight() {
        char direction = directionOf(position);
        if (direction == 'E') {
            position = withDirection("S");
        } else if (direction == 'S') {
            position = withDirection("W");
        } else if (direction == 'W') {
            position = withDirection("N");
        } else if (direction == 'N') {
            position = withDirection("E");
        }
        return position;
    }

    private String withDirection(String direction) {
        return "(0,0," + direction + ")";
    }

    private char directionOf(String position) {
        return position.charAt(5);
    }

    private int yCoordinateOf(String position) {
        return Character.getNumericValue(position.charAt(3));
    }
}
