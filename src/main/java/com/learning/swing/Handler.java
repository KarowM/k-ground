package com.learning.swing;

import com.learning.swing.entity.GameObject;
import com.learning.swing.entity.Player;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Handler {
    public List<GameObject> objects = new ArrayList<GameObject>();
    private Player player;

    public void tick() {
        player.tick();
        int size = objects.size();
        for (int i = 0; i < size; i++) {
            objects.get(i).tick();
        }
    }

    public void render(Graphics g) {
        player.render(g);
        for (int i = 0; i < objects.size(); i++) {
            GameObject tempObject = objects.get(i);

            tempObject.render(g);
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
