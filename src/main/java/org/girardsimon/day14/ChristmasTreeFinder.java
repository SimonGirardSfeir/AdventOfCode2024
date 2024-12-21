package org.girardsimon.day14;

import org.girardsimon.common.Position;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ChristmasTreeFinder {

    private final ChristmasTreeChecker christmasTreeChecker;
    private final RobotPhotographer robotPhotographer;

    public ChristmasTreeFinder(ChristmasTreeChecker christmasTreeChecker, RobotPhotographer robotPhotographer) {
        this.christmasTreeChecker = christmasTreeChecker;
        this.robotPhotographer = robotPhotographer;
    }

    int fewestNumberOfSecondsToSeeChristmasTree(Bathroom bathroom) {
        return IntStream.iterate(1, i -> i + 1)
                .dropWhile(i -> !areRobotsFormingChristmasTree(i, bathroom)) // Drop elements while the condition is true
                .findFirst()
                .orElse(-1);
    }

    private boolean areRobotsFormingChristmasTree(int seconds, Bathroom bathroom) {
        Set<Position> positions = bathroom.robots().stream()
                .map(robot -> robot.robotPositionAfterSeconds(seconds, bathroom.width(), bathroom.height()))
                .collect(Collectors.toSet());

        return christmasTreeChecker.isChristmasTreePresent(robotPhotographer.photographRobots(positions, bathroom.width(), bathroom.height()));
    }
}
