import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoverTest {

    @Test
    void can_move_y() {
        Rover rover = aRover();
        assertEquals("(0,1,N)", rover.move());
        assertEquals("(0,2,N)", rover.move());
        assertEquals("(0,3,N)", rover.move());
    }

    @Test
    void can_move_by_x() {
        Rover rover = aRover();
        assertEquals("(0,1,N)", rover.move());
    }

    private Rover aRover() {
        return new Rover();
    }
}
