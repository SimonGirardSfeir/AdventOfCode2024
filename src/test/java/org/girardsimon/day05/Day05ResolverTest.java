package org.girardsimon.day05;

import org.girardsimon.LineExtractor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Day05ResolverTest {

    private static SafetyManualUpdater safetyManualUpdater;

    @BeforeAll
    static void setUp() throws IOException {
        List<String> lines = LineExtractor.getLines("src/test/resources/day05/inputData.txt");
        safetyManualUpdater = SafetyManualParser.parseSafetyManualUpdater(lines);
    }

    @Test
    void resolve_part1_of_day05_problem() {
        // Act
        long sumMiddlePageNumbersOfCorrectUpdates  = safetyManualUpdater.sumMiddlePageNumbersOfCorrectUpdates();

        // Assert
        assertThat(sumMiddlePageNumbersOfCorrectUpdates).isEqualTo(5509L);
    }

    @Test
    void resolve_part2_of_day05_problem() {
        // Act
        long sumMiddlePageNumbersOfIncorrectUpdates  = safetyManualUpdater.sumMiddlePageNumbersOfIncorrectUpdates();

        // Assert
        assertThat(sumMiddlePageNumbersOfIncorrectUpdates).isEqualTo(4407L);
    }
}
