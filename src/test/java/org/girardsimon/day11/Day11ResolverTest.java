package org.girardsimon.day11;

import org.girardsimon.LineExtractor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Day11ResolverTest {

    private static StoneCorridor stoneCorridor;

    @BeforeAll
    static void setUp() throws IOException {
        List<String> lines = LineExtractor.getLines("src/test/resources/day11/inputData.txt");
        stoneCorridor = StoneCorridorParser.parseStoneCorridor(lines.getFirst());
    }

    @Test
    void resolve_part1_of_day11_problem() {
        // Arrange
        StoneBlinker stoneBlinker = new StoneBlinker();

        // Act
        long numberOfStonesAfterBlink  = stoneBlinker.numberOfStonesAfterBlink(stoneCorridor,25);

        // Assert
        assertThat(numberOfStonesAfterBlink).isEqualTo(193269L);
    }

    @Test
    void resolve_part2_of_day11_problem() {
        // Arrange
        StoneBlinker stoneBlinker = new StoneBlinker();

        // Act
        long numberOfStonesAfterBlink  = stoneBlinker.numberOfStonesAfterBlink(stoneCorridor,75);

        // Assert
        assertThat(numberOfStonesAfterBlink).isEqualTo(228449040027793L);
    }
}
