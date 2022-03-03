package com.jarus.utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Images {

    public static BufferedImage whitePieces[];
    public static BufferedImage blackPieces[];

    // Cannot Instantiate Image class
    private Images()
    { }

    // Loads the image of all pieces
    public static void init()
    {
        whitePieces = new BufferedImage[8];
        blackPieces = new BufferedImage[8];

        /*
            Index of each Piece
            0 = King
            1 = Queen
            2 = Rook
            3 = Knight
            4 = Bishop
            5 = Pawn
         */

        try
        {
            whitePieces[0] = ImageIO.read(new File("res/White_King.png"));
            whitePieces[1] = ImageIO.read(new File("res/White_Queen.png"));
            whitePieces[2] = ImageIO.read(new File("res/White_Rook.png"));
            whitePieces[3] = ImageIO.read(new File("res/White_Knight.png"));
            whitePieces[4] = ImageIO.read(new File("res/White_Bishop.png"));
            whitePieces[5] = ImageIO.read(new File("res/White_Pawn.png"));

            blackPieces[0] = ImageIO.read(new File("res/Black_King.png"));
            blackPieces[1] = ImageIO.read(new File("res/Black_Queen.png"));
            blackPieces[2] = ImageIO.read(new File("res/Black_Rook.png"));
            blackPieces[3] = ImageIO.read(new File("res/Black_Knight.png"));
            blackPieces[4] = ImageIO.read(new File("res/Black_Bishop.png"));
            blackPieces[5] = ImageIO.read(new File("res/Black_Pawn.png"));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
