package org.girardsimon.day12;

public class FencingPriceCalculatorNumberOfSidesFormula implements FencingPriceCalculator {
    @Override
    public long computeFencingPrice(PlantRegion plantRegion) {
        return plantRegion.area() * plantRegion.numberOfSides();
    }
}
