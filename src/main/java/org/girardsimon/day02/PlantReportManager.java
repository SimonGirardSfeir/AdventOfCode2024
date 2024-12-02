package org.girardsimon.day02;

import java.util.List;

public record PlantReportManager(List<Report> reports) {

    public long countNumberOfSafeReports() {
        return reports.stream()
                .filter(Report::isSafe)
                .count();
    }

    public long countNumberOfSafeReportsWithTolerance() {
        return reports.stream()
                .filter(Report::isSafeWithTolerance)
                .count();
    }
}
