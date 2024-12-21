package org.girardsimon.day13;

import org.girardsimon.common.Position;
import org.girardsimon.common.Vector;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ArcadeRoomParserTest {

    @Test
    void test_parseArcadeRoom() {
        // Arrange
        List<String> lines = List.of(
                "Button A: X+94, Y+34",
                "Button B: X+22, Y+67",
                "Prize: X=8400, Y=5400",
                "",
                "Button A: X+26, Y+66",
                "Button B: X+67, Y+21",
                "Prize: X=12748, Y=12176"
        );

        // Act
        ArcadeRoom arcadeRoom = ArcadeRoomParser.parseArcadeRoom(lines);

        // Assert
        assertThat(arcadeRoom.clawMachines())
                .containsExactlyInAnyOrder(
                        new ClawMachine(
                                new Vector(94,34),
                                new Vector(22,67),
                                new Position(8400, 5400)
                        ),
                        new ClawMachine(
                                new Vector(26,66),
                                new Vector(67,21),
                                new Position(12748, 12176)
                        )
                );
    }

}