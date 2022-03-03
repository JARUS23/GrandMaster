package com.jarus.board;

import javax.swing.*;
import java.awt.*;

public class ChessBoard extends JPanel {

    private Square squares[][];
    private Color white, black;

    public ChessBoard(BoardState boardState, Dimension size)
    {
        super(new GridLayout(8, 8));

        // Setting the colors for white and black
        white = new Color(243,210,165);
        black = new Color(201,116,59);

        // Setting the properties of the ChessBoard JPanel
        setOpaque(true);
        setBackground(black);
        setPreferredSize(size);

        // Creating the square array and instantiating the square
        squares = new Square[8][8];
        for (int i = 0; i < squares.length; i++)
            for (int j = 0; j < squares.length; j++)
            {
                squares[i][j] = new Square(boardState, i, j);
                squares[i][j].setBorder(null);  // TODO Try different Borders
            }

        // Adding the squares on the JPanel
        for (int i = 0; i < squares.length; i++)
            for (int j = 0; j < squares.length; j++)
                add(squares[i][j]);

        // Setting the background color of the squares
        resetSquareBackground();
    }

    private void resetSquareBackground()
    {
        for (int i = 0; i < squares.length; i++)
            for (int j = 0; j < squares.length; j++)
            {
                if (i % 2 == 0)
                    if (j % 2 == 0)
                        squares[i][j].setBackground(white);
                    else
                        squares[i][j].setBackground(black);
                else
                    if (j % 2 == 0)
                        squares[i][j].setBackground(black);
                    else
                        squares[i][j].setBackground(white);
            }

        repaint();
    }

}
