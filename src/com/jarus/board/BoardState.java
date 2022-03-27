package com.jarus.board;

import com.jarus.pieces.*;
import com.jarus.utils.Location;

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
                        boardState[i][j] = new Rook(false, new Location(i, j));
                    else if (j == 1 || j == 6)
                        boardState[i][j] = new Knight(false, new Location(i, j));
                    else if (j == 2 || j == 5)
                        boardState[i][j] = new Bishop(false, new Location(i, j));
                    else if (j == 3)
                        boardState[i][j] = new Queen(false, new Location(i, j));
                    else
                        boardState[i][j] = new King(false, new Location(i, j));
                }
                else if (i == 1)
                    boardState[i][j] = new Pawn(false, new Location(i, j));
                else if (i == 6)
                    boardState[i][j] = new Pawn(true, new Location(i, j));
                else if (i == 7)
                {
                    if (j == 0 || j == 7)
                        boardState[i][j] = new Rook(true, new Location(i, j));
                    else if (j == 1 || j == 6)
                        boardState[i][j] = new Knight(true, new Location(i, j));
                    else if (j == 2 || j == 5)
                        boardState[i][j] = new Bishop(true, new Location(i, j));
                    else if (j == 3)
                        boardState[i][j] = new Queen(true, new Location(i, j));
                    else
                        boardState[i][j] = new King(true, new Location(i, j));
                }
            }
        }
    }

    // Checking if the square is valid or not
    public boolean isValidSquare(Location location)
    {
        if ((location.getX() < boardState.length && location.getX() >= 0) &&
                (location.getY() < boardState.length && location.getY() >= 0))
            return true;
        return false;
    }

    // Checking if the square is empty or not
    public boolean isEmptySquare(Location location)
    {
        if (!isValidSquare(location))
            return false;
        if (boardState[location.getX()][location.getY()] == null)
            return true;
        return false;
    }

    // Checking the color of the piece if it's not empty
    public boolean isWhitePiece(Location location)
    {
        if (boardState[location.getX()][location.getY()].isWhite())
            return true;
        return false;
    }

    // GETTER
    public Piece[][] getBoardState()
    {
        return boardState;
    }
}
