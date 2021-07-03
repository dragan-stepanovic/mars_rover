import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ThingTest {

    @Test
    void fail() {
        Thing thing = new Thing();
        String value = thing.callForAction();
        assertEquals("Food", value);
    }

    @Test
    void it_should_not_fail() {
        assertTrue(true);
    }
}
