package com.learning.swing.entity;

import com.learning.swing.Game;

import java.awt.*;

public class BasicEnemy extends Entity {
    private EntityManager entityManager;

    BasicEnemy(double x, double y, EntityManager entityManager) {
        super(x, y, 16, 16);
        this.entityManager = entityManager;

        velX = 5;
        velY = 5;
    }

    @Override
    public void collideWithPlayer(Player player, EntityManager entityManager) {
        player.decrementHealth();
    }

    public void tick() {
        x = clamp(x + velX, 0, Game.WIDTH - width);
        y = clamp(y + velY, 0, Game.HEIGHT - height);

        if (y == 0 || y == Game.HEIGHT - height) {
            velY *= -1;
        }
        if (x == 0 || x == Game.WIDTH - width) {
            velX *= -1;
        }

        entityManager.addEntity(new Trail(x, y, Color.YELLOW, width, height, 0.05, entityManager));
    }

    public void render(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillRect((int) x, (int) y, width, height);
    }
}
