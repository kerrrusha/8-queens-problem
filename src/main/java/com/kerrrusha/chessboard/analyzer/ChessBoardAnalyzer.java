package com.kerrrusha.chessboard.analyzer;

import com.kerrrusha.chessboard.model.ChessBoard;
import com.kerrrusha.chessboard.model.Coordinate;
import com.kerrrusha.chessboard.model.chesspiece.ChessPiece;

import java.util.Collection;

import static java.util.stream.Collectors.toSet;

public class ChessBoardAnalyzer {

    private final ChessBoard chessBoard;

    public ChessBoardAnalyzer(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }

    public Collection<UnderAttackResult> getChessPiecesUnderAttack() {
        return chessBoard.getChessPieces().stream()
                .map(this::findPossibleAttack)
                .flatMap(Collection::stream)
                .collect(toSet());
    }

    public boolean isInSafe(ChessPiece chessPiece) {
        return findPossibleAttack(chessPiece).isEmpty();
    }

    private Collection<UnderAttackResult> findPossibleAttack(ChessPiece chessPiece) {
        return chessBoard.getChessPieces().stream()
                .filter(elem -> !elem.equals(chessPiece))
                .filter(elem -> elementsAreOnTheAttackLine(elem, chessPiece))
                .filter(elem -> elementsAreUnderAttack(elem, chessPiece))
                .map(elem -> mapToUnderAttackResult(elem, chessPiece))
                .collect(toSet());
    }

    private boolean elementsAreOnTheAttackLine(ChessPiece queen1, ChessPiece queen2) {
        return queen1.getCoords().x == queen2.getCoords().x ||
                queen1.getCoords().y == queen2.getCoords().y ||
                queen1.getCoords().x + queen1.getCoords().y == queen2.getCoords().x + queen2.getCoords().y ||
                queen1.getCoords().x - queen1.getCoords().y == queen2.getCoords().x - queen2.getCoords().y;
    }

    private boolean elementsAreUnderAttack(ChessPiece queen1, ChessPiece queen2) {
        return thereAreNoAnyChessBetween(queen1.getCoords(), queen2.getCoords());
    }

    private boolean thereAreNoAnyChessBetween(Coordinate from, Coordinate to) {
        final int deltaX = sign(to.x - from.x);
        final int deltaY = sign(to.y - from.y);
        final Coordinate testCell = new Coordinate(from);

        for (int testAttempt = 0; testAttempt < getTestAttempts(from, to); testAttempt++) {
            testCell.x += deltaX;
            testCell.y += deltaY;
            if (!chessBoard.cellIsEmpty(testCell)) {
                return false;
            }
        }
        return true;
    }

    private int getTestAttempts(Coordinate from, Coordinate to) {
        return Math.abs(Math.max(to.x - from.x, to.y - from.y)) - 1;
    }

    private int sign(int n) {
        if (n == 0) {
            return 0;
        }
        return n / Math.abs(n);
    }

    private UnderAttackResult mapToUnderAttackResult(ChessPiece underAttack, ChessPiece isAttacking) {
        UnderAttackResult result = new UnderAttackResult();
        result.setIsAttacking(isAttacking);
        result.setUnderAttack(underAttack);
        return result;
    }
}
