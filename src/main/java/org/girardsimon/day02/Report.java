package org.girardsimon.day02;

import java.util.List;
import java.util.stream.IntStream;

public record Report(List<Integer> levels) {

    private static final int MAX_LEVEL_TRANSITION = 3;

    public boolean isSafe() {
        return isSafeExceptIndex(-1);
    }

    public boolean isSafeWithTolerance() {
        return IntStream.range(-1, levels.size())
                .anyMatch(this::isSafeExceptIndex);
    }

    private boolean isSafeExceptIndex(int indexToSkip) {
        return IntStream.range(0, levels.size())
                .noneMatch(i -> i != indexToSkip && isInvalidTransition(i, indexToSkip));
    }

    private boolean isInvalidTransition(int currentLevel, int indexToSkip) {
        boolean shouldIncrease = levels.getLast() - levels.getFirst() > 0;
        int nextLevel = currentLevel + 1 != indexToSkip ? currentLevel + 1 : currentLevel+2;
        if(nextLevel >= levels.size()) {
            return false;
        }

        return (levels.get(currentLevel) > levels.get(nextLevel) && shouldIncrease)
                || (levels.get(currentLevel) < levels.get(nextLevel) && !shouldIncrease)
                || (levels.get(currentLevel).equals(levels.get(nextLevel)))
                || (Math.abs(levels.get(currentLevel) - levels.get(nextLevel)) > MAX_LEVEL_TRANSITION);
    }
}
