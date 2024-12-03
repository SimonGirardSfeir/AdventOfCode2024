package org.girardsimon.day01;

import org.girardsimon.LineExtractor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Day01ResolverTest {

    private static HistorianLocations historianLocations;

    @BeforeAll
    static void setUp() throws IOException {
        List<String> lines = LineExtractor.getLines("src/test/resources/day01/inputData.txt");
        historianLocations = LocationsParser.parseHistorianLocations(lines);
    }

    @Test
    void resolve_part1_of_day01_problem() {
        // Act
        int distance = historianLocations.computeDistance();

        // Assert
        assertThat(distance).isEqualTo(1320851);
    }

    @Test
    void resolve_part2_of_day01_problem() {
         // Act
        long similarityScore = historianLocations.computeSimilarityScore();

        // Assert
        assertThat(similarityScore).isEqualTo(26859182L);
    }
}
