package com.company;

import java.util.Random;

/**
 * Always chooses the last opponent's field.
 */
public class Tail extends Moose {
    public Tail() {
        super();
        this.name = "Tail";
    }

    @Override
    protected int decide(int xA, int xB, int xC) {
        return this.opponentMoves.peek() != null
                ? this.opponentMoves.peek()
                : new Random().nextInt(3) + 1;
    }
}

