package lab5;

import org.junit.jupiter.api.Test;
import lab5.game.Board;
import lab5.players.RandyPlayer;
import lab5.game.Position;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


public class RandyPlayerTest {
    @Test
    public void testRandyPlayer() {
        RandyPlayer randy = new RandyPlayer("Randy");
        List<Position> allMoves = new ArrayList<>();

        int totalRuns = 9999;
        for (int i = 0; i < totalRuns; i++) {
            Board board = new Board();
            Position move = randy.pickNextMove(board);
            allMoves.add(move);
        }
        List<Position> allPossiblePositions = new Board().getEmptyCells();
        for (Position pos : allPossiblePositions) {
            long count = allMoves.stream().filter(p -> p.equals(pos)).count();
            int expected = totalRuns / 9;
            int minRange = (int) (expected * 0.94);
            int maxRange = (int) (expected * 1.06);
            assertTrue(
                    count >= minRange && count <= maxRange,
                    "Position " + pos + " was picked " + count + " times"
            );
        }
    }
}





