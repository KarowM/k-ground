package com.learning.swing.graphics;

import com.learning.swing.entity.GameObject;

import java.awt.*;

public class HUD {
    private final int HEALTH_MAX = 100;
    private double currentHealth = HEALTH_MAX;

    private double greenValue = 255;

    public void decerementHealth() {
        currentHealth--;
    }

    public void tick() {
        currentHealth = GameObject.clamp(currentHealth, 0, 100);
        greenValue = GameObject.clamp(currentHealth * 2, 0, 255);
    }

    public void render(Graphics g, int score, int level) {
        g.setColor(Color.GRAY);
        g.fillRect(15, 15, 2 * HEALTH_MAX, 32);

        g.setColor(new Color(75, (int) greenValue, 0));
        g.fillRect(15, 15, (int) currentHealth * 2, 32);

        g.setColor(Color.WHITE);
        g.drawRect(15, 15, (int) currentHealth * 2, 32);

        g.drawString("Score: " + score, 10, 64);
        g.drawString("Level: " + level, 10, 80);
    }
}
