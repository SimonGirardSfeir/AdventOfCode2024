package org.girardsimon.day04;

import org.girardsimon.LineExtractor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Day04ResolverTest {

    private static MonitoringStation monitoringStation;

    @BeforeAll
    static void setUp() throws IOException {
        List<String> lines = LineExtractor.getLines("src/test/resources/day04/inputData.txt");
        monitoringStation = MonitoringStationParser.parseMonitoringStation(lines);
    }

    @Test
    void resolve_part1_of_day04_problem() {
        // Act
        long xmasOccurrences  = monitoringStation.countXmasOccurrences();

        // Assert
        assertThat(xmasOccurrences).isEqualTo(2532L);
    }

    @Test
    void resolve_part2_of_day04_problem() {
        // Act
        long xshapeMasOccurrences  = monitoringStation.countXshapeMasOccurrences();

        // Assert
        assertThat(xshapeMasOccurrences).isEqualTo(1941L);
    }
}
