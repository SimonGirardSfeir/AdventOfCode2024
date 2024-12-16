package org.girardsimon.day11;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class StoneBlinker {

    long numberOfStonesAfterBlink(StoneCorridor stoneCorridor, int times) {
        List<StoneWithCount> stones = stoneCorridor.stones().stream()
                .map(stone -> new StoneWithCount(stone, 1))
                .toList();
        return IntStream.range(0, times)
                .boxed()
                .reduce(stones, (current, i) -> blinkAllStones(current), (a, b) -> b)
                .stream()
                .mapToLong(StoneWithCount::numberOfTimes)
                .sum();
    }

    List<StoneWithCount> blinkAllStones(List<StoneWithCount> stoneWithCounts) {
        Map<Stone, Long> resultMap = new HashMap<>();

        stoneWithCounts.forEach(
                stoneWithCount -> {
                    List<Stone> blinkedStones = stoneWithCount.stone.blink();
                    blinkedStones.forEach(
                            stone -> resultMap.merge(stone, stoneWithCount.numberOfTimes, Long::sum)
                    );
                }
        );

        return resultMap.entrySet().stream()
                .map(entry -> new StoneWithCount(entry.getKey(), entry.getValue()))
                .toList();
    }

    record StoneWithCount(Stone stone, long numberOfTimes) {

    }
}
