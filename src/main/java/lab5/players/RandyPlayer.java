package lab5.players;

import lab5.game.Board;
import lab5.game.Position;
import lab5.players.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class RandyPlayer extends Player {
    private static final Random rand = new Random();

    public RandyPlayer(String name){
        super(name);
    }

    @Override
    public Position pickNextMove(Board currentBoard) {
        List<Position> emptyCells = currentBoard.getEmptyCells();
        return emptyCells.get(rand.nextInt(emptyCells.size()));
    }
}
