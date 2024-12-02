package org.girardsimon.day02;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PlantReportParserTest {

    @Test
    void test_parsePlantReportManager() {
        // Arrange
        List<String> lines = List.of(
                "7 6 4 2 1",
                "1 2 7 8 9",
                "9 7 6 2 1",
                "1 3 2 4 5",
                "8 6 4 4 1",
                "1 3 6 7 9"
        );

        // Act
        PlantReportManager plantReportManager = PlantReportParser.parsePlantReportManager(lines);

        // Assert
        assertThat(plantReportManager)
                .extracting(PlantReportManager::reports)
                .isEqualTo(List.of(new Report(List.of(7, 6, 4, 2, 1)),
                        new Report(List.of(1, 2, 7, 8, 9)),
                        new Report(List.of(9, 7, 6, 2, 1)),
                        new Report(List.of(1, 3, 2, 4, 5)),
                        new Report(List.of(8, 6, 4, 4, 1)),
                        new Report(List.of(1, 3, 6, 7, 9))));
    }

}