package org.girardsimon.day06;

import org.girardsimon.common.Direction4;
import org.girardsimon.common.Position;

public record Guard(Position position, Direction4 direction4) {

    public Guard moveForward() {
        Position positionForward = position.fromDelta(direction4.dx(), direction4.dy());
        return new Guard(positionForward, direction4);
    }

    public Guard moveBack() {
        Position positionBack = position.fromDelta(-direction4.dx(), -direction4.dy());
        Direction4 newDirection = direction4.turnRight();
        return new Guard(positionBack, newDirection);
    }
}
