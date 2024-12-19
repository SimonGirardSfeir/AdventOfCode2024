package org.girardsimon.day12;

import org.girardsimon.common.Position;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class GardenTest {

    @Test
    void test_buildPlantRegions() {
        // Arrange
        Set<Plant> plants = Set.of(
                new Plant('A', new Position(0, 3)),
                new Plant('A', new Position(1, 3)),
                new Plant('A', new Position(2, 3)),
                new Plant('A', new Position(3, 3)),
                new Plant('B', new Position(0, 2)),
                new Plant('B', new Position(1, 2)),
                new Plant('C', new Position(2, 2)),
                new Plant('D', new Position(3, 2)),
                new Plant('B', new Position(0, 1)),
                new Plant('B', new Position(1, 1)),
                new Plant('C', new Position(2, 1)),
                new Plant('C', new Position(3, 1)),
                new Plant('E', new Position(0, 0)),
                new Plant('E', new Position(1, 0)),
                new Plant('E', new Position(2, 0)),
                new Plant('C', new Position(3, 0))
        );
        Garden garden = new Garden(plants);

        // Act
        List<PlantRegion> plantRegions = garden.buildPlantRegions();

        // Assert
        assertThat(plantRegions)
                .containsExactlyInAnyOrder(
                        new PlantRegion(Set.of(
                                new Plant('A', new Position(0, 3)),
                                new Plant('A', new Position(1, 3)),
                                new Plant('A', new Position(2, 3)),
                                new Plant('A', new Position(3, 3))
                        )),
                        new PlantRegion(Set.of(
                                new Plant('B', new Position(0, 2)),
                                new Plant('B', new Position(1, 2)),
                                new Plant('B', new Position(0, 1)),
                                new Plant('B', new Position(1, 1))
                        )),
                        new PlantRegion(Set.of(
                                new Plant('C', new Position(2, 2)),
                                new Plant('C', new Position(2, 1)),
                                new Plant('C', new Position(3, 1)),
                                new Plant('C', new Position(3, 0))
                        )),
                        new PlantRegion(Set.of(
                                new Plant('D', new Position(3, 2))
                        )),
                        new PlantRegion(Set.of(
                                new Plant('E', new Position(0, 0)),
                                new Plant('E', new Position(1, 0)),
                                new Plant('E', new Position(2, 0))
                        ))
                );
    }
}