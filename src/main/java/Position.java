public class Position {

    final Coordinates coordinates;
    private Direction direction;

    private Position(Coordinates coordinates, Direction direction) {
        this.coordinates = coordinates;
        this.direction = direction;
    }

    static Position initial() {
        return new Position(Coordinates.initial(), Direction.initial());
    }

    void rotateRight() {
        this.direction = this.direction.rightOfIt();
    }

    void rotateLeft() {
        this.direction = this.direction.leftOfIt();
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

    String asString() {
        return coordinates.asString() + ":" + this.direction.asChar();
    }
}
