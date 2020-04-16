package com.company;

import java.util.LinkedList;
import java.util.Random;

public abstract class Moose implements Player {
    protected LinkedList<Integer> moves;
    protected LinkedList<Integer> opponentMoves;
    public String name;

    public Moose() {
        this.name = "Moose";
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

        // save opponent's move
        this.opponentMoves.push(opponentLastMove);

        // make move (first one is random)
        move = opponentLastMove == 0 ? new Random().nextInt(3) + 1 : this.decide(xA, xB, xC);

        // save current move
        this.moves.push(move);

        return move;
    }

    @Override
    public String getEmail() {
        return "i.nazmiev@innopolis.ru";
    }

    public String getName() {
        return this.name;
    }

    protected abstract int decide(int xA, int xB, int xC);
}