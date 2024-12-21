package org.girardsimon.day14;

import org.girardsimon.common.Position;
import org.girardsimon.common.Vector;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class BathroomParser {

    private static final Pattern ROBOT_PATTERN = Pattern.compile("p=(-?\\d+),(-?\\d+) v=(-?\\d+),(-?\\d+)");

    private BathroomParser() {
    }

    public static Bathroom parseBathroom(List<String> lines) {
        List<Robot> robots = new ArrayList<>();
        int[] dimensions = new int[] {-1,-1};

        lines.forEach(line -> {
            Robot robot = parseRobot(line);
            robots.add(robot);
                    dimensions[0] = Math.max(dimensions[0], robot.initialPosition().x());
                    dimensions[1] = Math.max(dimensions[1], robot.initialPosition().y());
            }
        );

        return new Bathroom(robots, dimensions[0]+1, dimensions[1]+1);
    }

    private static Robot parseRobot(String line) {
        Matcher robotMatcher = ROBOT_PATTERN.matcher(line);

        if(robotMatcher.matches()) {
            Position initialPosition = new Position(
                    Integer.parseInt(robotMatcher.group(1)),
                    Integer.parseInt(robotMatcher.group(2)));
            Vector velocityPerSecond = new Vector(
                    Integer.parseInt(robotMatcher.group(3)),
                    Integer.parseInt(robotMatcher.group(4))
            );
            return new Robot(initialPosition, velocityPerSecond);
        } else {
            throw new IllegalArgumentException("Invalid input line: " + line);
        }
    }
}
