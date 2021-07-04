public class Rover {

    private String position = "(0,0,N)";

    public String move() {
        int yPosition = yPositionFrom(position) + 1;
        position = "(0," + yPosition + ",N)";
        return position;
    }

    private int yPositionFrom(String position) {
        return Character.getNumericValue(position.charAt(3));
    }
}
