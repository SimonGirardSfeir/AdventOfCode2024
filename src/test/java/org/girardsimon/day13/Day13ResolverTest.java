package org.girardsimon.day13;

import org.girardsimon.LineExtractor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Day13ResolverTest {

    private static ArcadeRoom arcadeRoom;

    @BeforeAll
    static void setUp() throws IOException {
        List<String> lines = LineExtractor.getLines("src/test/resources/day13/inputData.txt");
        arcadeRoom = ArcadeRoomParser.parseArcadeRoom(lines);
    }

    @Test
    void resolve_part1_of_day13_problem() {
        // Act
        long fewestTokensToWinAllPrizes  = arcadeRoom.fewestTokensToWinAllPrizes(0L);

        // Assert
        assertThat(fewestTokensToWinAllPrizes).isEqualTo(38839L);
    }

    @Test
    void resolve_part2_of_day13_problem() {
        // Act
        long fewestTokensToWinAllPrizes  = arcadeRoom.fewestTokensToWinAllPrizes(10000000000000L);

        // Assert
        assertThat(fewestTokensToWinAllPrizes).isEqualTo(75200131617108L);
    }
}
