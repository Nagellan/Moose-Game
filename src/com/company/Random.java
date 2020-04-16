package com.company;

public class Random extends Moose {
    @Override
    protected int decide(int xA, int xB, int xC) {
        return new java.util.Random().nextInt(3) + 1;
    }
}
