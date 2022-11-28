package com.kerrrusha.chessboard.model;

import java.util.Objects;

public class Coordinate {

    public int x;
    public int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setValue(Coordinate other) {
        this.x = other.x;
        this.y = other.y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordinate that)) return false;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
