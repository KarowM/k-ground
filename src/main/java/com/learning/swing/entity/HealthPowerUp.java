package com.learning.swing.entity;

import java.awt.*;

public class HealthPowerUp {

    private static final int SIZE = 12;
    private double x;
    private double y;

    HealthPowerUp(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, SIZE, SIZE);
    }

    public void render(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect((int) x, (int) y, SIZE, SIZE);
    }
}
