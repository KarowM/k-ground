package com.learning.swing.entity;

import com.learning.swing.Game;
import com.learning.swing.utils.ID;

import java.awt.*;

public class BasicEnemy extends GameObject {

    public static final int ENEMY_SIZE = 16;

    public BasicEnemy(int x, int y, ID id) {
        super(x, y, id);

        velX = 5;
        velY = 5;
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
    }

    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, ENEMY_SIZE, ENEMY_SIZE);
    }
}
