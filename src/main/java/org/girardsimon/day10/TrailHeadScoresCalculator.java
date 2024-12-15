package org.girardsimon.day10;

import java.util.Set;

public class TrailHeadScoresCalculator {

    private final TrailTracker trailTracker;

    public TrailHeadScoresCalculator(TrailTracker trailTracker) {
        this.trailTracker = trailTracker;
    }

    long sumTrailHeadScores(TopographicMap topographicMap) {
        return topographicMap.positions().stream()
                .filter(TopographicMapPosition::isPossibleHikingTrailStart)
                .mapToLong(mapPosition -> countTrailheadScore(mapPosition, topographicMap.positions()))
                .sum();
    }

    private long countTrailheadScore(TopographicMapPosition mapPosition, Set<TopographicMapPosition> topographicMapPositions) {
        TrailTrackerResult trailTrackerResult = trailTracker.initTracking(mapPosition, topographicMapPositions);
        return trailTrackerResult.numberOfTopPositionsVisited();
    }
}
