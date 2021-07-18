public class Position {

    Direction direction;

    private Position(Direction direction) {
        this.direction = direction;
    }

    static Position initial() {
        return new Position(Direction.initial());
    }

}
