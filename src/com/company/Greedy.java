package com.company;

import java.util.Random;

/**
 * Always chooses the field with the highest gain.
 * If there're multiple of them, selects one of them randomly.
 */
public class Greedy extends Moose {
    public Greedy() {
        super();
        this.name = "Greedy";
    }

    @Override
    protected int decide(int xA, int xB, int xC) {
        int[] fields = {xA, xB, xC};
        int indexMax = 0;

        for (int i = 0; i < fields.length; i++) {
            if (fields[i] > fields[indexMax]) {
                indexMax = i;
            }
        }

        // if there're multiple fields with max gain, choose one of them randomly

        boolean maxFieldEqualToNext = fields[indexMax] == fields[(indexMax + 1) % 3];
        boolean maxFieldEqualToPrev = fields[indexMax] == fields[(indexMax + 2) % 3];

        if (maxFieldEqualToNext & maxFieldEqualToPrev) {
            indexMax = new Random().nextInt(3);
        } else if (maxFieldEqualToNext) {
            indexMax = new Random().nextBoolean() ? indexMax : (indexMax + 1) % 3;
        } else if (maxFieldEqualToPrev) {
            indexMax = new Random().nextBoolean() ? indexMax : (indexMax + 2) % 3;
        }

        return indexMax + 1;
    }
}