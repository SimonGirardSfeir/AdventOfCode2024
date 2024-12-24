package org.girardsimon.day15;

import org.girardsimon.common.Direction4;
import org.girardsimon.common.Position;

import java.util.Queue;

public record RobotInstructions(Position robotInitialPosition, Queue<Direction4> moves) {
}
