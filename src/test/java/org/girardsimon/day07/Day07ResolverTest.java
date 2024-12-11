package org.girardsimon.day07;

import org.girardsimon.LineExtractor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Day07ResolverTest {

    private static Bridge bridge;

    @BeforeAll
    static void setUp() throws IOException {
        List<String> lines = LineExtractor.getLines("src/test/resources/day07/inputData.txt");
        bridge = BridgeParser.parseBridge(lines);
    }

    @Test
    void resolve_part1_of_day07_problem() {
        // Act
        long totalCalibration  = bridge.computeTotalCalibration(List.of(ArithmeticOperation.ADD, ArithmeticOperation.MULTIPLY));

        // Assert
        assertThat(totalCalibration).isEqualTo(1545311493300L);
    }

    @Test
    void resolve_part2_of_day07_problem() {
        // Act
        long totalCalibration  = bridge.computeTotalCalibration(List.of(ArithmeticOperation.values()));

        // Assert
        assertThat(totalCalibration).isEqualTo(169122112716571L);
    }
}
