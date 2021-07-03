import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoverTest {

    @Test
    void initial_position_is_zero() {
        assertEquals("(0,0,N)", aRover().position());
    }

    @Test
    void can_rotate() {
        assertEquals("(0,0,E)", aRover().rotate());
    }

    private Rover aRover() {
        return new Rover();
    }
}
