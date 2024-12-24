package org.girardsimon.day15;

import org.girardsimon.common.Direction4;
import org.girardsimon.common.Position;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.girardsimon.common.CoordinateSystem.INVERTED_Y;

public record Box(Position position, int width, Set<Position> occupiedPositions) {

    public Box(Position position, int width) {
        this(position, width, IntStream.range(0, width)
                .boxed()
                .map(i -> position.fromDelta(i, 0))
                .collect(Collectors.toSet()));
    }

    Box moveBox(Direction4 move) {
        Position newPosition = position.fromDelta(move.dx(INVERTED_Y), move.dy(INVERTED_Y));
        return new Box(newPosition, width);
    }
}
