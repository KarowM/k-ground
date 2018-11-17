package com.learning.swing.entity;

import com.learning.swing.Game;
import com.learning.swing.utils.ID;

import java.awt.*;

public class Player extends GameObject {

    public static final int PLAYER_SIZE = 32;

    public Player(int x, int y, ID id) {
        super(x, y, id);
    }

    public void tick() {
        x = clamp(x + velX, 0, Game.WIDTH - PLAYER_SIZE);
        y = clamp(y + velY, 0, Game.HEIGHT - PLAYER_SIZE);
    }

    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, PLAYER_SIZE, PLAYER_SIZE);
    }

    private static int clamp(int var, int min, int max) {
        if (var >= max) {
            return max;
        }
        if (var <= min) {
            return min;
        }
        return var;
    }
}
