import javax.swing.*;
import java.awt.*;

public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = 190065682132863975L;

    private static final int WIDTH = 640, HEIGHT = WIDTH / 9 * 16;
    private Thread thread;
    private boolean running = false;

    public Game() {
        new Window(WIDTH, HEIGHT, "Lets build a game!", this);
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

    }

    public static void main(String[] args) {
        new Game();
    }
}
