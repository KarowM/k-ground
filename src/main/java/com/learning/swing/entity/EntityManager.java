package com.learning.swing.entity;

import com.learning.swing.Game;
import com.learning.swing.graphics.HUD;
import com.learning.swing.utils.ID;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EntityManager {

    private static final Random R = new Random();

    private Player player;
    private List<Entity> entities;
    private HUD hud;

    public EntityManager(HUD hud) {
        this.hud = hud;
        entities = new ArrayList<Entity>();
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
    }

    private void checkForCollisions() {
        for (int i = 0; i < entities.size(); i++) {
            Entity entity = entities.get(i);

            if (entity.getId() == ID.SmartEnemy) {
                if (player.getBounds().intersects(entity.getBounds())) {
                    player.freeze();
                    removeEntity(entity);
                }
            } else if (entity.getId() != ID.Trail) {
                if (player.getBounds().intersects(entity.getBounds())) {
                    hud.decrementHealth();
                }
            }
        }
    }

    public void createPlayer() {
        this.player = new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player);
    }

    public void createNewBasicEnemy() {
        entities.add(new BasicEnemy(R.nextInt(Game.WIDTH), R.nextInt(Game.HEIGHT), ID.BasicEnemy, this));
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
        entities.add(new SmartEnemy(R.nextInt(Game.WIDTH), R.nextInt(Game.HEIGHT), ID.SmartEnemy, this));
    }

    public void createNewEnemyBoss() {
        entities.add(new BossEnemy((Game.WIDTH / 2) - BossEnemy.BOSS_SIZE / 2, -BossEnemy.BOSS_SIZE, ID.BossEnemy, this));
    }

    public void createNewBossEnemyBullet(double x, double y) {
        entities.add(new BossEnemyBullet((int) x, (int) y, ID.BasicEnemy, this));
    }

    public void clearAll() {
        entities.clear();
    }
}
