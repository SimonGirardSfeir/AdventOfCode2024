package org.girardsimon.day12;

import org.girardsimon.LineExtractor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Day12ResolverTest {

    private static Garden garden;

    @BeforeAll
    static void setUp() throws IOException {
        List<String> lines = LineExtractor.getLines("src/test/resources/day12/inputData.txt");
        garden = GardenParser.parseGarden(lines);
    }

    @Test
    void resolve_part1_of_day12_problem() {
        // Arrange
        GardenFencingPriceCalculator gardenFencingPriceCalculator = new GardenFencingPriceCalculator(new FencingPriceCalculatorPerimeterFormula());

        // Act
        long fencingPrice  = gardenFencingPriceCalculator.computeFencingPrice(garden);

        // Assert
        assertThat(fencingPrice).isEqualTo(1456082L);
    }

    @Test
    void resolve_part2_of_day12_problem() {
        // Arrange
        GardenFencingPriceCalculator gardenFencingPriceCalculator = new GardenFencingPriceCalculator(new FencingPriceCalculatorNumberOfSidesFormula());

        // Act
        long fencingPrice  = gardenFencingPriceCalculator.computeFencingPrice(garden);

        // Assert
        assertThat(fencingPrice).isEqualTo(872382L);
    }
}
