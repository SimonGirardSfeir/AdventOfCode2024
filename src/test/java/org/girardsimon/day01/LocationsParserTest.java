package org.girardsimon.day01;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LocationsParserTest {

    @Test
    void test_ParseHistorianLocations() {
        // Arrange
        List<String> lines = List.of(
                "3 4",
                "4 3",
                "2 5",
                "1 3",
                "3 9",
                "3 3"
        );

        // Act
        HistorianLocations historianLocations = LocationsParser.parseHistorianLocations(lines);

        // Assert
        assertThat(historianLocations)
                .extracting(HistorianLocations::locationsLeft, HistorianLocations::locationsRight)
                .containsExactly(List.of(3, 4, 2, 1, 3, 3),
                        List.of(4, 3, 5, 3, 9, 3));
    }

}