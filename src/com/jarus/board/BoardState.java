package com.jarus.board;

import com.jarus.pieces.*;

public class BoardState {

    private Piece boardState[][];
    private boolean isWhiteTurn;

    public BoardState()
    {
        boardState = new Piece[8][8];
        isWhiteTurn = true;

        addPiecesToBoardState();
    }

    // Adding the pieces to the Board State
    private void addPiecesToBoardState()
    {
        for (int i = 0; i < boardState.length; i++)
        {
            for (int j = 0; j < boardState.length; j++)
            {
                if (i == 0)
                {
                    if (j == 0 || j == 7)
                        boardState[i][j] = new Rook(false);
                    else if (j == 1 || j == 6)
                        boardState[i][j] = new Knight(false);
                    else if (j == 2 || j == 5)
                        boardState[i][j] = new Bishop(false);
                    else if (j == 3)
                        boardState[i][j] = new Queen(false);
                    else
                        boardState[i][j] = new King(false);
                }
                else if (i == 1)
                    boardState[i][j] = new Pawn(false);
                else if (i == 6)
                    boardState[i][j] = new Pawn(true);
                else if (i == 7)
                {
                    if (j == 0 || j == 7)
                        boardState[i][j] = new Rook(true);
                    else if (j == 1 || j == 6)
                        boardState[i][j] = new Knight(true);
                    else if (j == 2 || j == 5)
                        boardState[i][j] = new Bishop(true);
                    else if (j == 3)
                        boardState[i][j] = new Queen(true);
                    else
                        boardState[i][j] = new King(true);
                }
            }
        }
    }

    // GETTER
    public Piece[][] getBoardState()
    {
        return boardState;
    }
}
