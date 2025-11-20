package lab5;

import lab5.players.LinusPlayer;
import org.junit.jupiter.api.Test;
import lab5.game.Board;
import lab5.game.Position;
import lab5.game.Row;
import lab5.game.Col;
import static org.junit.jupiter.api.Assertions.*;

public class LinusPlayerTest {
    @Test
    public void testLinusTopLeft() {
        LinusPlayer linus = new LinusPlayer("Linus");
        Board board = new Board();

        Position move = linus.pickNextMove(board);
        Position expected = new Position(Row.Top, Col.Left);

        assertEquals(expected, move);

    }
}
