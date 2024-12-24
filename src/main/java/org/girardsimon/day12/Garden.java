package org.girardsimon.day12;

import org.girardsimon.common.Direction4;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.girardsimon.common.CoordinateSystem.STANDARD;

public record Garden(Set<Plant> plants) {

    List<PlantRegion> buildPlantRegions() {
        Set<Plant> visitedPlants = new HashSet<>();
        List<PlantRegion> plantRegions = new ArrayList<>();

        plants.forEach(plant -> {
            if(!visitedPlants.contains(plant)) {
                visitedPlants.add(plant);
                PlantRegion plantRegion = buildPlantRegionFromPlant(plant);
                plantRegions.add(plantRegion);
                visitedPlants.addAll(plantRegion.plants());
            }
        });

        return plantRegions;
    }

    private PlantRegion buildPlantRegionFromPlant(Plant plant) {
        Set<Plant> visitedPlants = new HashSet<>();
        visitedPlants.add(plant);
        exploreNeighboringPlants(plant, visitedPlants);
        return new PlantRegion(visitedPlants);
    }

    private void exploreNeighboringPlants(Plant plant, Set<Plant> visitedPlants) {
        Deque<Plant> stack = new ArrayDeque<>();
        stack.push(plant);

        while (!stack.isEmpty()) {
            Plant currentPlant = stack.pop();
            Arrays.stream(Direction4.values())
                    .map(direction -> new Plant(currentPlant.plantType(),
                            currentPlant.position().fromDelta(direction.dx(STANDARD), direction.dy(STANDARD))))
                    .filter(neighbor -> !visitedPlants.contains(neighbor) && plants.contains(neighbor))
                    .forEach(neighbor -> {
                        visitedPlants.add(neighbor);
                        stack.push(neighbor);
                    });
        }
    }
}
