package org.girardsimon.common;

public enum Direction8 {
    RIGHT(1, 0), LEFT(-1, 0), DOWN(0, -1),
    UP(0, 1), UP_LEFT(-1, 1), UP_RIGHT(1, 1),
    DOWN_LEFT(-1, -1), DOWN_RIGHT(1, -1);

    private final int dx;
    private final int dy;

    Direction8(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public int dx() {
        return dx;
    }
    public int dy() {
        return dy;
    }
}
