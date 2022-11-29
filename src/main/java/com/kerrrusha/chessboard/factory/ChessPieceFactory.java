package com.kerrrusha.chessboard.factory;

import com.kerrrusha.chessboard.model.Coordinate;
import com.kerrrusha.chessboard.model.chesspiece.ChessPiece;
import com.kerrrusha.chessboard.model.chesspiece.Queen;

public class ChessPieceFactory {

    public static Queen getInstance(int x, int y) {
        return new Queen(new Coordinate(x, y));
    }

    public static ChessPiece getCopy(ChessPiece other) {
        return new Queen(other.getCoords());
    }
}
