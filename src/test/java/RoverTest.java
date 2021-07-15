import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoverTest {

    @Test
    void wraps_around_the_grid() {
        assertEquals("0:0:N", aRover().execute("MM", new int[]{2, 2}));
        assertEquals("0:0:E", aRover().execute("RMM", new int[]{2, 2}));
        assertEquals("1:0:N", aRover().execute("RMLMM", new int[]{2, 2}));
        assertEquals("1:0:W", aRover().execute("LM", new int[]{2, 2}));
        assertEquals("0:0:S", aRover().execute("RRM", new int[]{2, 2}));
    }

    @Test
    void interprets_command_list() {
        assertEquals("0:0:W", aRover().execute("L"));
        assertEquals("1:4:N", aRover().execute("MMRMLMM"));
        assertEquals("2:4:W", aRover().execute("RMMMLMMMMLLRM"));
        assertEquals("4:4:N", aRover().execute("RMMLLRMMMRMMLM"));
    }

    @Test
    void can_move_to_west() {
        assertEquals("1:0:W", aRover().execute("RMMMRRMM"));
    }

    @Test
    void can_move_to_south() {
        assertEquals("0:1:S", aRover().execute("MMMLLMM"));
    }

    @Test
    void can_move_to_east_and_north() {
        assertEquals("5:4:N", aRover().execute("RMMMRRRMRMMRRRMMM"));
    }

    @Test
    void can_rotate_full_circle_to_the_right() {
        assertEquals("0:0:E", aRover().execute("RRRRR"));
    }

    @Test
    void can_rotate_full_circle_to_the_left() {
        assertEquals("0:0:W", aRover().execute("LLLLL"));
    }

    private Rover aRover() {
        return new Rover();
    }
}
