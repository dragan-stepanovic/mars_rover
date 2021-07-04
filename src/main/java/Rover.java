import java.util.Map;

public class Rover {

    public static final String INITIAL_POSITION = "(0,0,N)";
    private final Map<Character, String> rotateRight = Map.of('N', "E",
            'E', "S",
            'S', "W",
            'W', "N");
    private String position = INITIAL_POSITION;

    public String move() {
        position = "(0," + increment(yCoordinateOf(position)) + ",N)";
        return position;
    }

    public String rotateRight() {
        char direction = directionOf(position);
        position = withDirection(rotateRight.get(direction));
        return position;
    }

    private int increment(int value) {
        return value + 1;
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
