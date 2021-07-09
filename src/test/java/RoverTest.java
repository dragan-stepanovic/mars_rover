import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoverTest {

    @Test
    void can_move_by_y() {
        Rover rover = aRover();
        assertEquals("(0,1,N)", rover.move());
        assertEquals("(0,2,N)", rover.move());
        assertEquals("(0,3,N)", rover.move());
    }

    @Test
    void can_move_by_x() {
        final Rover rover = aRover();
        rover.rotateRight();
        assertEquals("(1,0,E)", rover.move());
        assertEquals("(2,0,E)", rover.move());
    }

    @Test
    void can_rotate_right() {
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
