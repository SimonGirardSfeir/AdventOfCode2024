package org.girardsimon.day10;

import org.girardsimon.common.Position;

import java.util.Set;

public record TrailTrackerResult(Set<Position> topPositionsVisited, long numberOfTrailingPath) {
    long numberOfTopPositionsVisited() {
        return topPositionsVisited.size();
    }
}
