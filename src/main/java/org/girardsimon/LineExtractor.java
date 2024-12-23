package org.girardsimon;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public final class LineExtractor {

    private LineExtractor() {
    }

    public static List<String> getLines(String fileName) throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            return stream.toList();
        }
    }
}
