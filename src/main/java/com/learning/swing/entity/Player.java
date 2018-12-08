package com.learning.swing.entity;

import com.learning.swing.Game;
import com.learning.swing.utils.ID;

import java.awt.*;

public class Player extends Entity {
    public static final int HEALTH_MAX = 100;
    private double currentHealth = HEALTH_MAX;

    public static final int PLAYER_SIZE = 32;
    private int timeLeftFrozen = 0;

    public Player(double x, double y, ID id) {
        super(x, y, id);
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 32, 32);
    }

    public void freeze() {
        timeLeftFrozen = 50;
    }

    public void tick() {
        currentHealth = Entity.clamp(currentHealth, 0, 100);

        if (timeLeftFrozen > 0) {
            timeLeftFrozen--;
        }

        if (timeLeftFrozen == 0) {
            x = clamp(x + velX, 0, Game.WIDTH - PLAYER_SIZE);
            y = clamp(y + velY, 0, Game.HEIGHT - PLAYER_SIZE);
        }
    }

    public void render(Graphics g) {
        Color color = timeLeftFrozen > 0 ? Color.CYAN : Color.WHITE;
        g.setColor(color);
        g.fillRect((int) x, (int) y, PLAYER_SIZE, PLAYER_SIZE);
    }

    public void decrementHealth() {
        currentHealth--;
    }

    public double getHealth() {
        return currentHealth;
    }

    public void incrementHealthBy(int health) {
        currentHealth = Entity.clamp(currentHealth + health, 0, 100);
    }
}
