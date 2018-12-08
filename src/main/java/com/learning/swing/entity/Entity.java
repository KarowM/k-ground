package com.learning.swing.entity;

import java.awt.*;

public abstract class Entity {
    protected int width, height;
    protected double x, y;
    protected double velX, velY;

    public Entity(double x, double y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public static double clamp(double var, int min, int max) {
        if (var >= max) {
            return max;
        }
        if (var <= min) {
            return min;
        }
        return var;
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, width, height);
    }

    public abstract void tick();

    public abstract void render(Graphics g);

    public abstract void collideWithPlayer(Player player, EntityManager entityManager);

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setVelX(double velX) {
        this.velX = velX;
    }

    public void setVelY(int velY) {
        this.velY = velY;
    }
}
