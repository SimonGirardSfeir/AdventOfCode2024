package org.girardsimon.day04;

import java.util.Map;

public enum StationLetter {
    X('X'), M('M'), A('A'), S('S');

    private static final Map<Character, StationLetter> BY_VALUE = Map.of(
            'X', X,
            'M', M,
            'A', A,
            'S', S
    );

    private final char value;

    StationLetter(char value) {
        this.value = value;
    }

    public static StationLetter fromValue(Character value) {
        return BY_VALUE.get(value);
    }
}
