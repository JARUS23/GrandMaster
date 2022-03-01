package com.jarus.board;

import com.jarus.pieces.Piece;

public class BoardState {

    private Piece boardState[][];
    private boolean isWhiteTurn;

    public BoardState()
    {
        boardState = new Piece[8][8];
        isWhiteTurn = true;
    }
}
