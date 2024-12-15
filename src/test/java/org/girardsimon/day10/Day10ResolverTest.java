package org.girardsimon.day10;

import org.girardsimon.LineExtractor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Day10ResolverTest {

    private static TopographicMap topographicMap;

    @BeforeAll
    static void setUp() throws IOException {
        List<String> lines = LineExtractor.getLines("src/test/resources/day10/inputData.txt");
        topographicMap = TopographicMapParser.parseTopographicMap(lines);
    }

    @Test
    void resolve_part1_of_day10_problem() {
        // Arrange
        TrailHeadScoresCalculator trailHeadScoresCalculator = new TrailHeadScoresCalculator(new TrailTracker());

        // Act
        long sumTrailHeadScores  = trailHeadScoresCalculator.sumTrailHeadScores(topographicMap);

        // Assert
        assertThat(sumTrailHeadScores).isEqualTo(737L);
    }

    @Test
    void resolve_part2_of_day10_problem() {
        // Arrange
        TrailHeadRatingCalculator trailHeadRatingCalculator = new TrailHeadRatingCalculator(new TrailTracker());

        // Act
        long sumTrailHeadScores  = trailHeadRatingCalculator.sumTrailHeadRating(topographicMap);

        // Assert
        assertThat(sumTrailHeadScores).isEqualTo(1619L);
    }
}
