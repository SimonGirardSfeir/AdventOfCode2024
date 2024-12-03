package org.girardsimon.day03;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ProgramParserTest {

    @Test
    void test_parseProgramSimple() {
        // Arrange
        List<String> lines = List.of("xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))");

        // Act
        Program program = ProgramParser.parseProgramSimple(lines);

        // Assert
        assertThat(program)
                .extracting(Program::tuples)
                .isEqualTo(
                        List.of(
                            new Tuple(2L,4L),
                            new Tuple(5L,5L),
                            new Tuple(11L,8L),
                            new Tuple(8L,5L)
                        )
                );
    }


    @Test
    void test_parseProgram() {
        // Arrange
        List<String> lines = List.of("xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))");

        // Act
        Program program = ProgramParser.parseProgram(lines);

        // Assert
        assertThat(program)
                .extracting(Program::tuples)
                .isEqualTo(
                        List.of(
                                new Tuple(2L,4L),
                                new Tuple(8L,5L)
                        )
                );
    }

}