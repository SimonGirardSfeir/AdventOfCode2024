package org.girardsimon.day03;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ProgramTest {

    @Test
    void test_sumMultiplications() {
        // Arrange
        Program program = new Program(
                List.of(
                        new Tuple(2,4),
                        new Tuple(5,5),
                        new Tuple(11,8),
                        new Tuple(8,5)
                )
        );

        // Act
        long sumMultiplications = program.sumMultiplications();

        assertThat(sumMultiplications)
                .isEqualTo(161L);
    }

}