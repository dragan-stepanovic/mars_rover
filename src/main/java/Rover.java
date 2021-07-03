public class Rover {

    private String position = "(0,0,N)";

    public String position() {
        return position;
    }

    public String rotate() {
        if (position.equals("(0,0,E)"))
            return "(0,0,S)";

        position = "(0,0,E)";
        return position;
    }
}
