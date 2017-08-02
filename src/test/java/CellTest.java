package test.java;

import main.java.Cell;
import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CellTest {

    @Test
    public void cellEqualTest() {
        Cell cell = new Cell(1, 1);
        Cell anotherCell = new Cell(1, 1);
        assertEquals(cell, anotherCell);
    }

    @Test
    public void neighboursOfCellTest() {
        Cell cell = new Cell(1, 1);
        HashSet<Cell> neighbours = cell.neighbours();
        assertTrue(neighbours.contains(new Cell(0, 0)));
        assertTrue(neighbours.contains(new Cell(0, 1)));
        assertTrue(neighbours.contains(new Cell(0, 2)));
        assertTrue(neighbours.contains(new Cell(1, 0)));
        assertTrue(neighbours.contains(new Cell(1, 2)));
        assertTrue(neighbours.contains(new Cell(2, 0)));
        assertTrue(neighbours.contains(new Cell(2, 1)));
        assertTrue(neighbours.contains(new Cell(2, 2)));
    }
}
