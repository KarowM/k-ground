package com.learning.swing.entity;

import com.learning.swing.Game;

import java.awt.*;
import java.util.Random;

public class BossEnemyBullet extends Entity {

    private EntityManager entityManager;
    private Random R = new Random();

    BossEnemyBullet(double x, double y, EntityManager entityManager) {
        super(x, y, 16, 16);
        this.entityManager = entityManager;

        velX = R.nextInt(5 + 1 + 5) - 5;
        velY = 5;
    }

    @Override
    public void collideWithPlayer(Player player, EntityManager entityManager) {
        player.decrementHealth();
    }

    public void tick() {
        x += velX;
        y += velY;

        if (y >= Game.HEIGHT || x >= Game.WIDTH) {
            entityManager.removeEntity(this);
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect((int) x, (int) y, width, height);
    }
}
