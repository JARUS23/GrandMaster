package com.jarus.board;

import com.jarus.utils.Images;

import javax.swing.*;
import java.awt.*;

public class Square extends JButton {

    private BoardState boardState;
    private int i, j;

    public Square(BoardState boardState, int corX, int corY)
    {
        this.boardState = boardState;
        i = corX;
        j = corY;
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        if (boardState.getBoardState()[i][j] != null)
            boardState.getBoardState()[i][j].draw(g);
    }

    // GETTER
    public int getI()
    {
        return i;
    }

    // GETTER
    public int getJ()
    {
        return j;
    }
}
