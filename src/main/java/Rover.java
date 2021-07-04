public class Rover {

    private String position = "(0,0,N)";

    public String move() {
        int yPosition = yPositionFrom(position) + 1;
        if (position.equals("(0,0,N)")) {
            position = "(0," + yPosition + ",N)";
        } else if (position.equals("(0,1,N)")) {
            position = "(0," + yPosition + ",N)";
        } else if (position.equals("(0,2,N)")) {
            position = "(0," + yPosition + ",N)";
        }

        return position;
    }

    private int yPositionFrom(String position) {
        return Character.getNumericValue(position.charAt(3));
    }
}
