package org.girardsimon.day10;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TrailHeadScoresCalculatorTest {

    TrailHeadScoresCalculator trailHeadScoresCalculator = new TrailHeadScoresCalculator(new TrailTracker());

    @Test
    void test_sumTrailHeadScores() {
        // Arrange
        List<String> lines = List.of(
                "89010123",
                "78121874",
                "87430965",
                "96549874",
                "45678903",
                "32019012",
                "01329801",
                "10456732"
        );
        TopographicMap topographicMap = TopographicMapParser.parseTopographicMap(lines);

        // Act
        long sumTrailHeadScores = trailHeadScoresCalculator.sumTrailHeadScores(topographicMap);

        assertThat(sumTrailHeadScores).isEqualTo(36L);

    }

}