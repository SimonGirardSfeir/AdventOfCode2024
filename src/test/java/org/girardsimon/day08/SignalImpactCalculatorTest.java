package org.girardsimon.day08;

import org.girardsimon.common.Position;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SignalImpactCalculatorTest {

    @Test
    void test_computeSignalImpact_simple() {
        // Arrange
        List<Antenna> antennas = List.of(
                new Antenna('0', new Position(8, 10)),
                new Antenna('0', new Position(5, 9)),
                new Antenna('0', new Position(7, 8)),
                new Antenna('0', new Position(4, 7)),
                new Antenna('A', new Position(6, 6)),
                new Antenna('A', new Position(8, 3)),
                new Antenna('A', new Position(9, 2))
        );
        CityMap cityMap = new CityMap(antennas, 12, 12);
        SignalImpactCalculator signalImpactCalculator = new SignalImpactCalculator(new BasicAntiNodePositionAdder());

        // Act
        int signalImpact = signalImpactCalculator.computeSignalImpact(cityMap);

        // Assert
        assertThat(signalImpact).isEqualTo(14);
    }

    @Test
    void test_computeSignalImpact() {
        // Arrange
        List<Antenna> antennas = List.of(
                new Antenna('0', new Position(8, 10)),
                new Antenna('0', new Position(5, 9)),
                new Antenna('0', new Position(7, 8)),
                new Antenna('0', new Position(4, 7)),
                new Antenna('A', new Position(6, 6)),
                new Antenna('A', new Position(8, 3)),
                new Antenna('A', new Position(9, 2))
        );
        CityMap cityMap = new CityMap(antennas, 12, 12);
        SignalImpactCalculator signalImpactCalculator = new SignalImpactCalculator(new FullAntiNodePositionAdder());

        // Act
        int signalImpact = signalImpactCalculator.computeSignalImpact(cityMap);

        // Assert
        assertThat(signalImpact).isEqualTo(34);
    }

}