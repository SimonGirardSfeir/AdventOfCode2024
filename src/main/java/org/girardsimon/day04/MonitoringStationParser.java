package org.girardsimon.day04;

import org.girardsimon.common.Position;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public final class MonitoringStationParser {
    private MonitoringStationParser() {
    }

    public static MonitoringStation parseMonitoringStation(List<String> lines) {
        int n = lines.size();
        int m = lines.getFirst().length();
        Map<Position, StationLetter> stationLetters = new HashMap<>();

        IntStream.range(0, n)
                .forEach(i ->
                        IntStream.range(0, m)
                                .forEach(j ->
                                        stationLetters.put(
                                                new Position(i, j),
                                                StationLetter.fromValue(lines.get(i).charAt(j)))));
        return new MonitoringStation(stationLetters, n, m);
    }
}
