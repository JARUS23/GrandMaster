package com.jarus.pieces;

import com.jarus.utils.Images;

import java.awt.*;

public class Bishop extends Piece{

    public Bishop(boolean isWhite)
    {
        this.isWhite = isWhite;
    }

    @Override
    public void draw(Graphics g)
    {
        if (isWhite)
            g.drawImage(Images.whitePieces[4], 0, 0, null);
        else
            g.drawImage(Images.blackPieces[4], 0, 0, null);
    }

}
