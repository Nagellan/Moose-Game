package com.company;

import java.util.Random;

/**
 * Always chooses the field with the second highest gain.
 * If there's no non-zero choice except the highest gain - it'll choose the it.
 */
public class Unfussy extends Greedy {
    public Unfussy() {
        super();
        this.name = "Unfussy";
    }

    @Override
    protected int decide(int xA, int xB, int xC) {
        int[] fields = {xA, xB, xC};
        int indexMax = super.decide(xA, xB, xC) - 1;

        // choose the second highest gain

        if (fields[(indexMax + 1) % 3] == fields[(indexMax + 2) % 3]) {
            if (fields[(indexMax + 1) % 3] != 0) {
                indexMax = new Random().nextBoolean() ? (indexMax + 1) % 3 : (indexMax + 2) % 3;
            }
        } else if (fields[(indexMax + 1) % 3] > fields[(indexMax + 2) % 3]) {
            indexMax = (indexMax + 1) % 3;
        } else {
            indexMax = (indexMax + 2) % 3;
        }

        return indexMax + 1;
    }
}
