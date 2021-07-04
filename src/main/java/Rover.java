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
        if (position.equals("(0,0,E)")) {
            position = "(0,0,S)";
            return position;
        } else if (position.equals("(0,0,S)")) {
            position = "(0,0,W)";
            return position;
        } else if (position.equals("(0,0,W)")) {
            position = "(0,0,N)";
        } else {
            position = "(0,0,E)";
        }
        return position;
    }

    private int yCoordinateOf(String position) {
        return Character.getNumericValue(position.charAt(3));
    }
}
