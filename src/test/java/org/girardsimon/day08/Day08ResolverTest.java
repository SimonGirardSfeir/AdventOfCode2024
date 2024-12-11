package org.girardsimon.day08;

import org.girardsimon.LineExtractor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Day08ResolverTest {

    private static CityMap cityMap;

    @BeforeAll
    static void setUp() throws IOException {
        List<String> lines = LineExtractor.getLines("src/test/resources/day08/inputData.txt");
        cityMap = CityParser.parseCity(lines);
    }

    @Test
    void resolve_part1_of_day08_problem() {
        // Arrange
        SignalImpactCalculator signalImpactCalculator = new SignalImpactCalculator(new BasicAntiNodePositionAdder());

        // Act
        int signalImpact  = signalImpactCalculator.computeSignalImpact(cityMap);

        // Assert
        assertThat(signalImpact).isEqualTo(329);
    }

    @Test
    void resolve_part2_of_day08_problem() {
        // Arrange
        SignalImpactCalculator signalImpactCalculator = new SignalImpactCalculator(new FullAntiNodePositionAdder());

        // Act
        int signalImpact  = signalImpactCalculator.computeSignalImpact(cityMap);

        // Assert
        assertThat(signalImpact).isEqualTo(1190);
    }
}
