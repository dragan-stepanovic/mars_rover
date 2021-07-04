public class Rover {

    private String position = "(0,0,N)";

    public String move() {
        position = "(0," + increment(yCoordinateOf(position)) + ",N)";
        return position;
    }

    private int increment(int i) {
        return i + 1;
    }

    private int yCoordinateOf(String position) {
        return Character.getNumericValue(position.charAt(3));
    }
}
