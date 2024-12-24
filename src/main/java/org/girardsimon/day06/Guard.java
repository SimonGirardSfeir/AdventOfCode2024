package org.girardsimon.day06;

import org.girardsimon.common.Direction4;
import org.girardsimon.common.Position;

import static org.girardsimon.common.CoordinateSystem.STANDARD;

public record Guard(Position position, Direction4 direction4) {

    public Guard moveForward() {
        Position positionForward = position.fromDelta(direction4.dx(STANDARD), direction4.dy(STANDARD));
        return new Guard(positionForward, direction4);
    }

    public Guard moveBack() {
        Position positionBack = position.fromDelta(-direction4.dx(STANDARD), -direction4.dy(STANDARD));
        Direction4 newDirection = direction4.turnRight();
        return new Guard(positionBack, newDirection);
    }
}
