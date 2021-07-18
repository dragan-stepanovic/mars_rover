public class Position {

    private int x;
    private int y;
    private Direction direction;

    public Position(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    static Position initial() {
        return new Position(0, 0, Direction.north());
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    public void incrementX(int gridSize) {
        this.x = increment(this.x, gridSize);
    }

    public void incrementY(int gridSize) {
        this.y = increment(this.y, gridSize);
    }

    public void decrementX(int gridSize) {
        this.x = decrement(this.x, gridSize);
    }

    public void decrementY(int gridSize) {
        this.y = decrement(this.y, gridSize);
    }

    public int increment(int value, int gridSize) {
        int nextPosition = value + 1;
        nextPosition = wrapIfNeeded(nextPosition, gridSize);
        return nextPosition;
    }

    private int decrement(int value, int gridSize) {
        var nextPosition = value - 1;
        nextPosition = wrapIfNeeded(nextPosition, gridSize);
        return nextPosition;
    }

    private static boolean offGridAboveMax(int nextPosition, int gridSize) {
        return nextPosition == max(gridSize);
    }

    private static int wrapAroundMin() {
        return 0;
    }

    private int wrapIfNeeded(int nextPosition, int gridSize) {
        if (offGridAboveMax(nextPosition, gridSize)) {
            return wrapAroundMin();
        }
        if (offGridUnderMin(nextPosition)) {
            return wrapAroundMax(gridSize);
        }
        return nextPosition;
    }

    private static int max(int gridSize) {
        return gridSize;
    }

    private static boolean offGridUnderMin(int nextPosition) {
        return nextPosition < 0;
    }

    private int wrapAroundMax(int gridSize) {
        return max(gridSize) - 1;
    }

    void rotateRight() {
        this.direction = this.direction.rightOfIt();
    }

    void rotateLeft() {
        this.direction = this.direction.leftOfIt();
    }

    String asString() {
        return this.x + ":" + this.y + ":" + this.direction.asChar();
    }

    public Direction direction() {
        return this.direction;
    }

    boolean movingToSouth() {
        return direction().movingToSouth();
    }

    boolean movingToWest() {
        return direction().movingToWest();
    }

    boolean movingToEast() {
        return direction().movingToEast();
    }

    boolean movingToNorth() {
        return direction().movingToNorth();
    }
}
