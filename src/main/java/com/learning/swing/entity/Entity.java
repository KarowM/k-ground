package com.learning.swing.entity;

import java.awt.*;

public abstract class Entity {

    protected double x, y;
    protected double velX, velY;

    public Entity(double x, double y) {
        this.x = x;
        this.y = y;
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

    public abstract void tick();

    public abstract void render(Graphics g);

    public abstract Rectangle getBounds();

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
