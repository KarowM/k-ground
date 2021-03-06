package com.learning.swing.entity;

import com.learning.swing.Game;
import com.learning.swing.graphics.HUD;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EntityManager {

    private static final Random R = new Random();

    private Player player;
    private List<Entity> entities;
    private HUD hud;
    private List<HealthPowerUp> powerUps;

    public EntityManager() {
        player = new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32);
        hud = new HUD(player);
        entities = new ArrayList<>();
        powerUps = new ArrayList<>();
    }

    public void tick() {
        player.tick();
        for (int i = 0; i < entities.size(); i++) {
            entities.get(i).tick();
        }
        checkForCollisions();

        hud.tick();
    }

    public void render(Graphics g) {
        player.render(g);
        for (int i = 0; i < entities.size(); i++) {
            entities.get(i).render(g);
        }

        hud.render(g);
        for (HealthPowerUp h : powerUps) {
            h.render(g);
        }
    }

    private void checkForCollisions() {
        for (int i = 0; i < entities.size(); i++) {
            if (player.getBounds().intersects(entities.get(i).getBounds())) {
                entities.get(i).collideWithPlayer(player, this);
            }
        }

        for (int i = 0; i < powerUps.size(); i++) {
            HealthPowerUp powerUp = powerUps.get(i);
            if (player.getBounds().intersects(powerUp.getBounds())) {
                player.incrementHealthBy(10);
                removePowerUp(powerUp);
            }
        }
    }

    private void removePowerUp(HealthPowerUp powerUp) {
        powerUps.remove(powerUp);
    }

    public void createNewBasicEnemy() {
        entities.add(new BasicEnemy(R.nextInt(Game.WIDTH), R.nextInt(Game.HEIGHT), this));
    }

    public Player getPlayer() {
        return player;
    }

    public void removeEntity(Entity entity) {
        entities.remove(entity);
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    public void createNewSmartEnemy() {
        entities.add(new SmartEnemy(R.nextInt(Game.WIDTH), R.nextInt(Game.HEIGHT), this));
    }

    public void createNewEnemyBoss() {
        entities.add(new BossEnemy((Game.WIDTH / 2) - BossEnemy.SIZE / 2, -BossEnemy.SIZE, this));
    }

    public void createNewBossEnemyBullet(double x, double y) {
        entities.add(new BossEnemyBullet(x, y, this));
    }

    public void createHealthPowerUp() {
        powerUps.add(new HealthPowerUp(Entity.clamp(R.nextInt(Game.WIDTH), 0, Game.WIDTH - HealthPowerUp.SIZE), Entity.clamp(R.nextInt(Game.HEIGHT), 0, Game.HEIGHT - HealthPowerUp.SIZE)));
    }

    public void clearAll() {
        entities.clear();
    }
}
