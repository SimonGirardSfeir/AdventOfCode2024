package org.girardsimon.day10;

import org.girardsimon.common.Position;

public record TopographicMapPosition(int height, Position position) {
    private static final int MAX_HEIGHT = 9;

    boolean isPossibleHikingTrailStart() {
        return height == 0;
    }

    boolean isPossibleEndOfHikingTrail() {
        return height == MAX_HEIGHT;
    }
}
