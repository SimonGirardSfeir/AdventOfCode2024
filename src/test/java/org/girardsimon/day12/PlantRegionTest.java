package org.girardsimon.day12;

import org.girardsimon.common.Position;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PlantRegionTest {

    public static Stream<Arguments> regionAndExpectedResults() {
        PlantRegion regionR = new PlantRegion(
                Set.of(
                        new Plant('R', new Position(0,8)),
                        new Plant('R', new Position(0,9)),
                        new Plant('R', new Position(1,8)),
                        new Plant('R', new Position(1,9)),
                        new Plant('R', new Position(2,6)),
                        new Plant('R', new Position(2,7)),
                        new Plant('R', new Position(2,8)),
                        new Plant('R', new Position(2,9)),
                        new Plant('R', new Position(3,7)),
                        new Plant('R', new Position(3,8)),
                        new Plant('R', new Position(3,9)),
                        new Plant('R', new Position(4,7))
                )
        );
        PlantRegion regionI = new PlantRegion(
                Set.of(
                        new Plant('I', new Position(4,8)),
                        new Plant('I', new Position(4,9)),
                        new Plant('I', new Position(5,8)),
                        new Plant('I', new Position(5,9))
                )
        );

        PlantRegion regionF = new PlantRegion(
                Set.of(
                        new Plant('F', new Position(8,9)),
                        new Plant('F', new Position(9,9)),
                        new Plant('F', new Position(9,8)),
                        new Plant('F', new Position(7,7)),
                        new Plant('F', new Position(8,7)),
                        new Plant('F', new Position(9,7)),
                        new Plant('F', new Position(7,6)),
                        new Plant('F', new Position(8,6)),
                        new Plant('F', new Position(9,6)),
                        new Plant('F', new Position(5,8))
                )
        );
        return Stream.of(
                Arguments.of(regionR, 10L),
                Arguments.of(regionI, 4L),
                Arguments.of(regionF, 12L)
        );
    }

    @ParameterizedTest
    @MethodSource("regionAndExpectedResults")
    void test_numberOfSides(PlantRegion plantRegion, long expectedResult) {
        // Act
        long numberOfSides = plantRegion.numberOfSides();

        // Assert
        assertThat(numberOfSides).isEqualTo(expectedResult);
    }

}