import java.util.Map;

public class Rover {

    public static final Character NORTH = 'N';
    public static final String INITIAL_POSITION = "(0,0," + NORTH + ")";
    public static final Character EAST = 'E';
    private final Map<Character, Character> rotateRight =
            Map.of(NORTH, EAST,
                    EAST, 'S',
                    'S', 'W',
                    'W', NORTH);

    private String position = INITIAL_POSITION;

    public String move() {
        if (movingToEast()) {
            position = "(" + increment(xCoordinateOf(position)) + "," + yCoordinateOf(position) + "," + EAST + ")";
            return position;
        }

        position = "(" + xCoordinateOf(position) + "," + increment(yCoordinateOf(position)) + "," + NORTH + ")";
        return position;
    }

    private boolean movingToEast() {
        return directionOf(this.position) == EAST;
    }

    public String rotateRight() {
        position = withDirection(rotateRight.get(directionOf(position)));
        return position;
    }

    private int increment(int value) {
        return value + 1;
    }

    private String withDirection(Character direction) {
        return "(" + xCoordinateOf(position) + "," + yCoordinateOf(position) + "," + direction + ")";
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
