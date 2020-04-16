package com.company;

/**
 * Always chooses the field randomly.
 */
public class Random extends Moose {
    public Random() {
        super();
        this.name = "Random";
    }

    public Random(Random target) {
        super(target);
    }

    @Override
    protected int decide(int xA, int xB, int xC) {
        return new java.util.Random().nextInt(3) + 1;
    }

    @Override
    public Moose clone() {
        return new Random(this);
    }
}
