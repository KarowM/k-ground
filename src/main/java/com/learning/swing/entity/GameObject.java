package com.learning.swing.entity;

import com.learning.swing.utils.ID;

import java.awt.*;

public abstract class GameObject {

    protected double x, y;
    protected double velX, velY;
    protected ID id;

    public GameObject(double x, double y, ID id) {
        this.x = x;
        this.y = y;
        this.id = id;
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

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getVelX() {
        return velX;
    }

    public void setVelX(double velX) {
        this.velX = velX;
    }

    public double getVelY() {
        return velY;
    }

    public void setVelY(int velY) {
        this.velY = velY;
    }

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public void goUp() {
        y--;
    }
}
