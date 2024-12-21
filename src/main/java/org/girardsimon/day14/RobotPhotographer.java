package org.girardsimon.day14;

import org.girardsimon.common.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import static org.girardsimon.day14.ChristmasTreeUtils.ROBOT_REPRESENTATION;

public class RobotPhotographer {

    List<String> photographRobots(Set<Position> robotPositions, int bathroomWidth, int bathroomHeight) {
        return IntStream.range(0, bathroomHeight)
                .boxed()
                .map(j -> {
                    StringBuilder stringBuilder = new StringBuilder();
                    IntStream.range(0, bathroomWidth)
                            .forEach(i -> {
                                if(robotPositions.contains(new Position(i, j))) {
                                    stringBuilder.append(ROBOT_REPRESENTATION);
                                } else {
                                    stringBuilder.append(" ");
                                }
                            });
                   return stringBuilder.toString();
                })
                .toList();
    }
}
