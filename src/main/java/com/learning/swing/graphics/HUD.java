package com.learning.swing.graphics;

import com.learning.swing.entity.GameObject;

import java.awt.*;

public class HUD {
    public static final int HEALTH_MAX = 100;
    public static int currentHealth = HEALTH_MAX;

    public void tick() {
        //currentHealth--;

        currentHealth = GameObject.clamp(currentHealth, 0, 100);
    }

    public void render(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(15, 15, 2*HEALTH_MAX, 32);

        g.setColor(Color.GREEN);
        g.fillRect(15, 15, currentHealth * 2, 32);

        g.setColor(Color.WHITE);
        g.drawRect(15, 15, currentHealth * 2, 32);
    }
}
