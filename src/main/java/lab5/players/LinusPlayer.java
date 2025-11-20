package lab5.players;

import lab5.game.Board;
import lab5.game.Col;
import lab5.game.Position;
import lab5.game.Row;
import lab5.players.Player;
import java.util.List;

public class LinusPlayer extends Player {
    public LinusPlayer(String name) {
        super(name);
    }
    @Override
    public Position pickNextMove(Board currentBoard) {
        Row[] rows = { Row.Top, Row.Middle, Row.Bottom };
        Col[] cols = { Col.Left, Col.Middle, Col.Right };

        for (Row row : rows) {
            for (Col col : cols) {
                Position pos = new Position(row, col);
                if (currentBoard.isEmptyAt(pos)) {
                    return pos;
                }
            }
        }

        throw new IllegalStateException("No empty positions available");
    }
}
