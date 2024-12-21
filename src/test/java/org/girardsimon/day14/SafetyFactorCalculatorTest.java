package org.girardsimon.day14;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SafetyFactorCalculatorTest {

    @Test
    void test_safetyFactor() {
        // Arrange
        List<String> lines = List.of(
                "p=0,4 v=3,-3",
                "p=6,3 v=-1,-3",
                "p=10,3 v=-1,2",
                "p=2,0 v=2,-1",
                "p=0,0 v=1,3",
                "p=3,0 v=-2,-2",
                "p=7,6 v=-1,-3",
                "p=3,0 v=-1,-2",
                "p=9,3 v=2,3",
                "p=7,3 v=-1,2",
                "p=2,4 v=2,-3",
                "p=9,5 v=-3,-3"
        );
        Bathroom bathroom = BathroomParser.parseBathroom(lines);
        SafetyFactorCalculator safetyFactorCalculator = new SafetyFactorCalculator();

        // Act
        int safetyFactor = safetyFactorCalculator.computeBathroomSafetyFactor(bathroom, 100);

        // Assert
        assertThat(safetyFactor).isEqualTo(12);
    }

}