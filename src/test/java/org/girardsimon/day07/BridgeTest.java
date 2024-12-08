package org.girardsimon.day07;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeTest {

    @Test
    void test_computeTotalCalibration() {
        // Arrange
        List<Equation> equations = List.of(
                new Equation(190L, List.of(10L, 19L)),
                new Equation(3267L, List.of(81L, 40L, 27L)),
                new Equation(83L, List.of(17L, 5L)),
                new Equation(156L, List.of(15L, 6L)),
                new Equation(7290L, List.of(6L, 8L, 6L, 15L)),
                new Equation(161011L, List.of(16L, 10L, 13L)),
                new Equation(192L, List.of(17L, 8L, 14L)),
                new Equation(21037L, List.of(9L, 7L, 18L, 13L)),
                new Equation(292L, List.of(11L, 6L, 16L, 20L))
        );
        Bridge bridge = new Bridge(equations);

        // Act
        long computedTotalCalibration = bridge.computeTotalCalibration(List.of(ArithmeticOperation.ADD, ArithmeticOperation.MULTIPLY));

        // Assert
        assertThat(computedTotalCalibration)
                .isEqualTo(3749L);
    }

    @Test
    void test_computeTotalCalibration_all_operations() {
        // Arrange
        List<Equation> equations = List.of(
                new Equation(190L, List.of(10L, 19L)),
                new Equation(3267L, List.of(81L, 40L, 27L)),
                new Equation(83L, List.of(17L, 5L)),
                new Equation(156L, List.of(15L, 6L)),
                new Equation(7290L, List.of(6L, 8L, 6L, 15L)),
                new Equation(161011L, List.of(16L, 10L, 13L)),
                new Equation(192L, List.of(17L, 8L, 14L)),
                new Equation(21037L, List.of(9L, 7L, 18L, 13L)),
                new Equation(292L, List.of(11L, 6L, 16L, 20L))
        );
        Bridge bridge = new Bridge(equations);

        // Act
        long computedTotalCalibration = bridge.computeTotalCalibration(List.of(ArithmeticOperation.values()));

        // Assert
        assertThat(computedTotalCalibration)
                .isEqualTo(11387L);
    }

}