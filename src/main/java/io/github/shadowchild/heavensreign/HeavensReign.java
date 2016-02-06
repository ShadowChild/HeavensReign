package io.github.shadowchild.heavensreign;


import com.shc.silenceengine.backend.lwjgl3.opengl.GL3Context;
import com.shc.silenceengine.core.Display;
import com.shc.silenceengine.core.Game;
import com.shc.silenceengine.core.GameLoop;
import com.shc.silenceengine.core.GameState;
import com.shc.silenceengine.core.SilenceEngine;
import com.shc.silenceengine.core.SilenceException;
import com.shc.silenceengine.graphics.Graphics2D;
import com.shc.silenceengine.utils.GameTimer;
import com.shc.silenceengine.utils.Logger;
import com.shc.silenceengine.utils.TimeUtils;
import io.github.shadowchild.cybernize.util.Utils;
import io.github.shadowchild.heavensreign.game.HRGame;
import io.github.shadowchild.heavensreign.handler.ConfigurationHandler;
import org.lwjgl.system.Configuration;

/**
 * Created by Zach Piddock on 27/10/2015.
 */
public class HeavensReign extends Game {

    static boolean hasTestCase = false;
    static String testCaseClass = "";

    public static void main(String... args) {

        handleRuntime(args);
        // This is a temporary fix and will be removed once LWJGL fixes this
        if(SilenceEngine.getPlatform() == SilenceEngine.Platform.LINUX_64 || SilenceEngine.getPlatform() == SilenceEngine.Platform.WINDOWS_64)
            Configuration.LIBRARY_NAME_JEMALLOC.set("jemalloc");

        Utils.initialise();
        ConfigurationHandler.handle();

        new HRGame().start(new HRGameLoop());
    }

    private static void handleRuntime(String... args) {

        if(args.length > 0) {

            for(int i = 0; i < args.length; i++) {

                switch(args[i]) {

                    case "--testCase": {

                        hasTestCase = true;
                        testCaseClass = args[i + 1];
                        break;
                    }

                    default: break;
                }
            }
        }
    }

    public static GameState getTestCase() {

        if(!testCaseClass.isEmpty()) {

            try {

                Class clazz = Class.forName(testCaseClass);

                Object obj = clazz.newInstance();
                if(!(obj instanceof GameState)) {

                    return null;
                } else return (GameState)obj;
            } catch(ClassNotFoundException | InstantiationException | IllegalAccessException e) {

                e.printStackTrace();
            }
        }

        return null;
    }

    static class HRGameLoop extends GameLoop {

        // GameLoop constants
        private final double SECOND = TimeUtils.convert(1, TimeUtils.Unit.SECONDS,
                TimeUtils.getDefaultTimeUnit()
        );

        private int updatesProcessed;
        private int framesProcessed;
        private int skippedFrames;
        private int maxSkippedFrames;
        private int targetUps;

        private double currentTime;
        private double previousTime;

        private double lag;

        private double lastUPSUpdate;
        private double lastFPSUpdate;
        private double frameTime;

        private boolean stopQuitsJVM;
        private boolean paused;

        public HRGameLoop() {

            setTargetUpdatesPerSecond(60);
            setMaxSkippedFrames(5);
            setStopQuitsJVM(true);
        }

        public HRGameLoop setMaxSkippedFrames(int maxSkippedFrames) {

            this.maxSkippedFrames = maxSkippedFrames;
            return this;
        }

        public HRGameLoop setStopQuitsJVM(boolean stopQuitsJVM) {

            this.stopQuitsJVM = stopQuitsJVM;
            return this;
        }

        @Override
        public void start() {

            if(running) throw new SilenceException("Game loop is already running.");

            running = true;

            // Initialize the Game
            Logger.info("Initializing the Game resources");
            game.init();
            Runtime.getRuntime().gc();
            Logger.info("Game initialized successfully, proceeding to the main loop");

            previousTime = TimeUtils.currentTime();

            running = true;

            // The Game Loop
            loop:
            while(true) {

                // Start a frame in the game loop
                SilenceEngine.getInstance().beginFrame();

                if(Display.isCloseRequested()) {

                    stop();
                    break;
                }

                if(!isRunning()) break;

                if(Display.wasResized()) {

                    GL3Context.viewport(0, 0, Display.getWidth(), Display.getHeight());
                    Graphics2D.getInstance()
                            .getCamera()
                            .initProjection(Display.getWidth(), Display.getHeight());
                    game.resize();

                    if(Game.getGameState() != null) Game.getGameState().resize();
                }

                currentTime = TimeUtils.currentTime();
                double elapsed = currentTime - previousTime;

                lag += elapsed;

                while(lag > frameTime && skippedFrames < maxSkippedFrames) {

                    if(Display.wasDirty()) {

                        // End the old frame and start a new frame
                        SilenceEngine.getInstance().endFrame();
                        SilenceEngine.getInstance().beginFrame();
                    }

                    // Input needs to be updated even faster!
                    SilenceEngine.input.beginFrame();
                    {
                        if(!paused) {
                            game.update((float)frameTime);

                            if(Game.getGameState() != null) {

                                Game.getGameState().update((float)frameTime);
                            }
                        }

                        if(!isRunning()) break loop;

                        GameTimer.updateTimers((float)frameTime);
                    }
                    SilenceEngine.input.endFrame();

                    updatesProcessed++;
                    lag -= frameTime;

                    skippedFrames++;

                    if(currentTime - lastUPSUpdate >= SECOND) {
                        ups = updatesProcessed;
                        updatesProcessed = 0;
                        lastUPSUpdate = currentTime;
                    }
                }

                float lagOffset = (float)(lag / frameTime);
                game.render(lagOffset, SilenceEngine.graphics.getBatcher());

                if(Game.getGameState() != null) {

                    Game.getGameState().render(lagOffset, SilenceEngine.graphics.getBatcher());
                }

                if(!isRunning()) break;

                framesProcessed++;

                if(currentTime - lastFPSUpdate >= SECOND) {

                    fps = framesProcessed;
                    framesProcessed = 0;
                    lastFPSUpdate = currentTime;
                }

                SilenceEngine.getInstance().endFrame();

                skippedFrames = 0;

                previousTime = currentTime;
            }

            stop();
        }

        @Override
        public void pause() {

            paused = true;
        }

        @Override
        public void resume() {

            currentTime = previousTime = TimeUtils.currentTime();
            paused = false;
        }

        @Override
        public void stop() {

            Logger.info("Disposing the Game resources");

            game.dispose();
            SilenceEngine.getInstance().dispose();

            Logger.info("This game has been terminated successfully");

            running = false;

            if(stopQuitsJVM) System.exit(0);
        }

        public int getTargetUpdatesPerSecond() {

            return targetUps;
        }

        public HRGameLoop setTargetUpdatesPerSecond(int targetUps) {

            this.targetUps = targetUps;
            this.frameTime = SECOND / targetUps;

            return this;
        }
    }
}
