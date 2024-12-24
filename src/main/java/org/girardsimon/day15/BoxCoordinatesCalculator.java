package org.girardsimon.day15;

public class BoxCoordinatesCalculator {

    private final RobotMover robotMover;

    public BoxCoordinatesCalculator(RobotMover robotMover) {
        this.robotMover = robotMover;
    }

    long sumBoxCoordinatesAfterRobotPassage(Warehouse warehouse, RobotInstructions robotInstructions) {
        robotMover.moveRobot(robotInstructions);

        return warehouse.boxes().stream()
                .map(Box::position)
                .mapToLong(position -> position.x() + position.y()* 100L)
                .sum();
    }
}
