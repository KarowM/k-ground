package com.learning.swing.entity;

import java.awt.*;

public class Trail extends Entity {

    private float alpha = 1;
    private Color color;
    private EntityManager entityManager;
    private double life;

    Trail(double x, double y, Color color, int width, int height, double life, EntityManager entityManager) {
        super(x, y, width, height);
        this.color = color;
        this.entityManager = entityManager;
        this.life = life;
    }

    public void tick() {
        if (alpha > life) {
            alpha -= (life - 0.0001f);
        } else {
            entityManager.removeEntity(this);
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

    @Override
    public void collideWithPlayer(Player player, EntityManager entityManager) {
        // intentionally empty
    }
}
