package org.girardsimon.common;

public record Position(int x, int y) {
    public Position fromDelta(int dx, int dy) {
        return new Position(x + dx, y+ dy);
    }
}
