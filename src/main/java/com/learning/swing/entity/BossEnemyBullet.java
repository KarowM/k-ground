package com.learning.swing.entity;

import com.learning.swing.Game;
import com.learning.swing.utils.ID;

import java.awt.*;
import java.util.Random;

public class BossEnemyBullet extends Entity {

    private static final int SIZE = 16;
    private EntityManager entityManager;
    private Random R = new Random();

    BossEnemyBullet(int x, int y, ID id, EntityManager entityManager) {
        super(x, y, id);
        this.entityManager = entityManager;

        velX = R.nextInt(5 + 1 + 5) - 5;
        velY = 5;
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, SIZE, SIZE);
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
        g.fillRect((int) x, (int) y, SIZE, SIZE);
    }
}
