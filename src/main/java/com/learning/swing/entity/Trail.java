package com.learning.swing.entity;

import com.learning.swing.utils.ID;

import java.awt.*;

public class Trail extends Entity {

    private float alpha = 1;
    private Color color;
    private Spawner spawner;
    private int width, height;
    private double life;

    Trail(double x, double y, ID id, Color color, int width, int height, double life, Spawner spawner) {
        super(x, y, id);
        this.color = color;
        this.spawner = spawner;
        this.width = width;
        this.height = height;
        this.life = life;
    }

    public void tick() {
        if (alpha > life) {
            alpha -= (life - 0.0001f);
        } else {
            spawner.removeEntity(this);
        }
    }

    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setComposite(makeTransparent(alpha));

        g.setColor(color);
        g.fillRect((int) x, (int) y, width, height);

        g2d.setComposite(makeTransparent(1));
    }

    private AlphaComposite makeTransparent(float alpha) {
        int type = AlphaComposite.SRC_OVER;
        return (AlphaComposite.getInstance(type, alpha));
    }

    public Rectangle getBounds() {
        return null;
    }
}
