package com.kerrrusha.chessboard.analyzer;

import com.kerrrusha.chessboard.model.ChessBoard;
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
                .filter(elem -> elementsAreUnderAttack(elem, chessPiece))
                .map(elem -> mapToUnderAttackResult(elem, chessPiece))
                .collect(toSet());
    }

    private boolean elementsAreUnderAttack(ChessPiece queen1, ChessPiece queen2) {
        return queen1.getCoords().x == queen2.getCoords().x ||
                queen1.getCoords().y == queen2.getCoords().y ||
                queen1.getCoords().x + queen1.getCoords().y == queen2.getCoords().x + queen2.getCoords().y ||
                queen1.getCoords().x - queen1.getCoords().y == queen2.getCoords().x - queen2.getCoords().y;
    }

    private UnderAttackResult mapToUnderAttackResult(ChessPiece underAttack, ChessPiece isAttacking) {
        UnderAttackResult result = new UnderAttackResult();
        result.setIsAttacking(isAttacking);
        result.setUnderAttack(underAttack);
        return result;
    }
}
