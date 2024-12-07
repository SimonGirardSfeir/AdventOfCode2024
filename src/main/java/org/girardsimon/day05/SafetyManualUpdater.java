package org.girardsimon.day05;

import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public record SafetyManualUpdater(SafetyManualRules safetyManualRules, List<ManualUpdate> manualUpdates) {

    public long sumMiddlePageNumbersOfCorrectUpdates() {
        return manualUpdates.stream()
                .map(this::getUpdateStatusAndSortedUpdate)
                .filter(UpdateStatusAndSortedUpdate::isSorted)
                .map(UpdateStatusAndSortedUpdate::sortedUpdate)
                .mapToLong(this::getMiddlePageNumber)
                .sum();
    }

    public long sumMiddlePageNumbersOfIncorrectUpdates() {
        return manualUpdates.stream()
                .map(this::getUpdateStatusAndSortedUpdate)
                .filter(Predicate.not(UpdateStatusAndSortedUpdate::isSorted))
                .map(UpdateStatusAndSortedUpdate::sortedUpdate)
                .mapToLong(this::getMiddlePageNumber)
                .sum();
    }

    private long getMiddlePageNumber(List<Integer> sortedPages) {
        int middleIndex = sortedPages.size() / 2;
        return (long) sortedPages.get(middleIndex);
    }

    private UpdateStatusAndSortedUpdate getUpdateStatusAndSortedUpdate(ManualUpdate update) {
        List<Integer> updatePages = update.pages(); // Data structure with ordering
        Set<Integer> updatePagesAsSet = Set.copyOf(updatePages);  // Better data structure for topological sort and contains operation
        List<PageOrderingRule> rulesForUpdate = updatePages.stream()
                .map(page -> safetyManualRules.dictionaryRules().get(page))
                .flatMap(Set::stream)
                .filter(rule -> updatePagesAsSet.contains(rule.pageBefore()) && updatePagesAsSet.contains(rule.pageAfter()))
                .toList();
        List<Integer> sortedPages = PageOrderResolver.resolvePageOrder(updatePagesAsSet, rulesForUpdate);
        return new UpdateStatusAndSortedUpdate(sortedPages.equals(updatePages), sortedPages);
    }

    record UpdateStatusAndSortedUpdate(boolean isSorted, List<Integer> sortedUpdate) {

    }

}
