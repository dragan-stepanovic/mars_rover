import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoverTest {

    @Test
    void can_rotate() {
        Rover rover = aRover();
        assertEquals("(0,0,E)", rover.rotate());
        assertEquals("(0,0,S)", rover.rotate());
        assertEquals("(0,0,W)", rover.rotate());
        assertEquals("(0,0,N)", rover.rotate());
    }

    private Rover aRover() {
        return new Rover();
    }
}
