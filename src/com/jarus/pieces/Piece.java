package com.jarus.pieces;

import com.jarus.board.BoardState;
import com.jarus.utils.Location;

import java.awt.*;
import java.util.ArrayList;

public abstract class Piece {

    protected boolean isWhite;
    protected Location location;

    public abstract void draw(Graphics g);
    public abstract ArrayList<Location> getMoves(BoardState boardState);

    // GETTER
    public boolean isWhite()
    {
        return isWhite;
    }
}
