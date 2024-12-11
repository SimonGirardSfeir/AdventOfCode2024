package org.girardsimon.day08;

import org.girardsimon.common.Position;

import java.util.Set;

public class BasicAntiNodePositionAdder implements AntiNodePositionAdder {

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
            Position antiNodePosition1 = position1.fromDelta(-xDelta, -yDelta);
            if(isWithinMapBounds(cityMap, antiNodePosition1)) {
                allAntiNodesPositions.add(antiNodePosition1);
            }

            Position antiNodePosition2 = position2.fromDelta(xDelta, yDelta);
            if(isWithinMapBounds(cityMap, antiNodePosition2)) {
                allAntiNodesPositions.add(antiNodePosition2);
            }
        }
    }
}
