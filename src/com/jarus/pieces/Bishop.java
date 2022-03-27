package com.jarus.pieces;

import com.jarus.board.BoardState;
import com.jarus.utils.Images;
import com.jarus.utils.Location;

import java.awt.*;
import java.util.ArrayList;

public class Bishop extends Piece{

    public Bishop(boolean isWhite, Location location)
    {
        this.isWhite = isWhite;
        this.location = location;
    }

    @Override
    public void draw(Graphics g)
    {
        if (isWhite)
            g.drawImage(Images.whitePieces[4], 0, 0, null);
        else
            g.drawImage(Images.blackPieces[4], 0, 0, null);
    }

    @Override
    public ArrayList<Location> getMoves(BoardState boardState)
    {
        ArrayList<Location> allMoves = new ArrayList<Location>();

        // Getting x and y of the piece Bishop from board
        int x = location.getX();
        int y = location.getY();

        // All possible moves
        boolean[] isRowBlocked = new boolean[4];
        Location[] locs = new Location[32];

        for (int z = 1; z <= 32; z++)
        {
            if(z <= 8)
                locs[z - 1] = new Location(y - z%8, x-z%8);
            else if(z <= 16)
                locs[z - 1] = new Location(y - z%8, x + z%8);
            else if(z <= 24)
                locs[z - 1] = new Location(y + z%8, x + z%8);
            else
                locs[z - 1] = new Location(y + z%8, x - z%8);
        }

        if (isWhite)
        {
            // White Color Piece
            for (int i = 0; i < locs.length; i++)
                if(boardState.isValidSquare(locs[i]) && !isRowBlocked[i/8] && (boardState.isEmptySquare(locs[i]) || !boardState.isWhitePiece(locs[i])))
                {
                    allMoves.add(locs[i]);
                    if(!boardState.isEmptySquare(locs[i]) && !boardState.isWhitePiece(locs[i]))
                        isRowBlocked[i/8] = true;
                }
                else
                    isRowBlocked[i/8] = true;
        }
        else
        {
            // Black Color Piece
            for (int i = 0; i < locs.length; i++)
                if(boardState.isValidSquare(locs[i]) && !isRowBlocked[i/8] && (boardState.isEmptySquare(locs[i]) || boardState.isWhitePiece(locs[i])))
                {
                    allMoves.add(locs[i]);
                    if(!boardState.isEmptySquare(locs[i]) && boardState.isWhitePiece(locs[i]))
                        isRowBlocked[i/8] = true;
                }
                else
                    isRowBlocked[i/8] = true;
        }

        return allMoves;
    }

}
