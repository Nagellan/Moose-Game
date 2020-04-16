package com.company;

public class Tail extends Moose {
    public Tail() {
        super();
        this.name = "Tail";
    }

    @Override
    protected int decide(int xA, int xB, int xC) {
        return this.opponentMoves.peek() != null
                ? this.opponentMoves.peek()
                : new java.util.Random().nextInt(3) + 1;
    }
}

