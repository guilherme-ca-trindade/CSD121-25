package lab5.players;

import lab5.game.Board;
import lab5.game.Col;
import lab5.game.Position;
import lab5.game.Row;
import lab5.players.Player;
import java.util.List;

public class CircePlayer extends Player {
    public CircePlayer(String name) {
        super(name);
    }

    @Override
    public Position pickNextMove(Board currentBoard) {
        Position[] priorityOrder = {
                new Position(Row.Middle, Col.Middle),
                new Position(Row.Top, Col.Middle),
                new Position(Row.Top, Col.Right),
                new Position(Row.Middle, Col.Right),
                new Position(Row.Bottom, Col.Right),
                new Position(Row.Bottom, Col.Middle),
                new Position(Row.Bottom, Col.Left),
                new Position(Row.Middle, Col.Left),
                new Position(Row.Top, Col.Left)
        };

        for(Position p: priorityOrder ) {
            if (currentBoard.isEmptyAt(p)){
                return p;
        }
    }
        throw new IllegalStateException("No empty positions available");
}
}
