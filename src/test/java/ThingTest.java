import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThingTest {

    @Test
    void fail() {
        Thing thing = new Thing();
        String value = thing.callForAction();
        assertEquals("Food", value);
    }
}
