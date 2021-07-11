public class Position {

    private final int x;
    private final int y;
    private final Direction direction;

    public Position(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    String asString(int xCoordinate, int yCoordinate, Direction direction) {
        return x + ":" + y + ":" + this.direction.asChar();
    }
}
