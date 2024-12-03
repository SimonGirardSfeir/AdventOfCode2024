package org.girardsimon.day03;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ProgramParser {

    private static final Pattern MULTIPLIER_TUPLE_PATTERN = Pattern.compile("mul\\((\\d+),(\\d+)\\)");
    private static final Pattern EXCLUDE_PATTERN = Pattern.compile("don't\\(\\).*?do\\(\\)", Pattern.DOTALL);
    private static final Pattern TRUNCATE_PATTERN = Pattern.compile("don't\\(\\)(?!.*?do\\(\\)).*", Pattern.DOTALL);

    private ProgramParser() {
    }

    public static Program parseProgramSimple(List<String> lines) {
        String singleLine = String.join("", lines);
        List<Tuple> tuples = parseTupleSimple(singleLine);
        return new Program(tuples);
    }

    private static List<Tuple> parseTupleSimple(String line) {
        Matcher matcher = MULTIPLIER_TUPLE_PATTERN.matcher(line);

        List<Tuple> tuples = new ArrayList<>();

        while (matcher.find()) {
            tuples.add(new Tuple(Long.parseLong(matcher.group(1)),
                    Long.parseLong(matcher.group(2))));
        }
        return tuples;
    }


    public static Program parseProgram(List<String> lines) {
        String singleLine = String.join("", lines);

        String truncated = EXCLUDE_PATTERN.matcher(singleLine).replaceAll("");

        String lineWithoutTrailingBadInstructions = TRUNCATE_PATTERN.matcher(truncated).replaceAll("");
        List<Tuple> tuples = parseTupleSimple(lineWithoutTrailingBadInstructions);
        return new Program(tuples);
    }
}
