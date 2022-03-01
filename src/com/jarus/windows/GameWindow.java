package com.jarus.windows;

import com.jarus.board.ChessBoard;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {

    private ChessBoard chessBoard;

    public GameWindow()
    {
        super("Grand Master");

        // Getting the Screen Size
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        double width = size.getWidth();
        double height = size.getHeight();

        // Creating ChessBoard JPanel and adding it to the JFrame
        chessBoard = new ChessBoard(new Dimension(480, 480));  // TODO Try it with 482 value later
        add(chessBoard, BorderLayout.CENTER);

        // Setting Window Properties
        setLocation((int) width / 2 - 300, (int) height / 2 - 200);   // TODO Set the proper location of the window
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        pack();
        repaint();

        setVisible(true);
    }

}
