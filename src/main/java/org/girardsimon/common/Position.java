package org.girardsimon.common;

public record Position(int x, int y) implements Comparable<Position> {
    public Position fromDelta(int dx, int dy) {
        return new Position(x + dx, y+ dy);
    }

    @Override
    public int compareTo(Position o) {
        return Math.abs(x - o.x()) + Math.abs(y - o.y());
    }
}
