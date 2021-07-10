import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoverTest {

    @Test
    void interprets_command_list() {
        final Rover rover = aRover();
        assertEquals("(0,0,W)", rover.commands('L'));
    }

    @Test
    void can_move_to_west() {
        final Rover rover = aRover();
        rover.rotateRight();
        rover.move();
        rover.move();
        rover.move();
        rover.rotateRight();
        rover.rotateRight();
        rover.move();
        assertEquals("(2,0,W)", rover.position());
        rover.move();
        assertEquals("(1,0,W)", rover.position());
    }

    @Test
    void can_move_to_south() {
        final Rover rover = aRover();
        rover.move();
        rover.move();
        rover.move();
        rover.rotateLeft();
        rover.rotateLeft();
        rover.move();
        assertEquals("(0,2,S)", rover.position());
        rover.move();
        assertEquals("(0,1,S)", rover.position());
    }

    @Test
    void can_move_to_east_and_north() {
        final Rover rover = aRover();
        rover.rotateRight();
        rover.move();
        assertEquals("(1,0,E)", rover.position());
        rover.move();
        assertEquals("(2,0,E)", rover.position());
        rover.move();
        assertEquals("(3,0,E)", rover.position());
        rotateToNorth(rover);
        rover.move();
        assertEquals("(3,1,N)", rover.position());
        rover.rotateRight();
        rover.move();
        rover.move();
        assertEquals("(5,1,E)", rover.position());
        rotateToNorth(rover);
        rover.move();
        rover.move();
        rover.move();
        assertEquals("(5,4,N)", rover.position());
    }

    private void rotateToNorth(Rover rover) {
        rover.rotateRight();
        rover.rotateRight();
        rover.rotateRight();
    }

    @Test
    void can_rotate_full_circle_to_the_right() {
        Rover rover = aRover();
        rover.rotateRight();
        assertEquals("(0,0,E)", rover.position());
        rover.rotateRight();
        assertEquals("(0,0,S)", rover.position());
        rover.rotateRight();
        assertEquals("(0,0,W)", rover.position());
        rover.rotateRight();
        assertEquals("(0,0,N)", rover.position());
        rover.rotateRight();
        assertEquals("(0,0,E)", rover.position());
    }

    @Test
    void can_rotate_full_circle_to_the_left() {
        Rover rover = aRover();
        rover.rotateLeft();
        assertEquals("(0,0,W)", rover.position());
        rover.rotateLeft();
        assertEquals("(0,0,S)", rover.position());
        rover.rotateLeft();
        assertEquals("(0,0,E)", rover.position());
        rover.rotateLeft();
        assertEquals("(0,0,N)", rover.position());
        rover.rotateLeft();
        assertEquals("(0,0,W)", rover.position());
    }

    private Rover aRover() {
        return new Rover();
    }
}
