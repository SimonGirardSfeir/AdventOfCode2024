package org.girardsimon.day13;

import org.girardsimon.common.Position;

import java.util.Optional;

public record ClawMachine(Vector buttonAAction, Vector buttonBAction, Position prizePosition) {

    long cheapestWinWithDelta(long delta) {
        return cheapestWinningCombination(prizePosition.x() + delta, prizePosition.y() + delta);
    }

    long cheapestWinningCombination(long prizePositionX, long prizePositionY) {
        return solveEquationForPrizePosition(prizePositionX, prizePositionY)
                .map(solution -> 3 * solution.x + solution.y)
                .orElse(0L);
    }

    /**
     * Solves the equation system: buttonA * X + buttonB * Y = prizePosition.
     * Computes the solution (X, Y) in integer space if it exists.
     */
    private Optional<ClawMachineEquationSolution> solveEquationForPrizePosition(long prizePositionX, long prizePositionY) {
        long xNumerator = buttonBAction().dy() * prizePositionX - buttonBAction().dx() * prizePositionY;
        long xDenominator = (long) buttonAAction.dx() * buttonBAction().dy() - (long) buttonBAction().dx() * buttonAAction().dy();
        if(xDenominator == 0 || xNumerator == 0 || xNumerator % xDenominator != 0) {
            return Optional.empty();
        }

        long x = xNumerator / xDenominator;

        long numeratorY = prizePositionX - buttonAAction.dx() * x;
        long denominatorY = buttonBAction.dx();
        if(numeratorY % denominatorY != 0) {
            return Optional.empty();
        }
        long y = numeratorY/denominatorY;
        return Optional.of(new ClawMachineEquationSolution(x, y));
    }

    record ClawMachineEquationSolution(long x, long y) {
    }
}
