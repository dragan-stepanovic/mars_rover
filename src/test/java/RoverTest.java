import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoverTest {

    @Test
    void initial_position_is_zero() {
        Rover rover = new Rover();
        assertEquals("(0,0,N)", rover.position());
    }
}
