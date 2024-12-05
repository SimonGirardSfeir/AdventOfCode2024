package org.girardsimon.day04;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MonitoringStationTest {

    @Test
    void test_countXmasOccurrences() {
        // Arrange
        MonitoringStation monitoringStation = MonitoringStationParser.parseMonitoringStation(List.of(
                "MMMSXXMASM",
                "MSAMXMSMSA",
                "AMXSXMAAMM",
                "MSAMASMSMX",
                "XMASAMXAMM",
                "XXAMMXXAMA",
                "SMSMSASXSS",
                "SAXAMASAAA",
                "MAMMMXMMMM",
                "MXMXAXMASX"
        ));

        // Act
        long xmasOccurrences = monitoringStation.countXmasOccurrences();

        // Assert
        assertThat(xmasOccurrences).isEqualTo(18L);
    }

    @Test
    void test_countXshapeMasOccurrences() {
        // Arrange
        MonitoringStation monitoringStation = MonitoringStationParser.parseMonitoringStation(List.of(
                "MMMSXXMASM",
                "MSAMXMSMSA",
                "AMXSXMAAMM",
                "MSAMASMSMX",
                "XMASAMXAMM",
                "XXAMMXXAMA",
                "SMSMSASXSS",
                "SAXAMASAAA",
                "MAMMMXMMMM",
                "MXMXAXMASX"
        ));

        // Act
        long xmasOccurrences = monitoringStation.countXshapeMasOccurrences();

        // Assert
        assertThat(xmasOccurrences).isEqualTo(9L);
    }

}