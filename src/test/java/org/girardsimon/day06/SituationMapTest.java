package org.girardsimon.day06;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SituationMapTest {
    @Test
    void test_countNumberOfGuardVisitedPosition() {
        // Arrange
        SituationMap situationMap = SituationMapParser.parseSituationMap(
                List.of(
                        "....#.....",
                        ".........#",
                        "..........",
                        "..#.......",
                        ".......#..",
                        "..........",
                        ".#..^.....",
                        "........#.",
                        "#.........",
                        "......#..."
                )
        );

        // Act
        int numberOfGuardVisitedPosition = situationMap.countNumberOfGuardVisitedPosition();

        // Assert
        assertThat(numberOfGuardVisitedPosition)
                .isEqualTo(41);
    }

    @Test
    void test_countNumberOfObstaclesThatWillBlockGuard() {
        // Arrange
        SituationMap situationMap = SituationMapParser.parseSituationMap(
                List.of(
                        "....#.....",
                        ".........#",
                        "..........",
                        "..#.......",
                        ".......#..",
                        "..........",
                        ".#..^.....",
                        "........#.",
                        "#.........",
                        "......#..."
                )
        );

        // Act
        int numberOfObstaclesThatWillBlockGuard = situationMap.countNumberOfObstaclesThatWillBlockGuard();

        // Assert
        assertThat(numberOfObstaclesThatWillBlockGuard)
                .isEqualTo(6);
    }

}