package com.kerrrusha.chessboard.factory;

import com.kerrrusha.chessboard.model.Coordinate;
import com.kerrrusha.chessboard.model.chesspiece.Queen;

public class ChessPieceFactory {

    public static Queen createQueen(int x, int y) {
        return new Queen(new Coordinate(x, y));
    }
}
