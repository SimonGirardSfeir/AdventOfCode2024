package org.girardsimon.day07;


public record OperationMatchResult (
        boolean canBeFinalOperator, // Determines whether the operator can be applied as the final operation on the operands
        Long remainingTargetValue // Calculates the updated target value for the remaining operands
) {
}
