package com.jarus.pieces;

import com.jarus.board.BoardState;
import com.jarus.utils.Images;
import com.jarus.utils.Location;

import java.awt.*;
import java.util.ArrayList;

public class Pawn extends Piece{

    private boolean doubleMove;

    public Pawn(boolean isWhite, Location location)
    {
        this.isWhite = isWhite;
        this.location = location;
    }

    @Override
    public void draw(Graphics g)
    {
        if (isWhite)
            g.drawImage(Images.whitePieces[5], 0, 0, null);
        else
            g.drawImage(Images.blackPieces[5], 0, 0, null);
    }

    @Override
    public ArrayList<Location> getMoves(BoardState boardState)
    {
        ArrayList<Location> allMoves = new ArrayList<Location>();

        // Getting x and y of the piece Bishop from board
        int x = location.getX();
        int y = location.getY();

        // All possible moves
        Location whiteOne = new Location(y - 1, x);
        Location whiteTwo = new Location(y - 2, x);
        Location whiteLeft = new Location(y - 1,x - 1);
        Location whiteRight = new Location(y - 1,x + 1);

        Location enPassantLeft = new Location(y,x - 1);
        Location enPassantRight = new Location(y,x + 1);

        Location blackOne = new Location(y + 1, x);
        Location blackTwo = new Location(y + 2, x);
        Location blackLeft = new Location(y + 1,x - 1);
        Location blackRight = new Location(y + 1,x + 1);

        if (isWhite)
        {
            // White Color Piece
            if(y != 0)
            {
                if(boardState.isValidSquare(whiteOne) && boardState.isEmptySquare(whiteOne))
                    allMoves.add(whiteOne);
                if(boardState.isValidSquare(whiteTwo) && location.getY() == 6 && boardState.isEmptySquare(whiteTwo)
                        && boardState.isEmptySquare(whiteOne))
                    allMoves.add(whiteTwo);
                if(boardState.isValidSquare(whiteLeft) && !boardState.isEmptySquare(whiteLeft) && !boardState.isWhitePiece(whiteLeft))
                    allMoves.add(whiteLeft);
                if(boardState.isValidSquare(whiteRight) && !boardState.isEmptySquare(whiteRight) && !boardState.isWhitePiece(whiteRight))
                    allMoves.add(whiteRight);
                if(boardState.isValidSquare(whiteRight) && boardState.isEmptySquare(whiteRight) && boardState.isValidSquare(enPassantRight)
                        && !boardState.isEmptySquare(enPassantRight) && !boardState.isWhitePiece(enPassantRight)
                        && boardState.getBoardState()[enPassantRight.getX()][enPassantRight.getY()] instanceof Pawn)
                    if(enPassantRight.getX() == 3 && ((Pawn)boardState.getBoardState()[enPassantRight.getX()][enPassantRight.getY()]).getDoubleMove())
                        allMoves.add(whiteRight);
                if(boardState.isValidSquare(whiteLeft) && boardState.isEmptySquare(whiteLeft) && boardState.isValidSquare(enPassantLeft)
                        && !boardState.isEmptySquare(enPassantLeft) && !boardState.isWhitePiece(enPassantLeft)
                        && boardState.getBoardState()[enPassantLeft.getX()][enPassantLeft.getY()] instanceof Pawn)
                    if(enPassantLeft.getX() == 3 && ((Pawn)boardState.getBoardState()[enPassantLeft.getX()][enPassantLeft.getY()]).getDoubleMove())
                        allMoves.add(whiteLeft);
            }
        }
        else
        {
            // Black Color Piece
            if(y != 7)
            {
                if(boardState.isValidSquare(blackOne) && boardState.isEmptySquare(blackOne))
                    allMoves.add(blackOne);
                if(boardState.isValidSquare(blackTwo) && location.getX() == 1 && boardState.isEmptySquare(blackTwo)
                        && boardState.isEmptySquare(blackOne))
                    allMoves.add(blackTwo);
                if(boardState.isValidSquare(blackLeft) && !boardState.isEmptySquare(blackLeft) && boardState.isWhitePiece(blackLeft))
                    allMoves.add(blackLeft);
                if(boardState.isValidSquare(blackRight) && !boardState.isEmptySquare(blackRight) && boardState.isWhitePiece(blackRight))
                    allMoves.add(blackRight);
                if(boardState.isValidSquare(blackRight) && boardState.isEmptySquare(blackRight) && boardState.isValidSquare(enPassantRight)
                        && !boardState.isEmptySquare(enPassantRight) && boardState.isWhitePiece(enPassantRight)
                        && boardState.getBoardState()[enPassantRight.getX()][enPassantRight.getY()] instanceof Pawn)
                    if(enPassantRight.getX() == 4 && ((Pawn)boardState.getBoardState()[enPassantRight.getX()][enPassantRight.getY()]).getDoubleMove())
                        allMoves.add(blackRight);
                if(boardState.isValidSquare(blackLeft) && boardState.isEmptySquare(blackLeft) && boardState.isValidSquare(enPassantLeft)
                        && !boardState.isEmptySquare(enPassantLeft) && boardState.isWhitePiece(enPassantLeft)
                        && boardState.getBoardState()[enPassantLeft.getX()][enPassantLeft.getY()] instanceof Pawn)
                    if(enPassantLeft.getX() == 4 && ((Pawn)boardState.getBoardState()[enPassantLeft.getX()][enPassantLeft.getY()]).getDoubleMove())
                        allMoves.add(blackLeft);
            }
        }

        return allMoves;
    }

    // GETTER
    public boolean getDoubleMove()
    {
        return doubleMove;
    }

    // SETTER
    public void setDoubleMove(boolean doubleMove)
    {
        this.doubleMove = doubleMove;
    }

}
