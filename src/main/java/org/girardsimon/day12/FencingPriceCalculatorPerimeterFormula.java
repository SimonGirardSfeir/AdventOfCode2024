package org.girardsimon.day12;

public class FencingPriceCalculatorPerimeterFormula implements FencingPriceCalculator {
    @Override
    public long computeFencingPrice(PlantRegion plantRegion) {
        return plantRegion.area() * plantRegion.perimeter();
    }
}
