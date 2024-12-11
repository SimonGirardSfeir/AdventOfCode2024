package org.girardsimon.day09;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class DiskBlockReorder {

    public List<DiskBlock> reorderBlocks(Deque<DiskBlock> diskBlocks) {
        List<DiskBlock> reorderedBlocks = new ArrayList<>();

        while (!diskBlocks.isEmpty()) {
            DiskBlock currentDiskBlock = diskBlocks.removeFirst();
            if(currentDiskBlock.isAssignedBlock()) {
                reorderedBlocks.add(currentDiskBlock);
            } else {
                DiskBlock currentLast = diskBlocks.removeLast();
                while (!diskBlocks.isEmpty() && !currentLast.isAssignedBlock()) {
                    currentLast = diskBlocks.removeLast();
                }
                reorderedBlocks.add(currentLast);
            }
        }

        return reorderedBlocks;
    }
}
