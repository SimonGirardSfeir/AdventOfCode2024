package org.girardsimon.day09;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FileSystemChecksumCalculatorTest {

    FileSystemChecksumCalculator fileSystemChecksumCalculator = new FileSystemChecksumCalculator(
            new DiskBlockReorder(),
            new FileBlockReorder());

    @Test
    void test_getFileSystemChecksumPerBlock() {
        // Arrange
        Disk disk = DiskParser.parseDisk("2333133121414131402");

        // Act
        long fileSystemChecksum = fileSystemChecksumCalculator.getFileSystemChecksumPerBlock(disk);

        // Assert
        assertThat(fileSystemChecksum).isEqualTo(1928L);
    }

    @Test
    void test_getFileSystemChecksumPerFile() {
        // Arrange
        Disk disk = DiskParser.parseDisk("2333133121414131402");

        // Act
        long fileSystemChecksum = fileSystemChecksumCalculator.getFileSystemChecksumPerFile(disk);

        // Assert
        assertThat(fileSystemChecksum).isEqualTo(2858L);
    }

}