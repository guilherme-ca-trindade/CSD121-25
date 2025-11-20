package lab5;

import lab5.players.CircePlayer;
import org.junit.jupiter.api.Test;
import lab5.game.Board;
import lab5.game.Position;
import lab5.game.Row;
import lab5.game.Col;

import static org.junit.jupiter.api.Assertions.*;

public class CircePlayerTest {
    @Test
    public void testCirceCenterFirst() {
        CircePlayer circe = new CircePlayer("Circe");
        Board board = new Board();

        Position move = circe.pickNextMove(board);
        Position expected = new Position(Row.Middle, Col.Middle);
        assertEquals(expected, move);
    }
    @Test
    public void testCirceSkipsCenter() {
        CircePlayer circe = new CircePlayer("Circe");
        Board board = new Board();

        board.placeNextToken(new Position(Row.Middle, Col.Middle));    // Take the center
        Position expected = new Position(Row.Top, Col.Middle);
        Position move = circe.pickNextMove(board);
        assertEquals(expected, move);
    }
}