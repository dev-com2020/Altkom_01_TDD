import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TicTacToeTest {
    private TicTacToe ticTacToe;

    @BeforeEach
    public void before() {
        ticTacToe = new TicTacToe();
    }

    @Test
    public void whenXOutsideBoardThenRuntimeException() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            ticTacToe.play(5, 2);
        });
        assertEquals("axis is outside board", exception.getMessage());
    }

    @Test
    public void whenYOutsideBoardThenRuntimeException() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            ticTacToe.play(2, 5);
        });
        assertEquals("axis is outside board", exception.getMessage());
    }

    @Test
    public void whenOccupiedThenRuntimeException() {
        ticTacToe.play(2, 1);
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            ticTacToe.play(2, 1);
        });
        assertEquals("Box is occupied", exception.getMessage());
    }

    @Test
    public void givenFirstTurnWhenNextPlayerThenX(){
        assertEquals('X',ticTacToe.nextPlayer());
    }

    @Test
    public void givenLastTurnWasXWhenNextPlayerThen0(){
        ticTacToe.play(1,1);
        assertEquals('0',ticTacToe.nextPlayer());
    }
}
