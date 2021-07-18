public class Position {

    Direction direction;

    private Position(Direction direction) {
        this.direction = direction;
    }

    static Position initial() {
        return new Position(Direction.initial());
    }

    boolean movingToSouth() {
        return this.direction.movingToSouth();
    }

    boolean movingToWest() {
        return this.direction.movingToWest();
    }

    boolean movingToEast() {
        return this.direction.movingToEast();
    }

    boolean movingToNorth() {
        return this.direction.movingToNorth();
    }
}
