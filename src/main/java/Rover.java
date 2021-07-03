public class Rover {

    private String position = "(0,0,N)";

    public String rotate() {
        if (position.equals("(0,0,E)")) {
            position = "(0,0,S)";
            return position;
        } else if (position.equals("(0,0,S)"))
            return "(0,0,W)";
        else {
            position = "(0,0,E)";

        }
        return position;
    }
}
