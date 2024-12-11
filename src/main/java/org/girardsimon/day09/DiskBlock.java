package org.girardsimon.day09;

public record DiskBlock(String fileId) {

    boolean isAssignedBlock() {
        return fileId != null;
    }
}
