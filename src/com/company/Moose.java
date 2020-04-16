package com.company;

import java.util.LinkedList;
import java.util.Random;

public class Moose implements Player {
    private LinkedList<Integer> moves;
    private LinkedList<Integer> opponentMoves;

    public Moose() {
        this.reset();
    }

    @Override
    public void reset() {
        this.moves = new LinkedList<>();
        this.opponentMoves = new LinkedList<>();
    }

    @Override
    public int move(int opponentLastMove, int xA, int xB, int xC) {
        int move;

        // make move (first one is random)
        move = opponentLastMove == 0 ? new Random().nextInt(3) + 1 : this.decide();

        // save moves
        this.moves.push(move);
        this.opponentMoves.push(opponentLastMove);

        return move;
    }

    @Override
    public String getEmail() {
        return "i.nazmiev@innopolis.ru";
    }

    private int decide() {
        return new Random().nextInt(3) + 1;
    }
}