package org.girardsimon.day12;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GardenFencingPriceCalculatorTest {

    @Test
    void test_computeFencingPrice_perimeterFormula() {
        // Arrange
        Garden garden = GardenParser.parseGarden(List.of(
                "RRRRIICCFF",
                "RRRRIICCCF",
                "VVRRRCCFFF",
                "VVRCCCJFFF",
                "VVVVCJJCFE",
                "VVIVCCJJEE",
                "VVIIICJJEE",
                "MIIIIIJJEE",
                "MIIISIJEEE",
                "MMMISSJEEE"
        ));
        GardenFencingPriceCalculator gardenFencingPriceCalculator = new GardenFencingPriceCalculator(new FencingPriceCalculatorPerimeterFormula());

        // Act
        long fencingPrice = gardenFencingPriceCalculator.computeFencingPrice(garden);

        // Assert
        assertThat(fencingPrice).isEqualTo(1930);
    }

    @Test
    void test_computeFencingPrice_numberOfSidesFormula() {
        // Arrange
        Garden garden = GardenParser.parseGarden(List.of(
                "RRRRIICCFF",
                "RRRRIICCCF",
                "VVRRRCCFFF",
                "VVRCCCJFFF",
                "VVVVCJJCFE",
                "VVIVCCJJEE",
                "VVIIICJJEE",
                "MIIIIIJJEE",
                "MIIISIJEEE",
                "MMMISSJEEE"
        ));
        GardenFencingPriceCalculator gardenFencingPriceCalculator = new GardenFencingPriceCalculator(new FencingPriceCalculatorNumberOfSidesFormula());

        // Act
        long fencingPrice = gardenFencingPriceCalculator.computeFencingPrice(garden);

        // Assert
        assertThat(fencingPrice).isEqualTo(1206);
    }

    @Test
    void test_computeFencingPrice_numberOfSidesFormula_nested() {
        // Arrange
        Garden garden = GardenParser.parseGarden(List.of(
                "AAAAAA",
                "AAABBA",
                "AAABBA",
                "ABBAAA",
                "ABBAAA",
                "AAAAAA"
        ));
        GardenFencingPriceCalculator gardenFencingPriceCalculator = new GardenFencingPriceCalculator(new FencingPriceCalculatorNumberOfSidesFormula());

        // Act
        long fencingPrice = gardenFencingPriceCalculator.computeFencingPrice(garden);

        // Assert
        assertThat(fencingPrice).isEqualTo(368);
    }

}