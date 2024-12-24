package org.girardsimon.day15;

import org.girardsimon.common.CoordinateSystem;
import org.girardsimon.common.Direction4;
import org.girardsimon.common.Position;

import java.util.Queue;

public class RobotMover {

    private final Warehouse warehouse;

    public RobotMover(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    void moveRobot(RobotInstructions robotInstructions) {
        Position currentRobotPosition = robotInstructions.robotInitialPosition();
        Queue<Direction4> moves = robotInstructions.moves();

        while(!moves.isEmpty()) {
            Direction4 move = moves.poll();

            Position nextRobotPosition = currentRobotPosition.fromDelta
                    (move.dx(CoordinateSystem.INVERTED_Y), move.dy(CoordinateSystem.INVERTED_Y));

            if(warehouse.hasRobotClearPath(nextRobotPosition) || isFacingBoxMovable(nextRobotPosition, move)) {
                currentRobotPosition = nextRobotPosition;
            }

        }
    }

    private boolean isFacingBoxMovable(Position nextRobotPosition, Direction4 move) {
        return warehouse.isBoxAt(nextRobotPosition) && warehouse.tryMoveBox(nextRobotPosition, move);
    }
}
