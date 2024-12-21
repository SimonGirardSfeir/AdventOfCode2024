package org.girardsimon.day14;

import org.girardsimon.common.Position;
import org.girardsimon.common.Vector;


public record Robot(Position initialPosition, Vector velocityPerSecond) {

    Position robotPositionAfterSeconds(int seconds, int bathroomWidth, int bathroomHeight) {
        int newX = (initialPosition.x() + (velocityPerSecond().dx() + bathroomWidth)  * seconds) % (bathroomWidth);
        int newY = (initialPosition.y() + (velocityPerSecond().dy() + bathroomHeight)  * seconds) % (bathroomHeight);
        return new Position(newX,
                newY);
    }
}
