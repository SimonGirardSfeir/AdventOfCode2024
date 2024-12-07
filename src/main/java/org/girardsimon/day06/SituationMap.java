package org.girardsimon.day06;

import org.girardsimon.common.Position;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public record SituationMap(Set<Position> obstacles, Guard guardInitialPosition, int maxHeight, int maxWidth) {

    public SituationMap {
        obstacles = new HashSet<>(obstacles); // Set must be mutable
    }
    public int countNumberOfGuardVisitedPosition() {
        return new HashSet<>(guardVisitedPositions()).size();
    }

    public int countNumberOfObstaclesThatWillBlockGuard() {
        Set<Position> candidatesToBlockGuard = new HashSet<>(guardVisitedPositions());

        Set<Position> obstaclesThatBlockGuard = new HashSet<>();

        candidatesToBlockGuard
                        .forEach(candidate -> {
                            obstacles.add(candidate);
                            if(trackPath().isLoop) {
                                obstaclesThatBlockGuard.add(candidate);
                            }
                            obstacles.remove(candidate);
                        });

        return obstaclesThatBlockGuard.size();
    }

    private List<Position> guardVisitedPositions() {
        return trackPath().visitedPositions;
    }

    private PathTracker trackPath() {
        Guard slow = guardInitialPosition;
        Guard fast = guardInitialPosition;
        List<Position> visitedPositions= new ArrayList<>();

        while (isInMapLimit(slow.position())) {
            slow = moveSlowGuardToNextStep(slow, visitedPositions);
            fast = moveFastGuardToNextStep(fast);
            fast = moveFastGuardToNextStep(fast);

            if (slow.equals(fast)) {
                return new PathTracker(true, visitedPositions);
            }

        }
        return new PathTracker(false, visitedPositions);
    }

    private Guard moveSlowGuardToNextStep(Guard slow, List<Position> visitedPositions) {
        if(!obstacles.contains(slow.position())) {
            visitedPositions.add(slow.position());
            return slow.moveForward();
        } else {
            return slow.moveBack();
        }
    }

    private Guard moveFastGuardToNextStep(Guard fast) {
        if (!obstacles.contains(fast.position())) {
            return fast.moveForward();
        } else {
            return fast.moveBack();
        }
    }

    public boolean isInMapLimit(Position position) {
        return position.x() < maxWidth && position.x() >= 0
                && position.y() < maxHeight && position.y() >= 0;
    }

    record PathTracker(boolean isLoop, List<Position> visitedPositions) {
    }
}
