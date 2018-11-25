package com.learning.swing;

import com.learning.swing.entity.BasicEnemy;
import com.learning.swing.entity.Player;
import com.learning.swing.entity.Spawner;
import com.learning.swing.graphics.HUD;
import com.learning.swing.graphics.Window;
import com.learning.swing.input.KeyInput;
import com.learning.swing.utils.ID;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = 190065682132863975L;

    public static final int WIDTH = 1024, HEIGHT = 576;
    private Thread thread;
    private boolean running = false;
    private Handler handler;
    private Spawner spawner;

    Random r = new Random();

    public Game() {
        HUD hud = new HUD();
        handler = new Handler(hud);
        spawner = new Spawner(handler);
        handler.setSpawner(spawner);

        handler.addPlayer(new Player(WIDTH / 2 - 32, HEIGHT / 2 - 32, ID.Player));
        handler.addObject(new BasicEnemy(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.BasicEnemy, handler));

        this.addKeyListener(new KeyInput(handler));

        new Window(HEIGHT, WIDTH, "Lets build a game!", this);
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        this.requestFocus(); // key board works without clicking on it
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running) {
                render();
            }
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    private void tick() {
        handler.tick();
        spawner.tick();
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        handler.render(g);

        g.dispose();
        bs.show();
    }

    public static void main(String[] args) {
        new Game();
    }
}
