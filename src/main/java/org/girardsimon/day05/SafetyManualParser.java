package org.girardsimon.day05;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class SafetyManualParser {
    private static final Pattern PAGE_ORDERING_RULE_PATTERN = Pattern.compile("(\\d+)\\|(\\d+)");
    private static final Pattern MANUAL_UPDATE_PATTERN = Pattern.compile("(\\d+),(\\d+,)*(\\d+)");
    private static final Pattern NUMBER_PATTERN = Pattern.compile("\\d+");

    private SafetyManualParser() {
    }

    public static SafetyManualUpdater parseSafetyManualUpdater(List<String> lines) {
        List<PageOrderingRule> pageOrderingRules = lines.stream()
                .map(SafetyManualParser::parsePageOrderingRule)
                .flatMap(List::stream)
                .toList();

        List<ManualUpdate> manualUpdates = lines.stream()
                .map(SafetyManualParser::parseManualUpdate)
                .flatMap(List::stream)
                .toList();

        return new SafetyManualUpdater(SafetyManualRules.of(pageOrderingRules), manualUpdates);
    }

    private static List<PageOrderingRule> parsePageOrderingRule(String line) {
        Matcher matcher = PAGE_ORDERING_RULE_PATTERN.matcher(line);
        if (matcher.matches()) {
            return List.of(new PageOrderingRule(
                    Integer.parseInt(matcher.group(1)),
                    Integer.parseInt(matcher.group(2))
            ));
        }
        return List.of();
    }

    private static List<ManualUpdate> parseManualUpdate(String line) {
        Matcher matcher = MANUAL_UPDATE_PATTERN.matcher(line);
        if (matcher.matches()) {
            Matcher numberMatcher = NUMBER_PATTERN.matcher(line);
            List<Integer> pages = new ArrayList<>();
            while (numberMatcher.find()) {
                pages.add(Integer.parseInt(numberMatcher.group()));
            }
            return List.of(new ManualUpdate(pages));
        }
        return List.of();
    }
}
