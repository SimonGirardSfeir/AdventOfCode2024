package org.girardsimon.day08;

import org.girardsimon.common.Position;

import java.util.Set;

public interface AntiNodePositionAdder {
    void addAntiNodePositions(
            CityMap cityMap,
            Position position1,
            Position position2,
            Set<Position> allAntiNodesPositions
    );

    default boolean isWithinMapBounds(CityMap cityMap, Position position) {
        return position.x() < cityMap.maxWidth() && position.x() >= 0
                && position.y() < cityMap.maxHeight() && position.y() >= 0;
    }
}
