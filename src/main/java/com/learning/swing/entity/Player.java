package com.learning.swing.entity;

import com.learning.swing.utils.ID;

import java.awt.*;
import java.util.Random;

public class Player extends GameObject {

    public Player(int x, int y, ID id) {
        super(x, y, id);
        setVelX(new Random().nextInt(5));
        setVelY(new Random().nextInt(5));
    }

    public void tick() {
        x += velX;
        y += velY;
    }

    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, 32, 32);
    }

}
