import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class RoverTest {

    private Rover rover;

    @BeforeEach
    public void initializeRover() {
        rover = new Rover();
    }

    static Stream<Arguments> wrappingTestInputs() {
        return Stream.of(
                arguments("MM", 2, "0:0:N"),
                arguments("RMM", 2, "0:0:E"),
                arguments("LMMMM", 5, "1:0:W"),
                arguments("RMLMM", 2, "1:0:N"),
                arguments("LM", 2, "1:0:W"),
                arguments("RRM", 2, "0:1:S"),
                arguments("RMMRM", 4, "2:3:S")
        );
    }

    @ParameterizedTest
    @MethodSource("wrappingTestInputs")
    void wraps_around_the_grid(String commands, int gridSize, String result) {
        assertEquals(result, rover.execute(commands, new Grid(gridSize)));
    }

    static Stream<Arguments> interpretingTestInput() {
        return Stream.of(
                arguments("L", "0:0:W"),
                arguments("MMRMLMM", "1:4:N"),
                arguments("RMMMLMMMMLLRM", "2:4:W"),
                arguments("RMMLLRMMMRMMLM", "4:4:N"));
    }

    @ParameterizedTest
    @MethodSource("interpretingTestInput")
    void interprets_command_list(String commands, String result) {
        assertEquals(result, rover.execute(commands));
    }

    @Test
    void can_move_to_west() {
        assertEquals("1:0:W", rover.execute("RMMMRRMM"));
    }

    @Test
    void can_move_to_south() {
        assertEquals("0:1:S", rover.execute("MMMLLMM"));
    }

    @Test
    void can_move_to_east_and_north() {
        assertEquals("5:4:N", rover.execute("RMMMRRRMRMMRRRMMM"));
    }

    @Test
    void can_rotate_full_circle_to_the_right() {
        assertEquals("0:0:E", rover.execute("RRRRR"));
    }

    @Test
    void can_rotate_full_circle_to_the_left() {
        assertEquals("0:0:W", rover.execute("LLLLL"));
    }

}
