package org.girardsimon.day14;

import org.girardsimon.common.Position;
import org.girardsimon.common.Vector;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BathroomParserTest {

    @Test
    void test_parseBathroom() {
        // Arrange
        List<String> lines = List.of(
                "p=0,4 v=3,-3",
                "p=6,3 v=-1,-3",
                "p=10,3 v=-1,2",
                "p=2,0 v=2,-1",
                "p=0,0 v=1,3",
                "p=3,0 v=-2,-2",
                "p=7,6 v=-1,-3",
                "p=3,0 v=-1,-2",
                "p=9,3 v=2,3",
                "p=7,3 v=-1,2",
                "p=2,4 v=2,-3",
                "p=9,5 v=-3,-3"
        );

        // Act
        Bathroom bathroom = BathroomParser.parseBathroom(lines);

        // Assert
        assertThat(bathroom)
                .extracting(Bathroom::width, Bathroom::height)
                .containsExactly(11, 7);
        assertThat(bathroom.robots())
                .containsExactlyInAnyOrder(
                        new Robot(new Position(0, 4), new Vector(3, -3)),
                        new Robot(new Position(6, 3), new Vector(-1, -3)),
                        new Robot(new Position(10, 3), new Vector(-1, 2)),
                        new Robot(new Position(2, 0), new Vector(2, -1)),
                        new Robot(new Position(0, 0), new Vector(1, 3)),
                        new Robot(new Position(3, 0), new Vector(-2, -2)),
                        new Robot(new Position(7, 6), new Vector(-1, -3)),
                        new Robot(new Position(3, 0), new Vector(-1, -2)),
                        new Robot(new Position(9, 3), new Vector(2, 3)),
                        new Robot(new Position(7, 3), new Vector(-1, 2)),
                        new Robot(new Position(2, 4), new Vector(2, -3)),
                        new Robot(new Position(9, 5), new Vector(-3, -3))
                );
    }

}