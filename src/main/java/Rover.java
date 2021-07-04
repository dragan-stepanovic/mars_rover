import java.util.Map;

public class Rover {

    private String position = "(0,0,N)";
    private final Map<Character, String> rotationRight = Map.of('N', "E",
            'E', "S",
            'S', "W",
            'W', "N");

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
            position = withDirection(rotationRight.get('E'));
        } else if (direction == 'S') {
            position = withDirection(rotationRight.get('S'));
        } else if (direction == 'W') {
            position = withDirection(rotationRight.get('W'));
        } else if (direction == 'N') {
            position = withDirection(rotationRight.get('N'));
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
