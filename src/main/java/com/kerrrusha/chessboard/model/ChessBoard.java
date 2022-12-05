package com.kerrrusha.chessboard.model;

import com.kerrrusha.chessboard.model.chesspiece.ChessPiece;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import org.apache.log4j.Logger;

import static com.kerrrusha.chessboard.model.PseudographicSymbol.EMPTY_CELL_SYMBOL;

public class ChessBoard {

    private static final Logger logger = Logger.getLogger(ChessBoard.class);

    private final int SIZE = 8;

    private final Collection<ChessPiece> chessPieces;

    public ChessBoard() {
        chessPieces = new HashSet<>();
    }

    public void addChessPiece(ChessPiece chessPiece) {
        if (!canAddSuchChessPiece(chessPiece)) {
            logger.warn("Can't add chesspiece "+chessPiece+" to the board - it's full, cell isn't empty or the chesspiece has invalid coords.");
            return;
        }
        chessPieces.add(chessPiece);
    }

    private boolean canAddSuchChessPiece(ChessPiece chessPiece) {
        return chessPieceCoordsIsCorrect(chessPiece) && cellIsEmpty(chessPiece.getCoords()) && !isFull();
    }

    private boolean chessPieceCoordsIsCorrect(ChessPiece chessPiece) {
        return chessPiece.getCoords().x >= 0 && chessPiece.getCoords().x < SIZE &&
                chessPiece.getCoords().y >= 0 && chessPiece.getCoords().y < SIZE;
    }

    public void removeChessPiece(ChessPiece chessPiece) {
        if (!contains(chessPiece)) {
            logger.warn("There are such chesspiece: "+chessPiece);
            return;
        }
        chessPieces.remove(chessPiece);
    }

    private boolean contains(ChessPiece chessPiece) {
        return chessPieces.contains(chessPiece);
    }

    public Collection<ChessPiece> getChessPieces() {
        return chessPieces;
    }

    public int getSize() {
        return SIZE;
    }

    public int getCurrentChessCount() {
        return chessPieces.size();
    }

    private boolean isFull() {
        return getCurrentChessCount() >= SIZE*SIZE;
    }

    public boolean cellIsEmpty(Coordinate coords) {
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

    public int[] getState() {
        Collection<Integer> rows = new ArrayList<>();
        getChessPieces().stream()
                .sorted(Comparator.comparingInt(p -> p.getCoords().x))
                .forEach(chessPiece -> rows.add(chessPiece.getCoords().y));
        final int freeCols = 8 - rows.size();
        for (int i = 0; i < freeCols; i++) {
            rows.add(0);
        }
        return rows.stream().mapToInt(x -> x).toArray();
    }
}
