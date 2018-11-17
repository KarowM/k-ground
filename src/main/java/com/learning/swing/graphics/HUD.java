package com.learning.swing.graphics;

import java.awt.*;

public class HUD {
    public static int health = 100;

    public void tick() {
        health--;
    }
    public void render(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(15, 15, 200, 32);

        g.setColor(Color.GREEN);
        g.fillRect(15, 15, health * 2, 32);

        g.setColor(Color.WHITE);
        g.drawRect(15, 15, health * 2, 32);
    }
}
