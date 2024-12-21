package org.girardsimon.day13;

import java.util.List;

public record ArcadeRoom(List<ClawMachine> clawMachines) {

    long fewestTokensToWinAllPrizes(long delta) {
        return clawMachines.stream()
                .mapToLong(clawMachine -> clawMachine.cheapestWinWithDelta(delta))
                .sum();
    }
}
