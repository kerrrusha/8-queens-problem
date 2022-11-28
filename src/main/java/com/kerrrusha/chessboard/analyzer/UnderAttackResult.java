package com.kerrrusha.chessboard.analyzer;

import com.kerrrusha.chessboard.model.chesspiece.ChessPiece;

import java.util.Objects;

public class UnderAttackResult {

    private ChessPiece isAttacking;
    private ChessPiece underAttack;


    public void setIsAttacking(ChessPiece isAttacking) {
        this.isAttacking = isAttacking;
    }
    public void setUnderAttack(ChessPiece underAttack) {
        this.underAttack = underAttack;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UnderAttackResult that)) return false;
        return Objects.equals(isAttacking, that.isAttacking) && Objects.equals(underAttack, that.underAttack);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isAttacking, underAttack);
    }
}
