public class Rover {

    private String position = "(0,0,N)";

    public String move() {
        if (position.equals("(0,1,N)")) {
            position = "(0,2,N)";
            return position;
        }

        if (position.equals("(0,2,N)")) {
            position = "(0,3,N)";
            return position;
        }

        position = "(0,1,N)";
        return position;
    }
}
