package com.learning.swing.entity;

import com.learning.swing.Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Player extends Entity {
    public static final int HEALTH_MAX = 100;
    private double currentHealth = HEALTH_MAX;
    private Image imageInUse;
    private Image frozen;
    private Image normal;

    private int timeLeftFrozen = 0;

    public Player(double x, double y) {
        super(x, y, 83, 54);
        String path = new File("src/main/resources/spaceship.png").getAbsolutePath();
        try {
            normal = ImageIO.read(new File(path));
        } catch (IOException e) {
        }

        path = new File("src/main/resources/spaceshipFrozen.png").getAbsolutePath();
        try {
            frozen = ImageIO.read(new File(path));
        } catch (IOException e) {
        }

        imageInUse = normal;
    }

    @Override
    public void collideWithPlayer(Player player, EntityManager entityManager) {
        // intentionally empty
    }

    public void freeze() {
        timeLeftFrozen = 50;
    }

    public void tick() {
        currentHealth = Entity.clamp(currentHealth, 0, 100);

        if (timeLeftFrozen > 0) {
            timeLeftFrozen--;
        }

        if (timeLeftFrozen == 0) {
            x = clamp(x + velX, 0, Game.WIDTH - width);
            y = clamp(y + velY, 0, Game.HEIGHT - height);

            imageInUse = normal;
        } else {
            imageInUse = frozen;
        }
    }

    public void render(Graphics g) {
        g.drawImage(imageInUse, (int) x, (int) y, null);
    }

    public void decrementHealth() {
        currentHealth--;
    }

    public double getHealth() {
        return currentHealth;
    }

    public void incrementHealthBy(int health) {
        currentHealth = Entity.clamp(currentHealth + health, 0, 100);
    }
}
