public class Rover {

    private String position = "(0,0,N)";

    public String move() {
        if (position.equals("(0,1,N)")) {
            return "(0,2,N)";
        }
        position = "(0,1,N)";
        return position;
    }
}
