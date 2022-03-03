package com.jarus.pieces;

import com.jarus.utils.Images;

import java.awt.*;

public class Pawn extends Piece{

    public Pawn(boolean isWhite)
    {
        this.isWhite = isWhite;
    }

    @Override
    public void draw(Graphics g)
    {
        if (isWhite)
            g.drawImage(Images.whitePieces[5], 0, 0, null);
        else
            g.drawImage(Images.blackPieces[5], 0, 0, null);
    }

}
