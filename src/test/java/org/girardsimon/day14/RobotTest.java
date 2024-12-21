package org.girardsimon.day14;

import org.girardsimon.common.Position;
import org.girardsimon.common.Vector;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RobotTest {

    @Test
    void test_robotPositionAfterSeconds() {
        // Arrange
        Robot robot = new Robot(new Position(2,4), new Vector(2,-3));

        // Act
        Position robotPositionAfter5Seconds = robot.robotPositionAfterSeconds(5,
                11,
                7);

        // Assert
        assertThat(robotPositionAfter5Seconds)
                .isEqualTo(new Position(1, 3));
    }

}