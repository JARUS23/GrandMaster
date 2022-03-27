package com.jarus.pieces;

import com.jarus.board.BoardState;
import com.jarus.utils.Images;
import com.jarus.utils.Location;

import java.awt.*;
import java.util.ArrayList;

public class Knight extends Piece{

    public Knight(boolean isWhite, Location location)
    {
        this.isWhite = isWhite;
        this.location = location;
    }

    @Override
    public void draw(Graphics g)
    {
        if (isWhite)
            g.drawImage(Images.whitePieces[3], 0, 0, null);
        else
            g.drawImage(Images.blackPieces[3], 0, 0, null);
    }

    @Override
    public ArrayList<Location> getMoves(BoardState boardState)
    {
        ArrayList<Location> allMoves = new ArrayList<Location>();

        // Getting x and y of the piece Knight from board
        int x = location.getX();
        int y = location.getY();

        // All possible 8 moves of the knight
        Location locs[] = new Location[8];
        locs[0] = new Location(x + 2, y - 1);
        locs[1] = new Location(x + 2, y + 1);
        locs[2] = new Location(x - 2, y - 1);
        locs[3] = new Location(x - 2, y + 1);
        locs[4] = new Location(x - 1, y - 2);
        locs[5] = new Location(x - 1, y + 2);
        locs[6] = new Location(x + 1, y - 2);
        locs[7] = new Location(x + 1, y + 2);

        if (isWhite)
        {
            // White color piece
            for (Location loc: locs)
                if (boardState.isValidSquare(loc) && (boardState.isEmptySquare(loc) || !boardState.isWhitePiece(loc)))
                    allMoves.add(loc);
        }
        else
        {
            // Black color piece
            for (Location loc: locs)
                if (boardState.isValidSquare(loc) && (boardState.isEmptySquare(loc) || boardState.isWhitePiece(loc)))
                    allMoves.add(loc);
        }

        return allMoves;
    }

}
