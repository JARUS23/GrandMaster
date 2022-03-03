package com.jarus.pieces;

import com.jarus.utils.Images;

import java.awt.*;

public class Rook extends Piece{

    public Rook(boolean isWhite)
    {
        this.isWhite = isWhite;
    }

    @Override
    public void draw(Graphics g)
    {
        if (isWhite)
            g.drawImage(Images.whitePieces[2], 0, 0, null);
        else
            g.drawImage(Images.blackPieces[2], 0, 0, null);
    }

}
