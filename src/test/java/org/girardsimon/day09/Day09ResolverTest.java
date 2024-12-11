package org.girardsimon.day09;

import org.girardsimon.LineExtractor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Day09ResolverTest {

    private static Disk disk;
    private static FileSystemChecksumCalculator fileSystemChecksumCalculator;

    @BeforeAll
    static void setUp() throws IOException {
        List<String> lines = LineExtractor.getLines("src/test/resources/day09/inputData.txt");
        disk = DiskParser.parseDisk(lines.getFirst());
        fileSystemChecksumCalculator = new FileSystemChecksumCalculator(new DiskBlockReorder(),
                new FileBlockReorder());
    }

    @Test
    void resolve_part1_of_day09_problem() {
        // Act
        long fileSystemChecksum  = fileSystemChecksumCalculator.getFileSystemChecksumPerBlock(disk);

        // Assert
        assertThat(fileSystemChecksum).isEqualTo(6258319840548L);
    }

    @Test
    void resolve_part2_of_day09_problem() {
        // Act
        long fileSystemChecksum  = fileSystemChecksumCalculator.getFileSystemChecksumPerFile(disk);

        // Assert
        assertThat(fileSystemChecksum).isEqualTo(6286182965311L);
    }
}
