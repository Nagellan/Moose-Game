package com.company;

public class Greedy extends Moose {
    @Override
    protected int decide(int xA, int xB, int xC) {
        int[] fields = {xA, xB, xC};
        int indexMax = 0;

        for (int i = 0; i < fields.length; i++) {
            if (fields[i] > fields[indexMax]) {
                indexMax = i;
            }
        }

        return indexMax + 1;
    }
}
