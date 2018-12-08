package com.learning.swing.entity;

import java.awt.*;

public class SmartEnemy extends Entity {
    private final Player player;
    private EntityManager entityManager;

    SmartEnemy(double x, double y, EntityManager entityManager) {
        super(x, y, 16, 16);
        this.entityManager = entityManager;
        this.player = entityManager.getPlayer();
    }

    @Override
    public void collideWithPlayer(Player player, EntityManager entityManager) {
        player.freeze();
        entityManager.removeEntity(this);
    }

    public void tick() {
        x += velX;
        y += velY;

        double diffX = x - player.getX() - width / 2.0;
        double diffY = y - player.getY() - height / 2.0;

        double distance = Math.sqrt(Math.pow(x - player.getX(), 2) + Math.pow(y - player.getY(), 2));
        velX = ((-1.0 / distance) * diffX) * 2;
        velY = ((-1.0 / distance) * diffY) * 2;

        entityManager.addEntity(new Trail(x, y, Color.BLUE, width, height, 0.05, entityManager));
    }

    public void render(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect((int) x, (int) y, width, height);
    }
}
