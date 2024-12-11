package org.girardsimon.day09;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public record FileBlock(String fileId, int sizeInBlocks) {

    boolean isFileBlock() {
        return fileId != null;
    }

    List<FileBlock> replaceBlock(FileBlock newBlock) {
        if(newBlock.sizeInBlocks() >= sizeInBlocks) {
            return new ArrayList<>(List.of(newBlock));
        } else {
            List<FileBlock> newBlocks = new ArrayList<>();
            newBlocks.add(newBlock);
            newBlocks.add(new FileBlock(fileId, sizeInBlocks - newBlock.sizeInBlocks()));
            return newBlocks;
        }
    }

    FileBlock removeBlock() {
        return new FileBlock(null, sizeInBlocks);
    }

    List<DiskBlock> toDiskBlocks() {
        return Stream.generate(this::getDiskBlock).limit(sizeInBlocks).toList();
    }

    private DiskBlock getDiskBlock() {
        return Optional.ofNullable(fileId)
                .map(DiskBlock::new)
                .orElse(new DiskBlock("0"));
    }
}
