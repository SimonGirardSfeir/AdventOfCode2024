package org.girardsimon.day14;

import org.girardsimon.LineExtractor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Day14ResolverTest {

    private static Bathroom bathroom;

    @BeforeAll
    static void setUp() throws IOException {
        List<String> lines = LineExtractor.getLines("src/test/resources/day14/inputData.txt");
        bathroom = BathroomParser.parseBathroom(lines);
    }

    @Test
    void resolve_part1_of_day14_problem() {
        // Arrange
        SafetyFactorCalculator safetyFactorCalculator = new SafetyFactorCalculator();
        // Act
        long safetyFactor = safetyFactorCalculator.computeBathroomSafetyFactor(bathroom, 100);

        // Assert
        assertThat(safetyFactor).isEqualTo(230686500L);
    }

    @Test
    void resolve_part2_of_day14_problem() {
        // Arrange
        ChristmasTreeFinder christmasTreeFinder = new ChristmasTreeFinder(new ChristmasTreeChecker(),
                new RobotPhotographer());
        // Act
        int fewestNumberOfSecondsToSeeChristmasTree = christmasTreeFinder
                .fewestNumberOfSecondsToSeeChristmasTree(bathroom);

        // Assert
        assertThat(fewestNumberOfSecondsToSeeChristmasTree).isEqualTo(7672);
    }
}
