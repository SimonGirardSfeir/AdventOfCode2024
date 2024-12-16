package org.girardsimon.day11;

import java.util.List;

public record Stone(long engravedValue) {

    private static final int STONE_MULTIPLIER = 2024;

    public List<Stone> blink() {
        if (engravedValue == 0) {
            return List.of(new Stone(1));
        } else if (numberOfDigits(engravedValue) % 2 == 0) {
            int splitNumberOfDigits = numberOfDigits(engravedValue)/2;

            long firstStoneEngravedValue = (long) (engravedValue / Math.pow(10, splitNumberOfDigits));
            long secondStoneEngravedValue = (long) (engravedValue % Math.pow(10, splitNumberOfDigits));

            return List.of(new Stone(firstStoneEngravedValue), new Stone(secondStoneEngravedValue));

        } else {
            return List.of(new Stone(engravedValue * STONE_MULTIPLIER));
        }
    }

    private int numberOfDigits(long engravedValue) {
        return (int) Math.floor(Math.log10(engravedValue)+1);
    }
}
