import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoverTest {

    @Test
    void initial_position_is_zero() {
        Rover rover = aRover();
        assertEquals("(0,0,N)", rover.position());
    }

    @Test
    void can_rotate() {
        Rover rover = aRover();
        assertEquals("(0,0,E)", rover.rotate());
    }

    private Rover aRover() {
        return new Rover();
    }
}
