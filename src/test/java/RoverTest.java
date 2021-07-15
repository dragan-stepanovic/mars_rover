import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoverTest {

    @Test
    void wraps_around_the_grid() {
        final int[] ints = new int[]{2, 2};
        assertEquals("0:0:N", aRover().execute("MM", ints[1]));
        final int[] ints1 = new int[]{2, 2};
        assertEquals("0:0:E", aRover().execute("RMM", ints1[1]));
        final int[] ints2 = new int[]{2, 2};
        assertEquals("1:0:N", aRover().execute("RMLMM", ints2[1]));
        final int[] ints3 = new int[]{2, 2};
        assertEquals("1:0:W", aRover().execute("LM", ints3[1]));
        final int[] ints4 = new int[]{2, 2};
        assertEquals("0:1:S", aRover().execute("RRM", ints4[1]));
        final int[] ints5 = new int[]{4, 4};
        assertEquals("2:3:S", aRover().execute("RMMRM", ints5[1]));
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
