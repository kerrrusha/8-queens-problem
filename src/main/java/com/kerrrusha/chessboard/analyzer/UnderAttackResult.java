package com.kerrrusha.chessboard.analyzer;

import com.kerrrusha.chessboard.model.chesspiece.ChessPiece;

public class UnderAttackResult {

    private ChessPiece isAttacking;
    private ChessPiece underAttack;


    public ChessPiece getIsAttacking() {
        return isAttacking;
    }

    public void setIsAttacking(ChessPiece isAttacking) {
        this.isAttacking = isAttacking;
    }

    public ChessPiece getUnderAttack() {
        return underAttack;
    }

    public void setUnderAttack(ChessPiece underAttack) {
        this.underAttack = underAttack;
    }
}
