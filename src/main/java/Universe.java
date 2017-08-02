package main.java;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Universe {
    private final Set<Cell> aliveCells;

    public Universe(final Set<Cell> aliveCells) {
        this.aliveCells = aliveCells;
    }

    public boolean isEmpty() {
        return aliveCells.size() == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Universe universe = (Universe) o;
        return Objects.equals(aliveCells, universe.aliveCells);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aliveCells);
    }

    public Universe nextGeneration() {
        Set<Cell> aliveCells = this.aliveCells.stream()
                .filter(this::canAlive)
                .collect(Collectors.toSet());

        Set<Cell> bornCells = this.aliveCells.stream()
                .flatMap(this::bornCells)
                .collect(Collectors.toSet());
        aliveCells.addAll(bornCells);
        return new Universe(aliveCells);
    }

    private Stream<Cell> bornCells(Cell cell) {
        return cell.neighbours()
                .stream()
                .filter(x -> isInUniverseRange(x))
                .filter(x -> canBorn(x));
    }

    private boolean isInUniverseRange(Cell x) {
        return (x.getX() >= 0 && x.getX() <= 2 && x.getY() <= 2 && x.getY() >= 0);
    }

    private boolean canBorn(Cell cell) {
        long neighbourCount = neighbourCount(cell);
        return (neighbourCount == 3);
    }

    private boolean canAlive(Cell cell) {
        long neighbourCount = neighbourCount(cell);
        return (neighbourCount == 2 || neighbourCount == 3);
    }

    private long neighbourCount(Cell cell) {
        Set<Cell> neighbours = cell.neighbours();
        neighbours.retainAll(aliveCells);
        return neighbours.size();
    }
}
