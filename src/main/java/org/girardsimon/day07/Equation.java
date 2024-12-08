package org.girardsimon.day07;

import java.util.List;

public record Equation(long targetValue, List<Long> operands) {

    public boolean isEquationSolvable(List<ArithmeticOperation> availableOperations) {
        return evaluatePossibleSolutions(targetValue, operands.size()-1, availableOperations);
    }

    private boolean evaluatePossibleSolutions(
            long targetValue,
            int currentIndex,
            List<ArithmeticOperation> availableOperations) {
        if(currentIndex < 0) {
            return targetValue == 0L;
        }
        return availableOperations.stream()
                .anyMatch(arithmeticOperation -> {
                    OperationMatchResult operationMatchResult =
                            arithmeticOperation.getOperationMatchResult(
                                    targetValue,
                                    operands.get(currentIndex));
                    if (operationMatchResult.canBeFinalOperator()) {
                        return evaluatePossibleSolutions(
                                operationMatchResult.remainingTargetValue(),
                                currentIndex - 1,
                                availableOperations);
                    }
                    return false;
                });
    }
}
