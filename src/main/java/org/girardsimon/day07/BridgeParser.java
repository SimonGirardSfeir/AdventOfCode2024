package org.girardsimon.day07;

import java.util.Arrays;
import java.util.List;

public final class BridgeParser {
    private BridgeParser() {
    }

    public static Bridge parseBridge(List<String> lines) {
        List<Equation> equations = lines.stream()
                .map(BridgeParser::parseEquation)
                .toList();
        return new Bridge(equations);
    }

    private static Equation parseEquation(String line) {
        String[] split = line.split(":");
        long testValue = Long.parseLong(split[0]);
        String[] operandsSplit = split[1].trim().split(" ");
        List<Long> operands = Arrays.stream(operandsSplit)
                .map(Long::parseLong)
                .toList();
        return new Equation(testValue, operands);
    }
}
