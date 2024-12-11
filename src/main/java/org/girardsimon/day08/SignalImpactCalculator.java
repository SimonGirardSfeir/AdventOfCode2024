package org.girardsimon.day08;

import org.girardsimon.common.Position;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SignalImpactCalculator {

    private final AntiNodePositionAdder antiNodePositionAdder;

    public SignalImpactCalculator(AntiNodePositionAdder antiNodePositionAdder) {
        this.antiNodePositionAdder = antiNodePositionAdder;
    }

    public int computeSignalImpact(CityMap cityMap) {
        Map<Character, List<Antenna>> antennasPerFrequency = cityMap.getAntennasGroupedByFrequency();

        return antennasPerFrequency.values().stream()
                .flatMap(antennas -> antiNodesPositionsForFrequency(cityMap, antennas).stream())
                .collect(Collectors.toSet())
                .size();
    }

    private Set<Position> antiNodesPositionsForFrequency(CityMap cityMap,
                                                         List<Antenna> antennas) {
        Set<Position> antiNodesPositions = new HashSet<>();
        IntStream.range(0, antennas.size())
                .forEach(i -> IntStream.range(i+1, antennas.size())
                        .forEach(j ->
                                antiNodePositionAdder.addAntiNodePositions(
                                        cityMap,
                                        antennas.get(i).position(),
                                        antennas.get(j).position(),
                                        antiNodesPositions)
                        )
                );
        return antiNodesPositions;
    }
}
