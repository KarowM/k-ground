package com.learning.swing.graphics;

import com.learning.swing.Game;
import com.learning.swing.entity.GameObject;

import java.awt.*;

public class HUD {
    public static final int HEALTH_MAX = 100;
    public static int health = HEALTH_MAX;

    public void tick() {
        health--;

        health = GameObject.clamp(health, 0, 100);
    }

    public void render(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(15, 15, 2*HEALTH_MAX, 32);

        g.setColor(Color.GREEN);
        g.fillRect(15, 15, health * 2, 32);

        g.setColor(Color.WHITE);
        g.drawRect(15, 15, health * 2, 32);
    }
}
