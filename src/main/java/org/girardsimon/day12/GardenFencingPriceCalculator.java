package org.girardsimon.day12;

import java.util.List;

public class GardenFencingPriceCalculator {

    private final FencingPriceCalculator fencingPriceCalculator;

    public GardenFencingPriceCalculator(FencingPriceCalculator fencingPriceCalculator) {
        this.fencingPriceCalculator = fencingPriceCalculator;
    }

    public long computeFencingPrice(Garden garden) {
        List<PlantRegion> plantRegions = garden.buildPlantRegions();

        return plantRegions.stream()
                .mapToLong(fencingPriceCalculator::computeFencingPrice)
                .sum();
    }
}
