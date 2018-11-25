package com.learning.swing;

import com.learning.swing.entity.GameObject;
import com.learning.swing.entity.Player;
import com.learning.swing.entity.Spawner;
import com.learning.swing.graphics.HUD;
import com.learning.swing.utils.ID;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Handler {
    public List<GameObject> objects = new ArrayList<GameObject>();
    private Player player;
    private HUD hud;

    public void setSpawner(Spawner spawner) {
        this.spawner = spawner;

        spawner.createPlayer();
        spawner.createNewBasicEnemy();
    }

    private Spawner spawner;

    private int score = 0;
    private int level = 1;

    public Handler(HUD hud) {
        this.hud = hud;
    }

    public void tick() {
        score++;

        if (score % 100 == 0) {
            incrementLevel();

            spawner.createNewBasicEnemy();
        }

        player.tick();
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).tick();
        }

        checkForCollisions();

        hud.tick();
    }

    public void incrementLevel() {
        level++;
    }

    public void render(Graphics g) {
        player.render(g);
        for (int i = 0; i < objects.size(); i++) {
            GameObject tempObject = objects.get(i);

            tempObject.render(g);
        }

        hud.render(g, score, level);
    }

    private void checkForCollisions() {
        for (int i = 0; i < objects.size(); i++) {
            GameObject tempObj = objects.get(i);

            if (tempObj.getId() == ID.BasicEnemy) {
                if (player.getBounds().intersects(tempObj.getBounds())) {
                    HUD.currentHealth -= 1;
                }
            }
        }
    }

    public void addObject(GameObject object) {
        objects.add(object);
    }

    public void addPlayer(Player player) {
        this.player = player;
    }

    public void removeObject(GameObject object) {
        objects.remove(object);
    }

    public Player getPlayer() {
        return player;
    }
}
