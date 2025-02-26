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

    public Tail(Tail target, int postfix) {
        super(target, postfix);
    }

    @Override
    protected int decide(int xA, int xB, int xC) {
        return this.opponentMoves.peek() != null
                ? this.opponentMoves.peek()
                : new Random().nextInt(3) + 1;
    }

    @Override
    public Moose clone(int postfix) {
        return new Tail(this, postfix);
    }
}

