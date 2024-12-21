package org.girardsimon.day13;

import org.girardsimon.common.Position;
import org.girardsimon.common.Vector;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ClawMachineTest {

    public static Stream<Arguments> clawMachineAndExpectedCheapestWinningCombination() {
        return Stream.of(
                Arguments.of(new ClawMachine(
                        new Vector(94,34),
                        new Vector(22,67),
                        new Position(8400, 5400)
                ), 280L),
                Arguments.of(new ClawMachine(
                        new Vector(26,66),
                        new Vector(67,21),
                        new Position(12748, 12176)
                ), 0L),
                Arguments.of(new ClawMachine(
                        new Vector(17,86),
                        new Vector(84,37),
                        new Position(7870, 6450)
                ), 200L),
                Arguments.of(new ClawMachine(
                        new Vector(69,23),
                        new Vector(27,71),
                        new Position(18641, 10279)
                ), 0L)
        );
    }

    @MethodSource("clawMachineAndExpectedCheapestWinningCombination")
    @ParameterizedTest
    void test_cheapestWinningCombination(ClawMachine clawMachine, long expectedCheapestWinningCombination) {
        // Act
        long cheapestWinningCombination = clawMachine.cheapestWinWithDelta(0L);

        // Assert
        assertThat(cheapestWinningCombination).isEqualTo(expectedCheapestWinningCombination);
    }
  
}