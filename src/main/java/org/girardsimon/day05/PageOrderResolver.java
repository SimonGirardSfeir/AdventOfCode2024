package org.girardsimon.day05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public final class PageOrderResolver {
    private PageOrderResolver() {
    }

    public static List<Integer> resolvePageOrder(Set<Integer> allPages, List<PageOrderingRule> rules) {
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        Map<Integer, Integer> inDegreeMap  = new HashMap<>();

        allPages.forEach(page -> {
            adjacencyList.put(page, new ArrayList<>());
            inDegreeMap.put(page, 0);
        });

        rules.forEach(rule -> {
            int pageBefore = rule.pageBefore();
            int pageAfter = rule.pageAfter();
            adjacencyList.get(pageBefore).add(pageAfter);
            inDegreeMap.put(pageAfter, inDegreeMap.get(pageAfter) + 1);
        });

        Queue<Integer> queue = new LinkedList<>();
        allPages.stream()
                .filter(page -> inDegreeMap.get(page) == 0)
                .forEach(queue::offer);

        List<Integer> pagesInOrder = new ArrayList<>();

        while (!queue.isEmpty()) {
            Integer currentPageNumber = queue.poll();
            pagesInOrder.add(currentPageNumber);

            adjacencyList.get(currentPageNumber).forEach(adjacentPage -> {
                inDegreeMap.put(adjacentPage, inDegreeMap.get(adjacentPage) - 1);
                if (inDegreeMap.get(adjacentPage) == 0) {
                    queue.offer(adjacentPage);
                }
            });
        }

        return pagesInOrder;
    }
}
