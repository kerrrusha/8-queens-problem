package com.kerrrusha.chessboard.model;

import com.kerrrusha.chessboard.analyzer.ChessBoardAnalyzer;
import com.kerrrusha.chessboard.analyzer.UnderAttackResult;
import com.kerrrusha.chessboard.factory.ChessPieceFactory;
import com.kerrrusha.chessboard.model.chesspiece.ChessPiece;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;

public class ChessBoardAnalyzerTest {

    @Test
    public void getChessPiecesUnderAttackTest() {
        final Collection<ChessPiece> chessPieces = Arrays.asList(
                ChessPieceFactory.createQueen(1, 1),
                ChessPieceFactory.createQueen(5, 1),
                ChessPieceFactory.createQueen(3, 3),
                ChessPieceFactory.createQueen(0, 4),
                ChessPieceFactory.createQueen(7, 6)
        );

        ChessBoard board = new ChessBoard();
        chessPieces.forEach(board::addChessPiece);

        ChessBoardAnalyzer analyzer = new ChessBoardAnalyzer(board);
        Collection<UnderAttackResult> results = analyzer.getChessPiecesUnderAttack();

        System.out.println(board);
        System.out.println("There are " + results.size() + " attack possibilities.");
    }
}
