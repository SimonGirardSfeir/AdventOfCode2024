package org.girardsimon.day10;

import org.girardsimon.common.Direction4;
import org.girardsimon.common.Position;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TrailTracker {

    TrailTrackerResult initTracking(TopographicMapPosition startingPosition, Set<TopographicMapPosition> topographicMapPositions) {
        Set<Position> visitedTopPositions = new HashSet<>();
        long numberOfTrailingPath = trackMap(startingPosition, topographicMapPositions, visitedTopPositions);
        return new TrailTrackerResult(visitedTopPositions, numberOfTrailingPath);
    }

    private long trackMap(
            TopographicMapPosition startingPosition,
            Set<TopographicMapPosition> topographicMapPositions,
            Set<Position> visitedTopPositions) {
        if(startingPosition.isPossibleEndOfHikingTrail()) {
            visitedTopPositions.add(startingPosition.position());
            return 1L;
        }
        return Arrays.stream(Direction4.values())
                .mapToLong(direction -> {
                    Position nextPosition = startingPosition.position().fromDelta(direction.dx(), direction.dy());
                    if (topographicMapPositions.contains(new TopographicMapPosition(startingPosition.height() + 1, nextPosition))) {
                        return trackMap(new TopographicMapPosition(startingPosition.height() + 1, nextPosition), topographicMapPositions, visitedTopPositions);
                    } else {
                        return 0L;
                    }
                })
                .sum();
    }
}
