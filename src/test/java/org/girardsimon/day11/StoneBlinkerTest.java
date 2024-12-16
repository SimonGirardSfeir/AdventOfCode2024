package org.girardsimon.day11;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StoneBlinkerTest {

    StoneBlinker stoneBlinker = new StoneBlinker();

    @Test
    void test_repeatBlink() {
        // Arrange
        StoneCorridor stoneCorridor = new StoneCorridor(
                List.of(
                        new Stone(125),
                        new Stone(17)
                )
        );

        // Act
        long numberOfStonesAfterBlink = stoneBlinker.numberOfStonesAfterBlink(stoneCorridor, 25);

        // Assert
        assertThat(numberOfStonesAfterBlink)
                .isEqualTo(55312L);
    }

}