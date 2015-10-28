package io.github.shadowchild.vdgame;

import com.shc.silenceengine.core.Display;
import com.shc.silenceengine.core.Game;
import com.shc.silenceengine.graphics.Batcher;

/**
 * Created by Zach Piddock on 27/10/2015.
 */
public class Main extends Game {

    public static final int HEIGHT = 1080;
    public static final int WIDTH = (HEIGHT * 16) / 9;

    // Initialise this before so that the start method wont resize the display
    public void preInit() {
        
        // Display.setTitle("Ashleigh's Valentines Day Game");
        Display.setSize(WIDTH, HEIGHT);
        Display.setFullScreen(true);
    }

    // Initialize the resources
    public void init() {

    }

    // Update game logic
    public void update(float delta) {

    }

    // Render to screen
    public void render(float delta, Batcher batcher) {

    }

    // Handle window resize event
    public void resize() {

    }

    // Dispose the resources
    public void dispose() {

    }

    public static void main(String... args) {

        new Main().start();
    }
}
