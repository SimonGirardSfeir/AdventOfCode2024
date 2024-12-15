package org.girardsimon.day10;

import java.util.Set;

public class TrailHeadRatingCalculator {

    private final TrailTracker trailTracker;

    public TrailHeadRatingCalculator(TrailTracker trailTracker) {
        this.trailTracker = trailTracker;
    }

    public long sumTrailHeadRating(TopographicMap topographicMap) {
        return topographicMap.positions().stream()
                .filter(TopographicMapPosition::isPossibleHikingTrailStart)
                .mapToLong(mapPosition -> countTrailHeadRating(mapPosition, topographicMap.positions()))
                .sum();
    }

    private long countTrailHeadRating(TopographicMapPosition mapPosition, Set<TopographicMapPosition> topographicMapPositions) {
        TrailTrackerResult trailTrackerResult = trailTracker.initTracking(mapPosition, topographicMapPositions);
        return trailTrackerResult.numberOfTrailingPath();
    }
}
