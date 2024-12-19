package org.girardsimon.day12;

import org.girardsimon.common.Direction4;
import org.girardsimon.common.Position;

import java.util.function.Predicate;

public final class SegmentUtils {
    private SegmentUtils() {
    }

    /*
        This code is not in Direction4 enum because as of now, this logic is very specific to segment
     */
    static Segment createBorderSegment(Position position, Direction4 direction) {
        return switch (direction) {
            case NORTH -> new Segment(position.fromDelta(0,1), position.fromDelta(1,1));
            case EAST -> new Segment(position.fromDelta(1,0), position.fromDelta(1,1));
            case SOUTH -> new Segment(position, position.fromDelta(1,0));
            case WEST -> new Segment(position, position.fromDelta(0,1));
        };
    }

    static Predicate<Segment> getMergeConditionForLowerNeighbor(Segment segmentToAdd, Direction4 direction) {
        return switch (direction) {
            case NORTH, SOUTH -> segment -> segment.isSegmentAddableToRight(segmentToAdd);
            case EAST, WEST -> segment -> segment.isSegmentAddableToTop(segmentToAdd);
        };
    }

    static Predicate<Segment> getUpperConditionForLowerNeighbor(Segment segmentToAdd, Direction4 direction) {
        return switch (direction) {
            case NORTH, SOUTH -> segment -> segment.isSegmentAddableToLeft(segmentToAdd);
            case EAST, WEST -> segment -> segment.isSegmentAddableToDown(segmentToAdd);
        };
    }
}
