package com.learning.swing.entity;

import com.learning.swing.Game;
import com.learning.swing.graphics.HUD;
import com.learning.swing.utils.ID;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Spawner {

    private static final Random R = new Random();

    private Player player;
    private List<Entity> objects;
    private HUD hud;

    public Spawner(HUD hud) {
        this.hud = hud;
        objects = new ArrayList<Entity>();
    }

    public void tick() {
        player.tick();
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).tick();
        }
        checkForCollisions();
    }

    public void render(Graphics g) {
        player.render(g);
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).render(g);
        }
    }

    private void checkForCollisions() {
        for (int i = 0; i < objects.size(); i++) {
            Entity tempObj = objects.get(i);

            if (tempObj.getId() == ID.SmartEnemy) {
                if (player.getBounds().intersects(tempObj.getBounds())) {
                    player.freeze();
                    removeObject(tempObj);
                }
            } else if (tempObj.getId() != ID.Trail) {
                if (player.getBounds().intersects(tempObj.getBounds())) {
                    hud.decerementHealth();
                }
            }
        }
    }

    public void createPlayer() {
        this.player = new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player);
    }

    public void createNewBasicEnemy() {
        objects.add(new BasicEnemy(R.nextInt(Game.WIDTH), R.nextInt(Game.HEIGHT), ID.BasicEnemy, this));
    }

    public Player getPlayer() {
        return player;
    }

    public void removeObject(Entity object) {
        objects.remove(object);
    }

    public void addObject(Entity object) {
        objects.add(object);
    }

    public void createNewSmartEnemy() {
        objects.add(new SmartEnemy(R.nextInt(Game.WIDTH), R.nextInt(Game.HEIGHT), ID.SmartEnemy, this));
    }

    public void createNewEnemyBoss() {
        objects.add(new BossEnemy((Game.WIDTH / 2) - BossEnemy.BOSS_SIZE / 2, -BossEnemy.BOSS_SIZE, ID.BossEnemy, this));
    }

    public void createNewBossEnemyBullet(double x, double y) {
        objects.add(new BossEnemyBullet((int) x, (int) y, ID.BasicEnemy, this));
    }

    public void clearAll() {
        objects.clear();
    }
}
