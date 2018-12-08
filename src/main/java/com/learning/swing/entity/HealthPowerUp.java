package com.learning.swing.entity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class HealthPowerUp {

    public static final int SIZE = 35;
    private double x;
    private double y;

    private Image img;

    HealthPowerUp(double x, double y) {
        this.x = x;
        this.y = y;

        String path = new File("src/main/resources/heart.png").getAbsolutePath();

        try {
            img = ImageIO.read(new File(path));
        } catch (IOException e) {}
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, SIZE, SIZE);
    }

    public void render(Graphics g) {
        g.drawImage(img, (int) x, (int) y, null);
    }
}
