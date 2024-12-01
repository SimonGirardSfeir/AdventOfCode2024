package org.girardsimon.day01;

import org.girardsimon.LineExtractor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Day01ResolverTest {

    private static List<String> lines;

    @BeforeAll
    static void setUp() throws IOException {
        lines = LineExtractor.getLines("src/test/resources/day01/inputData.txt");
    }

    @Test
    void resolve_part1_of_day01_problem() {
        // Arrange
        HistorianLocations historianLocations = LocationsParser.parseHistorianLocations(lines);

        // Act
        int distance = historianLocations.computeDistance();

        // Assert
        assertThat(distance).isEqualTo(1320851);
    }

    @Test
    void resolve_part2_of_day01_problem() {
        // Arrange
        HistorianLocations historianLocations = LocationsParser.parseHistorianLocations(lines);

        // Act
        long similarityScore = historianLocations.computeSimilarityScore();

        // Assert
        assertThat(similarityScore).isEqualTo(26859182L);
    }
}
