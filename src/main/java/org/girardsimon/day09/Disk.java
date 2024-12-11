package org.girardsimon.day09;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public record Disk(List<DiskSegment> diskSegments) {

    Deque<DiskBlock> buildDiskBlocks() {
        return IntStream.range(0, diskSegments.size())
                .boxed()
                .flatMap(i ->
                    Stream.concat(
                        Stream.generate(() -> new DiskBlock(String.valueOf(i)))
                                .limit(diskSegments.get(i).fileSpaceInBlocks())
                        ,
                        Stream.generate(() -> new DiskBlock(null))
                                .limit(diskSegments.get(i).freeSpaceInBlocks())
                    )
                )
                .collect(Collectors.toCollection(LinkedList::new));
    }

    List<FileBlock> buildFileBlocks() {
        return IntStream.range(0, diskSegments.size())
                .boxed()
                .flatMap(i ->
                        Stream.of(
                                new FileBlock(String.valueOf(i), diskSegments.get(i).fileSpaceInBlocks()),
                                new FileBlock(null, diskSegments.get(i).freeSpaceInBlocks())
                        )
                )
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
