package org.girardsimon.day03;

import java.util.List;

public record Program(List<Tuple> tuples) {

    public long sumMultiplications() {
        return tuples.stream()
                .mapToLong(Tuple::multiply)
                .sum();
    }
}
