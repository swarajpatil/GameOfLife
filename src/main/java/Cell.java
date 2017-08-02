package main.java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;

public class Cell {
    private final int x;
    private final int y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return x == cell.x &&
                y == cell.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public HashSet<Cell> neighbours() {
        return new HashSet<Cell>(Arrays.asList(new Cell(x + 1, y + 1)
                , new Cell(x - 1, y - 1)
                , new Cell(x + 1, y - 1)
                , new Cell(x - 1, y + 1)
                , new Cell(x + 1, y)
                , new Cell(x, y + 1)
                , new Cell(x - 1, y)
                , new Cell(x, y - 1)));
    }
}
