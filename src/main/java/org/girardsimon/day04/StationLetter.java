package org.girardsimon.day04;

import java.util.Map;

public enum StationLetter {
    X(), M(), A(), S();

    private static final Map<Character, StationLetter> BY_VALUE = Map.of(
            'X', X,
            'M', M,
            'A', A,
            'S', S
    );

    StationLetter() {
    }

    public static StationLetter fromValue(Character value) {
        return BY_VALUE.get(value);
    }
}
