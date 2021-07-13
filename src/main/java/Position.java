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

    public void incrementX(int[] grid) {
        this.x = increment(this.x, grid);
    }

    public void incrementY(int[] grid) {
        this.y = increment(this.y, grid);
    }

    public void decrementX() {
        this.x--;
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

    public static int decrement(int value) {
        return value - 1;
    }

    String asString() {
        return x + ":" + y + ":" + direction.asChar();
    }

    public void decrementY() {
        this.y--;
    }
}
