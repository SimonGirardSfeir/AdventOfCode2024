package org.girardsimon.day14;

import org.girardsimon.common.Position;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.girardsimon.day14.SafetyFactorCalculator.Quadrant.NONE;

public class SafetyFactorCalculator {

    int computeBathroomSafetyFactor(Bathroom bathroom, int seconds) {
        int midX = bathroom.width() / 2;
        int midY = bathroom.height() / 2;

        Map<Quadrant, List<Position>> positionsPerQuadrant = bathroom.robots().stream()
                .map(robot -> robot.robotPositionAfterSeconds(seconds, bathroom.width(), bathroom.height()))
                .collect(Collectors.groupingBy(robotPosition -> {
                    if (robotPosition.x() < midX && robotPosition.y() < midY) {
                        return Quadrant.TOP_LEFT;
                    } else if (robotPosition.x() > midX && robotPosition.y() < midY) {
                        return Quadrant.TOP_RIGHT;
                    } else if (robotPosition.x() < midX && robotPosition.y() > midY) {
                        return Quadrant.BOTTOM_LEFT;
                    } else if (robotPosition.x() > midX && robotPosition.y() > midY) {
                        return Quadrant.BOTTOM_RIGHT;
                    } else {
                        return NONE;
                    }
                }));

        return Arrays.stream(Quadrant.values())
                .filter(quadrant -> quadrant != NONE)
                .mapToInt(quadrant -> positionsPerQuadrant.get(quadrant).size())
                .reduce(1, (a, b) -> a*b);
    }

    enum Quadrant {
        TOP_LEFT, TOP_RIGHT, BOTTOM_LEFT, BOTTOM_RIGHT, NONE
    }
}
