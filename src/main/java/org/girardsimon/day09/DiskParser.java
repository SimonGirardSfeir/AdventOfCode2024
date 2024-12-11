package org.girardsimon.day09;

import java.util.List;
import java.util.stream.IntStream;

public final class DiskParser {
    private DiskParser() {
    }

    public static Disk parseDisk(String line) {
        List<DiskSegment> diskSegments = IntStream.iterate(0, i -> i < line.length(), i -> i + 2)
                .mapToObj(i -> new DiskSegment(
                        Integer.parseInt(String.valueOf(line.charAt(i))),
                        (i + 1) < line.length() ? Integer.parseInt(String.valueOf(line.charAt(i + 1))) : 0)
                )
                .toList();
        return new Disk(diskSegments);
    }
}
