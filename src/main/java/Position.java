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

    public void decrementX(int[] grid) {
        this.x = decrement(grid, this.x);
    }

    public void incrementY(int[] grid) {
        this.y = increment(this.y, grid);
    }

    public void decrementY(int[] grid) {
        this.y = decrement(grid, this.y);
    }

    private static boolean offGridUnderMin(int nextPosition) {
        return nextPosition < 0;
    }

    private static boolean offGridAboveMax(int nextPosition, int[] grid) {
        return nextPosition == maxY(grid);
    }

    public static int increment(int value, int[] grid) {
        int nextPosition = value + 1;
        if (offGridAboveMax(nextPosition, grid))
            nextPosition = wrapAroundMin();

        return nextPosition;
    }

    private int decrement(int[] grid, int value) {
        var nextPosition = value - 1;
        nextPosition = wrapIfNeeded(grid, nextPosition);
        return nextPosition;
    }

    private static int wrapAroundMin() {
        return 0;
    }

    private int wrapIfNeeded(int[] grid, int nextPosition) {
        if (offGridAboveMax(nextPosition, grid)) {
            return grid[1] - 1;
        } else if (offGridUnderMin(nextPosition)) {
            return grid[1] - 1;
        }
        return nextPosition;
    }

    private static int maxY(int[] grid) {
        return grid[1];
    }

    String asString() {
        return this.x + ":" + this.y + ":" + this.direction.asChar();
    }
}
