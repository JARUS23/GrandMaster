package com.jarus.pieces;

import com.jarus.utils.Images;

import java.awt.*;

public class King extends Piece{

    public King(boolean isWhite)
    {
        this.isWhite = isWhite;
    }

    @Override
    public void draw(Graphics g)
    {
        if (isWhite)
            g.drawImage(Images.whitePieces[0], 0, 0, null);
        else
            g.drawImage(Images.blackPieces[0], 0, 0, null);
    }

}
