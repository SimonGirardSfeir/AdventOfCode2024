package org.girardsimon.day07;

import java.util.List;

public record Bridge(List<Equation> equations) {

    public long computeTotalCalibration(List<ArithmeticOperation> arithmeticOperations) {
        return equations.stream()
                .filter(equation -> equation.isEquationSolvable(arithmeticOperations))
                .mapToLong(Equation::targetValue)
                .sum();
    }
}
