package org.girardsimon.day03;

import org.girardsimon.LineExtractor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Day03ResolverTest {

    private static List<String> lines;

    @BeforeAll
    static void setUp() throws IOException {
        lines = LineExtractor.getLines("src/test/resources/day03/inputData.txt");
    }

    @Test
    void resolve_part1_of_day03_problem() {
        // Arrange
        Program program = ProgramParser.parseProgramSimple(lines);
        // Act
        long sumMultiplications = program.sumMultiplications();

        // Assert
        assertThat(sumMultiplications).isEqualTo(188741603L);
    }

    @Test
    void resolve_part2_of_day03_problem() {
        // Arrange
        Program program = ProgramParser.parseProgram(lines);
        // Act
        long sumMultiplications = program.sumMultiplications();

        // Assert
        assertThat(sumMultiplications).isEqualTo(67269798L);
    }
}
