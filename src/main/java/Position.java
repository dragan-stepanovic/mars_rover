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

    private static boolean nextPositionGoesOffGrid(int nextPosition, int[] grid) {
        return nextPosition == maxY(grid) || nextPosition < 0;
    }

    public static int increment(int value, int[] grid) {
        final int nextPosition = value + 1;
        if (nextPositionGoesOffGrid(nextPosition, grid))
            return wrapAround();

        return nextPosition;
    }

    private static int wrapAround() {
        return 0;
    }

    private int decrement(int[] grid, int value) {
        var nextPosition = value - 1;
        if (nextPositionGoesOffGrid(nextPosition, grid)) {
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
