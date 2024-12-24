package org.girardsimon.day15;

import org.girardsimon.common.CoordinateSystem;
import org.girardsimon.common.Direction4;
import org.girardsimon.common.Position;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public record Warehouse(Set<Wall> walls, Set<Box> boxes, Set<Position> wallPositions, Set<Position> boxPositions) {

    public Warehouse(Set<Wall> walls, Set<Box> boxes) {
        this(walls, boxes, walls.stream()
                .flatMap(wall -> wall.occupiedPositions().stream())
                .collect(Collectors.toSet()), boxes.stream()
                .flatMap(box -> box.occupiedPositions().stream())
                .collect(Collectors.toCollection(HashSet::new)));
    }

    boolean hasRobotClearPath(Position nextRobotPosition) {
        return !wallPositions.contains(nextRobotPosition) && !boxPositions.contains(nextRobotPosition);
    }

    boolean isBoxAt(Position nextRobotPosition) {
        return boxPositions.contains(nextRobotPosition);
    }

    /**
     * @param nextRobotPosition future possible position for robot
     * @param move current move for robot
     * @return true if the facing boxes has moved, false otherwise
     */
    boolean tryMoveBox(Position nextRobotPosition, Direction4 move) {
        Set<Box> facingBoxes = boxes.stream()
                .filter(box -> box.occupiedPositions().contains(nextRobotPosition))
                .collect(Collectors.toSet());

        return !moveBoxes(facingBoxes, move).equals(facingBoxes);
    }

    private Set<Box> moveBoxes(Set<Box> boxesToMove, Direction4 move) {
        Set<Position> futureBoxesPositions = boxesToMove.stream()
                .flatMap(box -> box.occupiedPositions().stream())
                .map(position -> position.fromDelta
                                (move.dx(CoordinateSystem.INVERTED_Y), move.dy(CoordinateSystem.INVERTED_Y)))
                .collect(Collectors.toSet());

        boolean isWallBlocking = futureBoxesPositions.stream()
                .anyMatch(wallPositions::contains);
        boolean isBoxBlocking = boxes.stream()
                .filter(box -> !boxesToMove.contains(box))
                .flatMap(box -> box.occupiedPositions().stream())
                .anyMatch(futureBoxesPositions::contains);

        if(!isBoxBlocking && !isWallBlocking) {
            return displacedBoxes(boxesToMove, move);
        } else if (isWallBlocking) {
            return boxesToMove;
        } else  {
            Set<Box> blockingBoxes = boxes.stream()
                    .filter(boxCandidate -> boxCandidate.occupiedPositions().stream().anyMatch(futureBoxesPositions::contains))
                    .filter(boxCandidate -> !boxesToMove.contains(boxCandidate))
                    .collect(Collectors.toSet());

            Set<Box> nextBoxMoved = moveBoxes(blockingBoxes, move);
            if (nextBoxMoved.equals(blockingBoxes)) {
                return boxesToMove;
            }
            return displacedBoxes(boxesToMove, move);

        }
    }

    private Set<Box> displacedBoxes(Set<Box> boxesToMove, Direction4 move) {
        Set<Box> nextBoxes = boxesToMove.stream()
                .map(box -> box.moveBox(move))
                .collect(Collectors.toSet());
        boxes.addAll(nextBoxes);
        boxes.removeAll(boxesToMove);
        boxPositions.removeAll(boxesToMove.stream().flatMap(box -> box.occupiedPositions().stream()).collect(Collectors.toSet()));
        boxPositions.addAll(nextBoxes.stream().flatMap(box -> box.occupiedPositions().stream()).collect(Collectors.toSet()));
        return nextBoxes;
    }
}
