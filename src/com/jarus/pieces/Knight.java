package com.jarus.pieces;

import com.jarus.utils.Images;

import java.awt.*;

public class Knight extends Piece{

    public Knight(boolean isWhite)
    {
        this.isWhite = isWhite;
    }

    @Override
    public void draw(Graphics g)
    {
        if (isWhite)
            g.drawImage(Images.whitePieces[3], 0, 0, null);
        else
            g.drawImage(Images.blackPieces[3], 0, 0, null);
    }

}
