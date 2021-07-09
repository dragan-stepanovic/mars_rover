import java.util.Map;

public class Rover {

    public static final String INITIAL_POSITION = "(0,0,N)";
    private final Map<Character, Character> rotateRight =
            Map.of('N', 'E',
                    'E', 'S',
                    'S', 'W',
                    'W', 'N');

    private String position = INITIAL_POSITION;

    public String move() {
        if (movingToEast()) {
            position = "(" + increment(xCoordinateOf(position)) + ",0,E)";
            return position;
        }

        position = "(0," + increment(yCoordinateOf(position)) + ",N)";
        return position;
    }

    private boolean movingToEast() {
        return directionOf(this.position) == 'E';
    }

    public String rotateRight() {
        position = withDirection(rotateRight.get(directionOf(position)));
        return position;
    }

    private int increment(int value) {
        return value + 1;
    }

    private String withDirection(Character direction) {
        return "(0,0," + direction + ")";
    }

    private char directionOf(String position) {
        return position.charAt(5);
    }

    private int xCoordinateOf(String position) {
        return Character.getNumericValue(position.charAt(1));
    }

    private int yCoordinateOf(String position) {
        return Character.getNumericValue(position.charAt(3));
    }
}
