package com.learning.swing.entity;

import com.learning.swing.Game;
import com.learning.swing.utils.ID;

import java.awt.*;

public class BasicEnemy extends Entity {

    public static final int ENEMY_SIZE = 16;
    private Spawner spawner;

    public BasicEnemy(int x, int y, ID id, Spawner spawner) {
        super(x, y, id);
        this.spawner = spawner;

        velX = 5;
        velY = 5;
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, ENEMY_SIZE, ENEMY_SIZE);
    }

    public void tick() {
        x = clamp(x + velX, 0, Game.WIDTH - ENEMY_SIZE);
        y = clamp(y + velY, 0, Game.HEIGHT - ENEMY_SIZE);

        if (y == 0 || y == Game.HEIGHT - ENEMY_SIZE) {
            velY *= -1;
        }
        if (x == 0 || x == Game.WIDTH - ENEMY_SIZE) {
            velX *= -1;
        }

        spawner.addObject(new Trail(x, y, ID.Trail, Color.RED, ENEMY_SIZE, ENEMY_SIZE, 0.05, spawner));
    }

    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect((int) x, (int) y, ENEMY_SIZE, ENEMY_SIZE);
    }
}
