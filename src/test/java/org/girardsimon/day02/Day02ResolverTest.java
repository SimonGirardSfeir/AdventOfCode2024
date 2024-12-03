package org.girardsimon.day02;

import org.girardsimon.LineExtractor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Day02ResolverTest {

    private static PlantReportManager plantReportManager;

    @BeforeAll
    static void setUp() throws IOException {
        List<String> lines = LineExtractor.getLines("src/test/resources/day02/inputData.txt");
        plantReportManager = PlantReportParser.parsePlantReportManager(lines);
    }

    @Test
    void resolve_part1_of_day02_problem() {
        // Act
        long numberOfSafeReports = plantReportManager.countNumberOfSafeReports();

        // Assert
        assertThat(numberOfSafeReports).isEqualTo(421L);
    }

    @Test
    void resolve_part2_of_day02_problem() {
        // Act
        long numberOfSafeReports = plantReportManager.countNumberOfSafeReportsWithTolerance();

        // Assert
        assertThat(numberOfSafeReports).isEqualTo(476L);
    }
}
