package org.girardsimon.day09;

import java.util.Deque;
import java.util.List;
import java.util.stream.IntStream;

public class FileSystemChecksumCalculator {

    private final DiskBlockReorder diskBlockReorder;
    private final FileBlockReorder fileBlockReorder;

    public FileSystemChecksumCalculator(DiskBlockReorder diskBlockReorder,
                                        FileBlockReorder fileBlockReorder) {
        this.diskBlockReorder = diskBlockReorder;
        this.fileBlockReorder = fileBlockReorder;
    }

    public long getFileSystemChecksumPerBlock(Disk disk) {
        Deque<DiskBlock> diskBlocks = disk.buildDiskBlocks();

        List<DiskBlock> reorderedDiskBlocks = diskBlockReorder.reorderBlocks(diskBlocks);
        return IntStream.range(0, reorderedDiskBlocks.size())
                .mapToLong(i -> i * Long.parseLong(reorderedDiskBlocks.get(i).fileId()))
                .sum();
    }

    public long getFileSystemChecksumPerFile(Disk disk) {
        List<FileBlock> fileBlocks = disk.buildFileBlocks();

        List<FileBlock> reorderedFileBlocks = fileBlockReorder.reorderBlocks(fileBlocks);

        List<DiskBlock> orderedDiskBlocks = reorderedFileBlocks.stream()
                .flatMap(fileBlock -> fileBlock.toDiskBlocks().stream())
                .toList();
        return IntStream.range(0, orderedDiskBlocks.size())
                .mapToLong(i -> i * Long.parseLong(orderedDiskBlocks.get(i).fileId()))
                .sum();
    }
}
