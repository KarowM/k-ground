package com.learning.swing.entity;

import com.learning.swing.Game;
import com.learning.swing.utils.ID;

import java.awt.*;

public class BasicEnemy extends Entity {

    private static final int SIZE = 16;
    private EntityManager entityManager;

    BasicEnemy(double x, double y, ID id, EntityManager entityManager) {
        super(x, y, id);
        this.entityManager = entityManager;

        velX = 5;
        velY = 5;
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, SIZE, SIZE);
    }

    public void tick() {
        x = clamp(x + velX, 0, Game.WIDTH - SIZE);
        y = clamp(y + velY, 0, Game.HEIGHT - SIZE);

        if (y == 0 || y == Game.HEIGHT - SIZE) {
            velY *= -1;
        }
        if (x == 0 || x == Game.WIDTH - SIZE) {
            velX *= -1;
        }

        entityManager.addEntity(new Trail(x, y, ID.Trail, Color.YELLOW, SIZE, SIZE, 0.05, entityManager));
    }

    public void render(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillRect((int) x, (int) y, SIZE, SIZE);
    }
}
