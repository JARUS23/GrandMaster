package com.jarus.windows;

import com.jarus.board.BoardState;
import com.jarus.board.ChessBoard;
import com.jarus.utils.Images;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {

    private BoardState boardState;
    private ChessBoard chessBoard;

    public GameWindow()
    {
        super("Grand Master");

        // Loading all Images
        Images.init();

        // Creating the state of our Chess Board
        boardState = new BoardState();

        // Creating ChessBoard JPanel and adding it to the JFrame
        chessBoard = new ChessBoard(boardState, new Dimension(480, 480));  // TODO Try it with 482 value later
        add(chessBoard, BorderLayout.CENTER);

        // Getting the Screen Size
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        double width = size.getWidth();
        double height = size.getHeight();

        // Setting Window Properties
        setLocation((int) width / 2 - 300, (int) height / 2 - 200);   // TODO Set the proper location of the window
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        pack();
        repaint();

        setVisible(true);
    }

}
