package lab5;

import lab5.game.*;
import lab5.players.OmolaPlayer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OmolaPlayerTest {
    @Test
    public void testOmolaWins() {
        OmolaPlayer omola = new OmolaPlayer("Omola");
        Board board = new Board();

        // Omola is X
        board.placeX(new Position(Row.Top, Col.Left));
        board.placeX(new Position(Row.Top, Col.Middle));
        board.placeO(new Position(Row.Middle, Col.Middle));
        PlayerToken omolaToken = board.getNextTurnToken();
        Position move = omola.pickNextMove(board);
        Position expected = new Position(Row.Top, Col.Right);

        assertEquals(expected, move, "Omola should win");
    }

    @Test
    public void testOmolaBlocks() {
        OmolaPlayer omola = new OmolaPlayer("Omola");
        Board board = new Board();

        // Opponent is X
        board.placeX(new Position(Row.Bottom, Col.Left));
        board.placeX(new Position(Row.Bottom, Col.Middle));
        board.placeO(new Position(Row.Top, Col.Left));
        PlayerToken omolaToken = board.getNextTurnToken();
        Position move = omola.pickNextMove(board);
        Position expected = new Position(Row.Bottom, Col.Right);

        assertEquals(expected, move, "Omola should block opponent's winning move");
    }

    @Test
    public void testOmolaRandomVariation() {
        OmolaPlayer omola = new OmolaPlayer("Omola");
        Board board = new Board();

        // Omola must pick a corner or edge
        board.place(new Position(Row.Middle, Col.Middle), PlayerToken.X);
        Position firstPick = omola.pickNextMove(new Board(board));
        Position secondPick = omola.pickNextMove(new Board(board));

        // Check if it picks different positions
        boolean isDifferent = !firstPick.equals(secondPick);

        assertTrue(isDifferent, "Omola should pick different movements");
    }

    @Test
    public void testOmolaPicksSameMoveTwice() {
        OmolaPlayer omola = new OmolaPlayer("Omola");
        Board board = new Board();

        // Omola must pick a corner or edge
        board.place(new Position(Row.Middle, Col.Middle), PlayerToken.X);
        Position firstPick = omola.pickNextMove(new Board(board));
        Position secondPick = omola.pickNextMove(new Board(board));

        // Check if it picked the same movement both times
        assertEquals(firstPick, secondPick, "Omola may pick the same movement if randomness is consistent");
    }


}
