package org.girardsimon.day15;

import org.girardsimon.common.Direction4;
import org.girardsimon.common.Position;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class WarehouseParser {
    private static final char WALL_CHARACTER = '#';
    private static final char ROBOT_CHAR = '@';
    private static final char BOX_CHAR = 'O';
    private static final char EAST_CHAR = '>';
    private static final char WEST_CHAR = '<';
    private static final char NORTH_CHAR = '^';
    private static final char SOUTCH_CHAR = 'v';

    private WarehouseParser() {
    }

    public static ParsingTuple parseRobotAndWarehouseSimple(List<String> lines) {
        List<String> mapLines = lines.stream()
                .filter(line -> !line.isBlank() && line.charAt(0) == WALL_CHARACTER)
                .toList();

        Queue<Direction4> robotMoves = lines.stream()
                .filter(line -> !line.isBlank() && isAMoveInstruction(line.charAt(0)))
                .flatMap(line -> parseDirection(line).stream())
                .collect(Collectors.toCollection(LinkedList::new));

        Set<Box> boxes = new HashSet<>();
        Set<Wall> walls = new HashSet<>();
        AtomicReference<Position> robotPosition = new AtomicReference<>();

        IntStream.range(0, mapLines.size())
                .forEach(j -> IntStream.range(0, mapLines.getFirst().length())
                        .forEach(i -> {
                            if(mapLines.get(j).charAt(i) == WALL_CHARACTER) {
                                walls.add(new Wall(new Position(i, j), 1));
                            } else if (mapLines.get(j).charAt(i) == BOX_CHAR) {
                                boxes.add(new Box(new Position(i, j), 1));
                            } else if (mapLines.get(j).charAt(i) == ROBOT_CHAR) {
                                robotPosition.set(new Position(i, j));
                            }
                        }));

        Warehouse warehouse = new Warehouse(walls, boxes);

        return new ParsingTuple(new RobotInstructions(robotPosition.get(), robotMoves), warehouse);
    }

    public static ParsingTuple parseRobotAndWarehouseWide(List<String> lines) {
        List<String> mapLines = lines.stream()
                .filter(line -> !line.isBlank() && line.charAt(0) == WALL_CHARACTER)
                .toList();

        Queue<Direction4> robotMoves = lines.stream()
                .filter(line -> !line.isBlank() && isAMoveInstruction(line.charAt(0)))
                .flatMap(line -> parseDirection(line).stream())
                .collect(Collectors.toCollection(LinkedList::new));

        Set<Box> boxes = new HashSet<>();
        Set<Wall> walls = new HashSet<>();
        AtomicReference<Position> robotPosition = new AtomicReference<>();

        IntStream.range(0, mapLines.size())
                .forEach(j -> IntStream.range(0, mapLines.getFirst().length())
                        .forEach(i -> {
                            if(mapLines.get(j).charAt(i) == WALL_CHARACTER) {
                                walls.add(new Wall(new Position(2*i, j), 2));
                            } else if (mapLines.get(j).charAt(i) == BOX_CHAR) {
                                boxes.add(new Box(new Position(2*i, j), 2));
                            } else if (mapLines.get(j).charAt(i) == ROBOT_CHAR) {
                                robotPosition.set(new Position(2*i, j));
                            }
                        }));

        Warehouse warehouse = new Warehouse(walls, boxes);

        return new ParsingTuple(new RobotInstructions(robotPosition.get(), robotMoves), warehouse);
    }

    private static List<Direction4> parseDirection(String line) {
        return line.chars()
                .mapToObj(letter -> switch (letter) {
                    case EAST_CHAR -> Direction4.EAST;
                    case WEST_CHAR -> Direction4.WEST;
                    case NORTH_CHAR -> Direction4.NORTH;
                    case SOUTCH_CHAR -> Direction4.SOUTH;
                    default -> throw new IllegalArgumentException("Invalid value for move");
                })
                .toList();
    }

    private static boolean isAMoveInstruction(char firstLetter) {
        return EAST_CHAR == firstLetter
                || WEST_CHAR == firstLetter
                || NORTH_CHAR == firstLetter
                || SOUTCH_CHAR == firstLetter;
    }
}
