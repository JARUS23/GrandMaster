package com.jarus.pieces;

import com.jarus.board.BoardState;
import com.jarus.utils.Images;
import com.jarus.utils.Location;

import java.awt.*;
import java.util.ArrayList;

public class King extends Piece{

    public King(boolean isWhite, Location location)
    {
        this.isWhite = isWhite;
        this.location = location;
    }

    @Override
    public void draw(Graphics g)
    {
        if (isWhite)
            g.drawImage(Images.whitePieces[0], 0, 0, null);
        else
            g.drawImage(Images.blackPieces[0], 0, 0, null);
    }

    @Override
    public ArrayList<Location> getMoves(BoardState boardState)
    {
        ArrayList<Location> allMoves = new ArrayList<Location>();

        // Getting x and y of the piece Bishop from board
        int x = location.getX();
        int y = location.getY();

        // All possible moves
        Location[] locs = new Location[10];

        locs[0] = new Location(y - 1,x - 1);
        locs[1] = new Location(y - 1, x);
        locs[2] = new Location(y - 1,x + 1);
        locs[3] = new Location(y,x - 1);
        locs[4] = new Location(y,x + 1);
        locs[5] = new Location(y + 1,x + 1);
        locs[6] = new Location(y + 1, x);
        locs[7] = new Location(y + 1,x - 1);

        locs[8] = new Location(y,x - 2);
        locs[9] = new Location(y,x + 2);

        for(Location z: locs)
            if(boardState.isValidSquare(z) && (boardState.isEmptySquare(z) || boardState.isWhitePiece(z) != isWhite))
                allMoves.add(z);

        return allMoves;
    }

}
