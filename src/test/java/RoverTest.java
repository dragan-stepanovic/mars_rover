import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoverTest {

    @Test
    void can_move_to_west() {
        final Rover rover = aRover();
        rover.rotateRight();
        rover.move();
        rover.move();
        rover.move();
        rover.rotateRight();
        rover.rotateRight();
        assertEquals("(2,0,W)", rover.move());
        assertEquals("(1,0,W)", rover.move());
    }

    @Test
    void can_move_to_south() {
        final Rover rover = aRover();
        rover.move();
        rover.move();
        rover.move();
        rover.rotateRight();
        rover.rotateRight();
        rover.move();
        assertEquals("(0,2,S)", rover.position());
        rover.move();
        assertEquals("(0,1,S)", rover.position());
    }

    @Test
    void can_move_to_east_and_north() {
        final Rover rover = aRover();
        rover.rotateRight();
        rover.move();
        assertEquals("(1,0,E)", rover.position());
        rover.move();
        assertEquals("(2,0,E)", rover.position());
        assertEquals("(3,0,E)", rover.move());
        rotateToNorth(rover);
        assertEquals("(3,1,N)", rover.move());
        rover.rotateRight();
        rover.move();
        assertEquals("(5,1,E)", rover.move());
        rotateToNorth(rover);
        rover.move();
        rover.move();
        assertEquals("(5,4,N)", rover.move());
    }

    private void rotateToNorth(Rover rover) {
        rover.rotateRight();
        rover.rotateRight();
        rover.rotateRight();
    }

    @Test
    void can_rotate_right_full_circle() {
        Rover rover = aRover();
        assertEquals("(0,0,E)", rover.rotateRight());
        assertEquals("(0,0,S)", rover.rotateRight());
        assertEquals("(0,0,W)", rover.rotateRight());
        assertEquals("(0,0,N)", rover.rotateRight());
        assertEquals("(0,0,E)", rover.rotateRight());
    }

    private Rover aRover() {
        return new Rover();
    }
}
