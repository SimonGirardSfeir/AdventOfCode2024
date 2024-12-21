package org.girardsimon.day14;

import java.util.List;
import java.util.stream.IntStream;

public class ChristmasTreeChecker {

    boolean isChristmasTreePresent(List<String> robotPhotography) {

        String firstLineOfChristmasTree = ChristmasTreeUtils.CHRISTMAS_TREE.getFirst();
        /*
            Optimization: Avoid full grid matching unless the first line of the pattern exists.
            This reduces unnecessary computations for cases where the pattern is not present.
        */
        boolean isFirstLineOfTemplatePresent = robotPhotography.stream()
                .anyMatch(line -> line.contains(firstLineOfChristmasTree));
        return isFirstLineOfTemplatePresent && checkForChristmasTree(robotPhotography);
    }

    static boolean checkForChristmasTree(List<String> robotPhotography) {
        char[][] pattern = to2DArray(ChristmasTreeUtils.CHRISTMAS_TREE);
        char[][] grid = to2DArray(robotPhotography);

        int patternHeight = pattern.length;
        int patternWidth = pattern[0].length;
        int gridHeight = grid.length;
        int gridWidth = grid[0].length;

        return IntStream.range(0, gridHeight - patternHeight + 1)
                .anyMatch(i -> IntStream.range(0, gridWidth - patternWidth + 1)
                        .anyMatch(j -> areGridMatching(grid, pattern, i, j)));
    }

    private static char[][] to2DArray(List<String> lines) {
        return lines.stream()
                .map(String::toCharArray)
                .toArray(char[][]::new);
    }

    private static boolean areGridMatching(char[][] grid, char[][] pattern, int startRow, int startCol) {
        int patternHeight = pattern.length;
        int patternWidth = pattern[0].length;

        return IntStream.range(0, patternHeight)
                .allMatch(i -> IntStream.range(0, patternWidth)
                        .allMatch(j -> grid[startRow + i][startCol + j] == pattern[i][j]));
    }
}