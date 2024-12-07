package org.girardsimon.day06;

import org.girardsimon.LineExtractor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Day06ResolverTest {

    private static SituationMap situationMap;

    @BeforeAll
    static void setUp() throws IOException {
        List<String> lines = LineExtractor.getLines("src/test/resources/day06/inputData.txt");
        situationMap = SituationMapParser.parseSituationMap(lines);
    }

    @Test
    void resolve_part1_of_day06_problem() {
        // Act
        int numberOfGuardVisitedPosition  = situationMap.countNumberOfGuardVisitedPosition();

        // Assert
        assertThat(numberOfGuardVisitedPosition).isEqualTo(4696);
    }

    @Test
    void resolve_part2_of_day06_problem() {
        // Act
        int numberOfObstaclesThatWillBlockGuard  = situationMap.countNumberOfObstaclesThatWillBlockGuard();

        // Assert
        assertThat(numberOfObstaclesThatWillBlockGuard).isEqualTo(1443);
    }
}
