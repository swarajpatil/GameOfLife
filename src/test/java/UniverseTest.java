package test.java;

import main.java.Cell;
import main.java.Universe;
import org.junit.Test;

import java.util.HashSet;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class UniverseTest {

    @Test
    public void universeIsEmptyWhenNoAliveCells() {
        Universe universe = new Universe(new HashSet<>());
        assertTrue(universe.isEmpty());
    }

    @Test
    public void nextGenerationOfEmptyUniverseIsEmpty() {
        Universe universe = new Universe(new HashSet<>());

        Universe actualUniverse = universe.nextGeneration();

        assertEquals(true, actualUniverse.isEmpty());
    }

    @Test
    public void cellWithLessThanTwoNeighboursShouldDie() {
        HashSet<Cell> cells = new HashSet<>();
        cells.add(new Cell(1, 1));
        cells.add(new Cell(2, 2));
        Universe universe = new Universe(cells);

        Universe actualUniverse = universe.nextGeneration();

        assertTrue(actualUniverse.isEmpty());
    }

    @Test
    public void cellWithTwoOrThreeNeighboursShouldAlive() {
        HashSet<Cell> cells = new HashSet<>();
        cells.add(new Cell(1, 0));
        cells.add(new Cell(1, 1));
        cells.add(new Cell(2, 1));
        cells.add(new Cell(2, 2));
        Universe universe = new Universe(cells);

        Universe actualUniverse = universe.nextGeneration();

        HashSet<Cell> nextGenerationcells = new HashSet<>();
        nextGenerationcells.add(new Cell(1, 0));
        nextGenerationcells.add(new Cell(1, 1));
        nextGenerationcells.add(new Cell(1, 2));
        nextGenerationcells.add(new Cell(2, 1));
        nextGenerationcells.add(new Cell(2, 2));
        nextGenerationcells.add(new Cell(2, 0));
        Universe expectedUniverse = new Universe(nextGenerationcells);

        assertEquals(expectedUniverse, actualUniverse);
    }

    @Test
    public void cellWithMoreThanThreeNeighboursShouldDie() {
        HashSet<Cell> cells = new HashSet<>();
        cells.add(new Cell(0, 0));
        cells.add(new Cell(0, 1));
        cells.add(new Cell(0, 2));
        cells.add(new Cell(1, 0));
        cells.add(new Cell(1, 1));
        cells.add(new Cell(1, 2));
        cells.add(new Cell(2, 0));
        cells.add(new Cell(2, 1));
        cells.add(new Cell(2, 2));
        Universe universe = new Universe(cells);

        Universe actualUniverse = universe.nextGeneration();

        HashSet<Cell> nextGenerationcells = new HashSet<>();
        nextGenerationcells.add(new Cell(0, 0));
        nextGenerationcells.add(new Cell(0, 2));
        nextGenerationcells.add(new Cell(2, 0));
        nextGenerationcells.add(new Cell(2, 2));
        Universe expectedUniverse = new Universe(nextGenerationcells);

        assertEquals(expectedUniverse, actualUniverse);
    }

    @Test
    public void deadCellWithExactThreeNeighboursShouldBeAlive() {
        HashSet<Cell> cells = new HashSet<>();
        cells.add(new Cell(0, 0));
        cells.add(new Cell(1, 0));
        cells.add(new Cell(1, 1));
        Universe universe = new Universe(cells);

        HashSet<Cell> expectedcells = new HashSet<>();
        expectedcells.add(new Cell(0, 0));
        expectedcells.add(new Cell(0, 1));
        expectedcells.add(new Cell(1, 0));
        expectedcells.add(new Cell(1, 1));
        Universe expectedUniverse = new Universe(expectedcells);

        Universe actualUniverse = universe.nextGeneration();

        assertEquals(expectedUniverse, actualUniverse);
    }
}
