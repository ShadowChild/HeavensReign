package io.github.shadowchild.vdgame;


import com.shc.silenceengine.core.Display;
import com.shc.silenceengine.core.Game;
import com.shc.silenceengine.core.SilenceEngine;
import com.shc.silenceengine.core.gameloops.FixedCatchingUpGameLoop;
import com.shc.silenceengine.graphics.Batcher;
import com.shc.silenceengine.input.Keyboard;
import io.github.shadowchild.common.util.Utils;
import io.github.shadowchild.vdgame.handler.ConfigurationHandler;
import io.github.shadowchild.vdgame.states.TitleScreenState;
import io.github.shadowchild.vdgame.utils.Settings;

/**
 * Created by Zach Piddock on 27/10/2015.
 */
public class Main extends Game {

    public static final int HEIGHT = 768;
    public static final int WIDTH = (HEIGHT * 16) / 9;

    // Initialise this before so that the start method wont resize the display
    public void preInit() {

        Display.setSize(WIDTH, HEIGHT);
        Display.setResizable(false);
        Display.setFullScreen(Settings.fullscreen);
    }

    // Initialize the resources
    public void init() {

        // set the game state
        setGameState(new TitleScreenState());

        // post initialisation
//        Display.getWindow().setKeyCallback(InputHandler::keyCallback);
//        Display.getWindow().setCursorPositionCallback(InputHandler::cursorPosCallback);
//        Display.getWindow().setMouseButtonCallback(InputHandler::mouseInputCallback);
    }

    // Update game logic
    public void update(float delta) {

        if(Keyboard.isClicked(Keyboard.KEY_ESCAPE)) {

            // TODO: Add a confirmation dialog
            disposeSafely();
        }

        Display.setTitle("UPS: " + Game.getUPS() +
                " | FPS: " + Game.getFPS() +
                " | RC: " + SilenceEngine.graphics.renderCallsPerFrame);
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

        Utils.initialise();
        ConfigurationHandler.handle();

        new Main().start(
                new FixedCatchingUpGameLoop().setTargetUpdatesPerSecond(60).setMaxSkippedFrames(5));
    }

    public void disposeSafely() {

        Game.end();
    }
}
