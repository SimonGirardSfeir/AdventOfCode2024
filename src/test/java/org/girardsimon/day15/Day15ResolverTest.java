package org.girardsimon.day15;

import org.girardsimon.LineExtractor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Day15ResolverTest {

    private static List<String> lines;

    @BeforeAll
    static void setUp() throws IOException {
        lines = LineExtractor.getLines("src/test/resources/day15/inputData.txt");
    }

    @Test
    void resolve_part1_of_day15_problem() {
        // Arrange
        ParsingTuple parsingTuple = WarehouseParser.parseRobotAndWarehouseSimple(lines);
        Warehouse warehouse = parsingTuple.warehouse();
        RobotInstructions robotInstructions = parsingTuple.robotInstructions();
        RobotMover robotMover = new RobotMover(warehouse);
        BoxCoordinatesCalculator boxCoordinatesCalculator = new BoxCoordinatesCalculator(robotMover);

        // Act
        long sumBoxCoordinatesAfterRobotPassage = boxCoordinatesCalculator
                .sumBoxCoordinatesAfterRobotPassage(warehouse, robotInstructions);

        // Assert
        assertThat(sumBoxCoordinatesAfterRobotPassage).isEqualTo(1517819L);
    }

    @Test
    void resolve_part2_of_day15_problem() {
        // Arrange
        ParsingTuple parsingTuple = WarehouseParser.parseRobotAndWarehouseWide(lines);
        Warehouse warehouse = parsingTuple.warehouse();
        RobotInstructions robotInstructions = parsingTuple.robotInstructions();
        RobotMover robotMover = new RobotMover(warehouse);
        BoxCoordinatesCalculator boxCoordinatesCalculator = new BoxCoordinatesCalculator(robotMover);

        // Act
        long sumBoxCoordinatesAfterRobotPassage = boxCoordinatesCalculator
                .sumBoxCoordinatesAfterRobotPassage(warehouse, robotInstructions);

        // Assert
        assertThat(sumBoxCoordinatesAfterRobotPassage).isEqualTo(1538862L);
    }
}
