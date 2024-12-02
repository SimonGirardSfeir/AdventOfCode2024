package org.girardsimon.day02;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class PlantReportManagerTest {

    @Test
    void test_countNumberOfSafeReports() {
        // Arrange
        PlantReportManager plantReportManager = new PlantReportManager(
                List.of(new Report(List.of(7, 6, 4, 2, 1)),
                        new Report(List.of(1, 2, 7, 8, 9)),
                        new Report(List.of(9, 7, 6, 2, 1)),
                        new Report(List.of(1, 3, 2, 4, 5)),
                        new Report(List.of(8, 6, 4, 4, 1)),
                        new Report(List.of(1, 3, 6, 7, 9))
        ));

        // Act
        long numberOfSafeReports = plantReportManager.countNumberOfSafeReports();

        // Assert
        assertThat(numberOfSafeReports).isEqualTo(2L);
    }

    @Test
    void test_countNumberOfSafeReportsWithTolerance() {
        // Arrange
        PlantReportManager plantReportManager = new PlantReportManager(
                List.of(new Report(List.of(7, 6, 4, 2, 1)),
                        new Report(List.of(1, 2, 7, 8, 9)),
                        new Report(List.of(9, 7, 6, 2, 1)),
                        new Report(List.of(1, 3, 2, 4, 5)),
                        new Report(List.of(8, 6, 4, 4, 1)),
                        new Report(List.of(1, 3, 6, 7, 9))
                ));

        // Act
        long numberOfSafeReports = plantReportManager.countNumberOfSafeReportsWithTolerance();

        // Assert
        assertThat(numberOfSafeReports).isEqualTo(4L);
    }

}