package com.jarus.pieces;

import com.jarus.utils.Images;

import java.awt.*;

public class Queen extends Piece{

    public Queen(boolean isWhite)
    {
        this.isWhite = isWhite;
    }

    @Override
    public void draw(Graphics g)
    {
        if (isWhite)
            g.drawImage(Images.whitePieces[1], 0, 0, null);
        else
            g.drawImage(Images.blackPieces[1], 0, 0, null);
    }

}
