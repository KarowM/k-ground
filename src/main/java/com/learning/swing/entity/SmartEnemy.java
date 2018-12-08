package com.learning.swing.entity;

import com.learning.swing.utils.ID;

import java.awt.*;

public class SmartEnemy extends Entity {

    private static final int SIZE = 16;
    private final Player player;
    private EntityManager entityManager;

    SmartEnemy(double x, double y, ID id, EntityManager entityManager) {
        super(x, y, id);
        this.entityManager = entityManager;
        this.player = entityManager.getPlayer();
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, SIZE, SIZE);
    }

    public void tick() {
        x += velX;
        y += velY;

        double diffX = x - player.getX() - SIZE / 2.0;
        double diffY = y - player.getY() - SIZE / 2.0;

        double distance = Math.sqrt(Math.pow(x - player.getX(), 2) + Math.pow(y - player.getY(), 2));
        velX = ((-1.0 / distance) * diffX) * 2;
        velY = ((-1.0 / distance) * diffY) * 2;

        entityManager.addEntity(new Trail(x, y, ID.Trail, Color.BLUE, SIZE, SIZE, 0.05, entityManager));
    }

    public void render(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect((int) x, (int) y, SIZE, SIZE);
    }
}
