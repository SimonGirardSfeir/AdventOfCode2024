package org.girardsimon.day09;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FileBlockReorder {

    public List<FileBlock> reorderBlocks(List<FileBlock> fileBlocks) {
        Map<Integer, FileBlock> fileBlocksPerFileId = fileBlocks.stream()
                .filter(FileBlock::isFileBlock)
                .collect(Collectors.toMap(fileBlock -> Integer.parseInt(fileBlock.fileId()), Function.identity()));

        Integer currentFileId = fileBlocksPerFileId.keySet().stream().max(Integer::compareTo).orElse(-1);

        while (currentFileId >= 0) {
            FileBlock fileBlock = fileBlocksPerFileId.get(currentFileId);

            DiskBlockReplacementTracker tracker = canRelocateBlockToEmptySpot(fileBlocks, fileBlock);

            if(tracker.isRelocatable) {
                fileBlocks.set(tracker.originalIndex, fileBlock.removeBlock());
                List<FileBlock> fileBlocksReplacement = fileBlocks.get(tracker.newIndex).replaceBlock(fileBlock);
                fileBlocks.subList(tracker.newIndex, tracker.newIndex + 1).clear();
                fileBlocks.addAll(tracker.newIndex, fileBlocksReplacement);
            }

            currentFileId--;

        }
        return fileBlocks;
    }

    private DiskBlockReplacementTracker canRelocateBlockToEmptySpot(List<FileBlock> fileBlocks, FileBlock currentFileBlock) {
        int currentIndex = fileBlocks.indexOf(currentFileBlock);

        for (int j = 0; j < currentIndex; j++) {
            FileBlock potentialSpot = fileBlocks.get(j);
            if (potentialSpot.fileId() == null && potentialSpot.sizeInBlocks() >= currentFileBlock.sizeInBlocks()) {
                return new DiskBlockReplacementTracker(true, currentIndex, j);
            }
        }
        return new DiskBlockReplacementTracker(false, -1, -1);
    }

    record DiskBlockReplacementTracker(boolean isRelocatable, int originalIndex, int newIndex) {
    }
}
