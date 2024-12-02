package org.girardsimon.day02;

import java.util.Arrays;
import java.util.List;

public final class PlantReportParser {
    private PlantReportParser() {
    }

    public static PlantReportManager parsePlantReportManager(List<String> lines) {
        List<Report> plantReports = lines.stream()
                .map(PlantReportParser::mapLineToReport)
                .toList();
        return new PlantReportManager(plantReports);
    }

    private static Report mapLineToReport(String line) {
        List<Integer> levels = Arrays.stream(line.split("\\s+"))
                .map(Integer::parseInt)
                .toList();
        return new Report(levels);
    }
}
