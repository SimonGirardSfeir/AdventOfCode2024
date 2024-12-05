package org.girardsimon.common;

public enum Direction {
    RIGHT("R", 1, 0), LEFT("L", -1, 0), DOWN("D", 0, -1),
    UP("U", 0, 1), UP_LEFT("UL", -1, 1), UP_RIGHT("UR", 1, 1),
    DOWN_LEFT("DL", -1, -1), DOWN_RIGHT("DR", 1, -1);

    private final String label;
    private final int dx;
    private final int dy;

    Direction(String label, int dx, int dy) {
        this.label = label;
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
