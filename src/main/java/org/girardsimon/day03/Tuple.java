package org.girardsimon.day03;

public record Tuple(long x, long y) {
    public long multiply() {
        return x*y;
    }
}
