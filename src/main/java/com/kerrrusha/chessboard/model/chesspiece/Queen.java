package com.kerrrusha.chessboard.model.chesspiece;

import com.kerrrusha.chessboard.model.Coordinate;

import static com.kerrrusha.chessboard.model.PseudographicSymbol.QUEEN_SYMBOL;

public class Queen extends ChessPiece {

    public Queen(Coordinate coords) {
        super(coords);
    }

    @Override
    public String toString() {
        return QUEEN_SYMBOL;
    }
}
