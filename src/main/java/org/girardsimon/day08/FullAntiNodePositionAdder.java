package org.girardsimon.day08;

import org.girardsimon.common.Position;

import java.util.Set;

public class FullAntiNodePositionAdder implements AntiNodePositionAdder {

    @Override
    public void addAntiNodePositions(
            CityMap cityMap,
            Position position1,
            Position position2,
            Set<Position> allAntiNodesPositions
    ) {
        if(!position1.equals(position2)) {
            int xDelta = position2.x() - position1.x();
            int yDelta = position2.y() - position1.y();

            Position antiNodePosition1 = position1;

            while (isWithinMapBounds(cityMap, antiNodePosition1)) {
                allAntiNodesPositions.add(antiNodePosition1);
                antiNodePosition1 = antiNodePosition1.fromDelta(-xDelta, -yDelta);
            }
            Position antiNodePosition2 = position2;
            while (isWithinMapBounds(cityMap, antiNodePosition2)) {
                allAntiNodesPositions.add(antiNodePosition2);
                antiNodePosition2 = antiNodePosition2.fromDelta(xDelta, yDelta);
            }
        }
    }
}
