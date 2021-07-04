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
        return "";
    }

    private int yCoordinateOf(String position) {
        return Character.getNumericValue(position.charAt(3));
    }
}
