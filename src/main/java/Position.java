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
        var nextPosition = this.x - 1;
        if (nextPosition < 0) {
            this.x = grid[0] - 1;
        } else {
            this.x = nextPosition;
        }
    }

    public void incrementY(int[] grid) {
        this.y = increment(this.y, grid);
    }

    public void decrementY(int[] grid) {
        this.y = decrement(grid, this.y);
    }

    private int decrement(int[] grid, int value) {
        var nextPosition = value - 1;
        if (nextPosition < 0) {
            return grid[1] - 1;
        }

        return nextPosition;
    }

    public static int increment(int value, int[] grid) {
        final int nextPosition = value + 1;
        if (nextPositionGoesOffGrid(grid, nextPosition))
            return wrapAround();

        return nextPosition;
    }

    private static int wrapAround() {
        return 0;
    }

    private static boolean nextPositionGoesOffGrid(int[] grid, int nextPosition) {
        return nextPosition == maxY(grid);
    }

    private static int maxY(int[] grid) {
        return grid[1];
    }

    String asString() {
        return this.x + ":" + this.y + ":" + this.direction.asChar();
    }
}
