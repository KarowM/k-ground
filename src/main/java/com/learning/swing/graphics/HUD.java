package com.learning.swing.graphics;

import com.learning.swing.entity.Entity;
import com.learning.swing.entity.Player;

import java.awt.*;

public class HUD {
    private int score = 0;
    private int level = 0;

    private double greenValue = 255;
    private Player player;

    public HUD(Player player) {
        this.player = player;
    }

    public void decrementHealth() {
        player.decrementHealth();
    }

    public void tick() {
        greenValue = Entity.clamp(player.getHealth() * 2, 0, 255);
        score++;
        level = level + (score % 100 == 0 ? 1 : 0);
    }

    public void render(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(15, 15, 2 * Player.HEALTH_MAX, 32);

        g.setColor(new Color(75, (int) greenValue, 0));
        g.fillRect(15, 15, (int) player.getHealth() * 2, 32);

        g.setColor(Color.WHITE);
        g.drawRect(15, 15, (int) player.getHealth() * 2, 32);

        g.drawString("Score: " + score, 10, 64);
        g.drawString("Level: " + level, 10, 80);
    }

    public void incrementHealthBy(int health) {
        player.incrementHealthBy(health);
    }
}
