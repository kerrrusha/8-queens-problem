package com.kerrrusha.chessboard.model;

import com.kerrrusha.chessboard.model.chesspiece.ChessPiece;

import java.util.Collection;
import java.util.HashSet;
import org.apache.log4j.Logger;

import static com.kerrrusha.chessboard.model.PseudographicSymbol.EMPTY_CELL_SYMBOL;

public class ChessBoard {

    private static final Logger logger = Logger.getLogger(ChessBoard.class);;

    private final int SIZE = 8;

    private final Collection<ChessPiece> chessPieces;

    public ChessBoard() {
        chessPieces = new HashSet<>();
    }

    public void addChessPiece(ChessPiece chessPiece) {
        if (isFull() || !cellIsEmpty(chessPiece.getCoords())) {
            logger.warn("Can't add chesspiece "+chessPiece+" to the board - it's full or the cell isn't empty.");
            return;
        }
        chessPieces.add(chessPiece);
    }

    public Collection<ChessPiece> getChessPieces() {
        return chessPieces;
    }

    private boolean isFull() {
        return chessPieces.size() >= SIZE*SIZE;
    }

    private boolean cellIsEmpty(Coordinate coords) {
        return chessPieces.stream().noneMatch(chessPiece -> chessPiece.getCoords().equals(coords));
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        drawRawBoard(result);
        drawChessPieces(result);

        return result.toString();
    }

    private void drawRawBoard(StringBuilder result) {
        for (int i = 0; i < SIZE; i++) {
            result.append(EMPTY_CELL_SYMBOL.repeat(SIZE)).append(System.lineSeparator());
        }
    }

    private void drawChessPieces(StringBuilder result) {
        chessPieces.forEach(chessPiece -> {
            int startPos = getChessPieceStringStartPos(chessPiece);
            result.replace(startPos, startPos + EMPTY_CELL_SYMBOL.length(), chessPiece.toString());
        });
    }

    private int getChessPieceStringStartPos(ChessPiece chessPiece) {
        return SIZE * EMPTY_CELL_SYMBOL.length() * chessPiece.getCoords().y
                + chessPiece.getCoords().y * System.lineSeparator().length()
                + chessPiece.getCoords().x * EMPTY_CELL_SYMBOL.length();
    }
}
