import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoverTest {

    @Test
    void fail() {
        Rover rover = new Rover();
        String value = rover.callForAction();
        assertEquals("Food", value);
    }
}
