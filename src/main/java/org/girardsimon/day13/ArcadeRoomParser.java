package org.girardsimon.day13;

import org.girardsimon.common.Position;
import org.girardsimon.common.Vector;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public final class ArcadeRoomParser {

    private static final Pattern BUTTON_A_PATTERN = Pattern.compile("Button A: X\\+(\\d+), Y\\+(\\d+)");
    private static final Pattern BUTTON_B_PATTERN = Pattern.compile("Button B: X\\+(\\d+), Y\\+(\\d+)");
    private static final Pattern PRIZE_PATTERN = Pattern.compile("Prize: X=(\\d+), Y=(\\d+)");

    private ArcadeRoomParser() {
    }

    public static ArcadeRoom parseArcadeRoom(List<String> lines) {
        List<Vector> buttonAs = new ArrayList<>();
        List<Vector> buttonBs = new ArrayList<>();
        List<Position> prizes = new ArrayList<>();
        lines.forEach(line -> {
            Matcher buttonAMatcher = BUTTON_A_PATTERN.matcher(line);
            Matcher buttonBMatcher = BUTTON_B_PATTERN.matcher(line);
            Matcher prizeMatcher = PRIZE_PATTERN.matcher(line);

            if(buttonAMatcher.matches()) {
                Vector vector = new Vector(
                        Integer.parseInt(buttonAMatcher.group(1)),
                        Integer.parseInt(buttonAMatcher.group(2)));
                buttonAs.add(vector);
            } else if (buttonBMatcher.matches()) {
                Vector vector = new Vector(
                        Integer.parseInt(buttonBMatcher.group(1)),
                        Integer.parseInt(buttonBMatcher.group(2)));
                buttonBs.add(vector);
            } else if (prizeMatcher.matches()) {
                Position position = new Position(
                        Integer.parseInt(prizeMatcher.group(1)),
                        Integer.parseInt(prizeMatcher.group(2)));
                prizes.add(position);

            }
        });

        int clawMachinesCount = Math.min(buttonAs.size(),
                Math.min(buttonBs.size(), prizes.size()));

        List<ClawMachine> clawMachines = IntStream.range(0, clawMachinesCount)
                .boxed()
                .map(i -> new ClawMachine(buttonAs.get(i), buttonBs.get(i), prizes.get(i)))
                .toList();

        return new ArcadeRoom(clawMachines);
    }
}
