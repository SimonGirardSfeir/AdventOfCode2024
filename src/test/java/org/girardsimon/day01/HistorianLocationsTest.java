package org.girardsimon.day01;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class HistorianLocationsTest {

    @Test
    void test_computeDistance() {
        // Arrange
        HistorianLocations historianLocations = new HistorianLocations(List.of(3, 4, 2, 1, 3, 3),
                List.of(4, 3, 5, 3, 9, 3));

        // Act
        int distance = historianLocations.computeDistance();

        // Assert
        assertThat(distance)
                .isEqualTo(11);

    }

    @Test
    void test_computeSimilarityScore() {
        // Arrange
        HistorianLocations historianLocations = new HistorianLocations(List.of(3, 4, 2, 1, 3, 3),
                List.of(4, 3, 5, 3, 9, 3));

        // Act
        long similarityScore = historianLocations.computeSimilarityScore();

        // Assert
        assertThat(similarityScore)
                .isEqualTo(31L);

    }

}