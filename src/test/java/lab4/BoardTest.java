package lab4;

import lab4.game.Board;
import lab4.game.Col;
import lab4.game.Position;
import lab4.game.Row;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    @Test
    public void testBoardEmpty() {
        Board board = new Board();
        assertFalse(board.isFull());
    }

    @Test
    public void testBoardInProgress() {
        Board board = new Board();
        assertEquals(Board.Status.InProgress, board.getStatus());
    }

    @Test
    public void testXAndO() {
        Board board = new Board();
        Position posX = new Position(Row.Top, Col.Left);
        board.placeX(posX);
        assertTrue(board.isOccupiedAt(posX));

        Position posO = new Position(Row.Top, Col.Right);
        board.placeO(posO);
        assertTrue(board.isOccupiedAt(posO));
    }


    @Test
    public void testXWinsRow() {
        Board board = new Board();
        board.placeX(new Position(Row.Top, Col.Left));
        board.placeX(new Position(Row.Top, Col.Middle));
        board.placeX(new Position(Row.Top, Col.Right));
        assertEquals(Board.Status.XWins, board.getStatus());
    }

    @Test
    public void testOWinsCol(){
        Board board = new Board();
        board.placeO(new Position(Row.Top, Col.Left));
        board.placeO(new Position(Row.Middle, Col.Left));
        board.placeO(new Position(Row.Bottom, Col.Left));
        assertEquals(Board.Status.OWins, board.getStatus());
    }

    @Test
    public void testXWinsDiagonal() {
        Board board = new Board();
        board.placeX(new Position(Row.Top, Col.Left));
        board.placeX(new Position(Row.Middle, Col.Middle));
        board.placeX(new Position(Row.Bottom, Col.Right));
        assertEquals(Board.Status.XWins, board.getStatus());
    }

    @Test
    public void testDraw() {
        Board board = new Board();
        board.placeX(new Position(Row.Top, Col.Left));
        board.placeO(new Position(Row.Top, Col.Middle));
        board.placeX(new Position(Row.Top, Col.Right));

        board.placeX(new Position(Row.Middle, Col.Left));
        board.placeO(new Position(Row.Middle, Col.Middle));
        board.placeX(new Position(Row.Middle, Col.Right));

        board.placeO(new Position(Row.Bottom, Col.Left));
        board.placeX(new Position(Row.Bottom, Col.Middle));
        board.placeO(new Position(Row.Bottom, Col.Right));

        assertTrue(board.isFull());
        assertEquals(Board.Status.Draw, board.getStatus());
    }

    @Test
    public void testToStringFormat() {
        Board board = new Board();
        board.placeX(new Position(Row.Top, Col.Left));
        board.placeO(new Position(Row.Top, Col.Middle));
        String output = board.toString();
        assertTrue(output.contains("XO"));
        assertEquals(3, output.split("\n").length);
    }
}



