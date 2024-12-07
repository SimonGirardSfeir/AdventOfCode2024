package org.girardsimon.day05;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public record SafetyManualRules(Map<Integer, Set<PageOrderingRule>> dictionaryRules) {

    public static SafetyManualRules of(List<PageOrderingRule> pageOrderingRules){
        return new SafetyManualRules(buildDictionary(pageOrderingRules));
    }

    private static Map<Integer, Set<PageOrderingRule>> buildDictionary(List<PageOrderingRule> pageOrderingRules) {
        Map<Integer, Set<PageOrderingRule>> dictionaryPageBefore = pageOrderingRules.stream()
                .collect(Collectors.groupingBy(PageOrderingRule::pageBefore, Collectors.toCollection(HashSet::new)));
        Map<Integer, Set<PageOrderingRule>> dictionaryPageAfter = pageOrderingRules.stream()
                .collect(Collectors.groupingBy(PageOrderingRule::pageAfter, Collectors.toCollection(HashSet::new)));
        return Stream.concat(dictionaryPageBefore.entrySet().stream(), dictionaryPageAfter.entrySet().stream())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (set1, set2) -> Stream.concat(set1.stream(), set2.stream()).collect(Collectors.toSet())));
    }
}
