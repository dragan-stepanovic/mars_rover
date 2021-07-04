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
            position = "(0,0," + "S)";
        } else if (direction == 'S') {
            position = "(0,0,W)";
        } else if (direction == 'W') {
            position = "(0,0,N)";
        } else {
            position = "(0,0,E)";
        }
        return position;
    }

    private char directionOf(String position) {
        return position.charAt(5);
    }

    private int yCoordinateOf(String position) {
        return Character.getNumericValue(position.charAt(3));
    }
}
