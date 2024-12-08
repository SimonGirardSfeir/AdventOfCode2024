package org.girardsimon.day07;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeParserTest {

    @Test
    void test_parseBridge() {
        // Arrange
        List<String> lines = List.of(
                "190: 10 19",
                "3267: 81 40 27",
                "83: 17 5",
                "156: 15 6",
                "7290: 6 8 6 15",
                "161011: 16 10 13",
                "192: 17 8 14",
                "21037: 9 7 18 13",
                "292: 11 6 16 20"
        );

        // Act
        Bridge bridge = BridgeParser.parseBridge(lines);

        // Assert
        assertThat(bridge.equations())
                .containsExactly(
                    new Equation(190L, List.of(10L,19L)),
                        new Equation(3267L, List.of(81L,40L,27L)),
                        new Equation(83L, List.of(17L,5L)),
                        new Equation(156L, List.of(15L,6L)),
                        new Equation(7290L, List.of(6L,8L,6L,15L)),
                        new Equation(161011L, List.of(16L,10L,13L)),
                        new Equation(192L, List.of(17L,8L,14L)),
                        new Equation(21037L, List.of(9L,7L,18L,13L)),
                        new Equation(292L, List.of(11L,6L,16L,20L))
                );
    }
  
}