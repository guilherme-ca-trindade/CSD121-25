package lab5.players;

import lab5.game.PlayerToken;
import lab5.game.Board;
import lab5.game.Col;
import lab5.game.Position;
import lab5.game.Row;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class OmolaPlayer extends Player{
    public OmolaPlayer(String name){
        super(name);
    }

    @Override
    public Position pickNextMove(Board currentBoard) {
        PlayerToken myToken = currentBoard.getNextTurnToken();
        PlayerToken opponentToken;
        if (myToken == PlayerToken.X) {
            opponentToken = PlayerToken.O;
        } else {
            opponentToken = PlayerToken.X;
        }
        List<Position> empty = currentBoard.getEmptyCells();

        // Pick winning movement
        for (Position pos : empty) {
            Board copyOf = new Board(currentBoard);
            copyOf.place(pos, myToken);
            if (copyOf.getWinner() == myToken) {
                return pos;
            }
        }
        // Block opponent winning movement
        for (Position pos : empty) {
            Board copyOf = new Board(currentBoard);
            copyOf.place(pos, opponentToken);
            if (copyOf.getWinner() == opponentToken) {
                return pos;
            }
        }

        //Pick random move with priority: center > corners > edges
        List<Position> center = List.of(new Position(Row.Middle, Col.Middle));
        List<Position> corners = List.of(
                new Position(Row.Top, Col.Left),
                new Position(Row.Top, Col.Right),
                new Position(Row.Bottom, Col.Left),
                new Position(Row.Bottom, Col.Right)
        );
        List<Position> edges = List.of(
                new Position(Row.Top, Col.Middle),
                new Position(Row.Middle, Col.Left),
                new Position(Row.Middle, Col.Right),
                new Position(Row.Bottom, Col.Middle)
        );
        //Shuffle the lists to randomize them
        List<Position> shuffledCorners = new ArrayList<>(corners);
        List<Position> shuffledEdges = new ArrayList<>(edges);
        Collections.shuffle(shuffledCorners);
        Collections.shuffle(shuffledEdges);

        for (Position pos : center) {
            if (currentBoard.isEmptyAt(pos)) return pos;
        }
        for (Position pos : shuffledCorners) {
            if (currentBoard.isEmptyAt(pos)) return pos;
        }
        for (Position pos : shuffledEdges) {
            if (currentBoard.isEmptyAt(pos)) return pos;
        }

        throw new IllegalStateException("No moves available");
    }
}

