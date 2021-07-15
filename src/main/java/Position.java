public class Position {

    private int x;
    private int y;
    private final Direction direction;

    public Position(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    public void incrementX(int[] grid) {
        this.x = increment(this.x, grid);
    }

    public void incrementY(int[] grid) {
        this.y = increment(this.y, grid);
    }

    public void decrementX(int[] grid) {
        this.x = decrement(this.x, grid);
    }

    public void decrementY(int[] grid) {
        this.y = decrement(this.y, grid);
    }

    public int increment(int value, int[] grid) {
        int nextPosition = value + 1;
        nextPosition = wrapIfNeeded(nextPosition, grid);
        return nextPosition;
    }

    private int decrement(int value, int[] grid) {
        var nextPosition = value - 1;
        nextPosition = wrapIfNeeded(nextPosition, grid);
        return nextPosition;
    }

    private int wrapIfNeeded(int nextPosition, int[] grid) {
        if (offGridAboveMax(nextPosition, grid)) {
            return wrapAroundMin();
        }
        if (offGridUnderMin(nextPosition)) {
            return wrapAroundMax(grid);
        }
        return nextPosition;
    }

    private static int wrapAroundMin() {
        return 0;
    }

    private static boolean offGridAboveMax(int nextPosition, int[] grid) {
        return nextPosition == max(grid[1]);
    }

    private static int max(int gridSize) {
        return gridSize;
    }

    private static boolean offGridUnderMin(int nextPosition) {
        return nextPosition < 0;
    }

    private int wrapAroundMax(int[] grid) {
        return max(grid[1]) - 1;
    }

    String asString() {
        return this.x + ":" + this.y + ":" + this.direction.asChar();
    }
}
