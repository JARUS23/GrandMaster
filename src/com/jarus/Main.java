package com.jarus;

import com.jarus.windows.GameWindow;

import javax.swing.*;

public class Main {

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GameWindow();
            }
        });
    }

}