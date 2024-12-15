package org.girardsimon.day10;

import org.girardsimon.common.Position;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TopographicMapParserTest {

    @Test
    void test_parseTopographicMap() {
        // Arrange
        List<String> lines = List.of(
                "01",
                "23"
        );

        // Act
        TopographicMap topographicMap = TopographicMapParser.parseTopographicMap(lines);

        // Assert
        assertThat(topographicMap.positions())
                .containsExactlyInAnyOrder(
                        new TopographicMapPosition(0, new Position(0, 1)),
                        new TopographicMapPosition(1, new Position(1, 1)),
                        new TopographicMapPosition(2, new Position(0, 0)),
                        new TopographicMapPosition(3, new Position(1, 0))

                );
    }

}