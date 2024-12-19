package org.girardsimon.day12;

import org.girardsimon.common.Position;

public record Segment(Position start, Position end) {

    public Segment {
        if(start.x() == end.x() || start.y() == end.y()) {
            // Ensure consistent ordering of start and end
            if((start.x() == end.x() && start.y() > end.y()) || (start.y() == end.y() && start.x() > end.x())) {
                Position temp = start;
                start = end;
                end = temp;
            }
        } else {
            throw new IllegalArgumentException("Diagonal segments are not considered here");
        }
    }

    boolean isSegmentAddableToLeft(Segment segment) {
        return isHorizontal() && start.equals(segment.end());
    }

    boolean isSegmentAddableToRight(Segment segment) {
        return isHorizontal() && end.equals(segment.start());
    }

    boolean isSegmentAddableToTop(Segment segment) {
        return isVertical() && end.equals(segment.start());
    }

    boolean isSegmentAddableToDown(Segment segment) {
        return isVertical() && start.equals(segment.end());
    }

    private boolean isHorizontal() {
        return start.y() == end.y();
    }

    private boolean isVertical() {
        return start.x() == end.x();
    }
}
