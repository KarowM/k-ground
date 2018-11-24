package com.learning.swing.entity;

import com.learning.swing.Game;
import com.learning.swing.Handler;
import com.learning.swing.utils.ID;

import java.awt.*;

public class BasicEnemy extends GameObject {

    public static final int ENEMY_SIZE = 16;
    private Handler handler;

    public BasicEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

        velX = 5;
        velY = 5;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, ENEMY_SIZE, ENEMY_SIZE);
    }

    public void tick() {
        x += velX;
        y += velY;

        if (y <= 0 || y > Game.HEIGHT - ENEMY_SIZE) {
            velY *= -1;
        }
        if (x <= 0 || x > Game.WIDTH - ENEMY_SIZE) {
            velX *= -1;
        }

        handler.addObject(new Trail(x, y, ID.Trail, Color.RED, ENEMY_SIZE, ENEMY_SIZE, 0.05, handler));
    }

    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, ENEMY_SIZE, ENEMY_SIZE);
    }
}
