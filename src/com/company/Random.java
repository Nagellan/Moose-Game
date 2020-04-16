package com.company;

public class Random extends Moose {
    public Random() {
        super();
        this.name = "Random";
    }

    @Override
    protected int decide(int xA, int xB, int xC) {
        return new java.util.Random().nextInt(3) + 1;
    }
}
