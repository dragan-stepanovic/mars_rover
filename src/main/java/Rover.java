public class Rover {

    private String position = "(0,0,N)";

    public String move() {
        int yPosition = increment(position);
        position = "(0," + yPosition + ",N)";
        return position;
    }

    private int increment(String position) {
        return yPositionFrom(position) + 1;
    }

    private int yPositionFrom(String position) {
        return Character.getNumericValue(position.charAt(3));
    }
}
