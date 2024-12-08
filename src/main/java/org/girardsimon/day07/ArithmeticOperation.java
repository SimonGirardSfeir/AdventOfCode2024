package org.girardsimon.day07;

public enum ArithmeticOperation {
    MULTIPLY {
        @Override
        public OperationMatchResult getOperationMatchResult(long targetValue, long lastOperand) {
            return new OperationMatchResult(
                    targetValue % lastOperand == 0L,
                    targetValue / lastOperand
            );
        }
    }, ADD {
        @Override
        public OperationMatchResult getOperationMatchResult(long targetValue, long lastOperand) {
            return new OperationMatchResult(
                    targetValue >= lastOperand,
                    targetValue - lastOperand
            );
        }
    },
    CONCATENATE {
        @Override
        public OperationMatchResult getOperationMatchResult(long targetValue, long lastOperand) {
            long digitRightOperant = (long) Math.pow(10, String.valueOf(lastOperand).length());
            return new OperationMatchResult(
                    targetValue % digitRightOperant == lastOperand,
                    targetValue / digitRightOperant
            );
        }
    };

    public abstract OperationMatchResult getOperationMatchResult(long targetValue, long lastOperand);
}
