package org.girardsimon.day12;

import org.girardsimon.common.Direction4;
import org.girardsimon.common.Position;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.girardsimon.common.CoordinateSystem.STANDARD;

public record PlantRegion(Set<Plant> plants) {
    long area() {
        return plants.size();
    }

    long perimeter() {
        Set<Position> plantPositions = plants.stream().map(Plant::position).collect(Collectors.toSet());
        return plantPositions.stream()
                .mapToLong(position -> countBorders(position, plantPositions))
                .sum();
    }

    private long countBorders(Position position, Set<Position> plantPositions) {
        return Arrays.stream(Direction4.values())
                .filter(direction -> !plantPositions.contains(
                        position.fromDelta(direction.dx(STANDARD), direction.dy(STANDARD)))
                )
                .toList()
                .size();
    }

    long numberOfSides() {
        Set<Position> plantPositions = plants.stream()
                .map(Plant::position)
                .collect(Collectors.toSet());

        Map<Direction4, Set<Segment>> sidesPerDirection = Arrays.stream(Direction4.values())
                .collect(Collectors.toMap(Function.identity(), direction -> new HashSet<>()));

        plantPositions.forEach(position ->
                Arrays.stream(Direction4.values())
                    .filter(direction ->
                            !plantPositions.contains(position.fromDelta(
                                    direction.dx(STANDARD),
                                    direction.dy(STANDARD))
                            )
                    )
                    .forEach(direction -> mergeNeighboringSegmentInDirection(position, direction, sidesPerDirection))
        );

        return sidesPerDirection.values().stream()
                .mapToLong(Set::size)
                .sum();
    }

    private static void mergeNeighboringSegmentInDirection(Position currentPosition,
                                                           Direction4 currentDirection,
                                                           Map<Direction4, Set<Segment>> sidesPerDirection) {
        Segment segmentToAdd = SegmentUtils.createBorderSegment(currentPosition, currentDirection);

        Set<Segment> segmentsByDirection = sidesPerDirection.get(currentDirection);

        Optional<Segment> upperMergeCandidate = segmentsByDirection.stream()
                .filter(SegmentUtils.getUpperConditionForLowerNeighbor(segmentToAdd, currentDirection))
                .findFirst();
        Optional<Segment> lowerMergeCandidate = segmentsByDirection.stream()
                .filter(SegmentUtils.getMergeConditionForLowerNeighbor(segmentToAdd, currentDirection))
                .findFirst();

        if(lowerMergeCandidate.isPresent() || upperMergeCandidate.isPresent()) {
            lowerMergeCandidate.ifPresent(segmentsByDirection::remove);
            upperMergeCandidate.ifPresent(segmentsByDirection::remove);

            Position start = lowerMergeCandidate.map(Segment::start).orElse(segmentToAdd.start());
            Position end = upperMergeCandidate.map(Segment::end).orElse(segmentToAdd.end());
            segmentsByDirection.add(new Segment(start, end));
        } else {
            segmentsByDirection.add(segmentToAdd);
        }
    }
}
