package com.learning.swing.graphics;

import com.learning.swing.Game;

import javax.swing.*;
import java.awt.*;

public class Window extends Canvas {
    private static final long serialVersionUID = -5641828237808928700L;

    public Window(int height, int width, String title, Game game) {
        JFrame frame = new JFrame(title);

        frame.setUndecorated(true);
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.pack();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);
        game.start();
    }
}
