package com.kerrrusha.chessboard.model.chesspiece;

import com.kerrrusha.chessboard.model.Coordinate;

public abstract class ChessPiece {

    private Coordinate coords;

    public ChessPiece(Coordinate coords) {
        this.coords = coords;
    }

    public Coordinate getCoords() {
        return coords;
    }

    public void setCoords(Coordinate coords) {
        this.coords.setValue(coords);
    }

    @Override
    public abstract String toString();
}
