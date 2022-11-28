package com.kerrrusha.chessboard.analyzer;

import com.kerrrusha.chessboard.model.ChessBoard;
import com.kerrrusha.chessboard.model.chesspiece.ChessPiece;

import java.util.Collection;
import java.util.Optional;

import static java.util.stream.Collectors.toSet;

public class ChessBoardAnalyzer {

    private final ChessBoard chessBoard;

    public ChessBoardAnalyzer(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }

    public Collection<UnderAttackResult> getChessPiecesUnderAttack() {
        return chessBoard.getChessPieces().stream()
                .map(this::findPossibleAttack)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(toSet());
    }

    private Optional<UnderAttackResult> findPossibleAttack(ChessPiece chessPiece) {

    }
}
