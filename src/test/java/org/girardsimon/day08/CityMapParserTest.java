package org.girardsimon.day08;

import org.girardsimon.common.Position;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CityMapParserTest {

    @Test
    void test_parseCity() {
        // Arrange
        List<String> lines = List.of(
                "............",
                "........0...",
                ".....0......",
                ".......0....",
                "....0.......",
                "......A.....",
                "............",
                "............",
                "........A...",
                ".........A..",
                "............",
                "............"
        );

        // Act
        CityMap cityMap = CityParser.parseCity(lines);

        // Assert
        assertThat(cityMap)
                .extracting(CityMap::maxHeight, CityMap::maxWidth)
                .containsExactly(12,12);
        assertThat(cityMap.antennas())
                .containsExactlyInAnyOrder(
                    new Antenna('0', new Position(8, 10)),
                    new Antenna('0', new Position(5, 9)),
                    new Antenna('0', new Position(7, 8)),
                    new Antenna('0', new Position(4, 7)),
                    new Antenna('A', new Position(6, 6)),
                    new Antenna('A', new Position(8, 3)),
                    new Antenna('A', new Position(9, 2))
                );
    }

}