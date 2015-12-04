package io.github.shadowchild.vdgame.states;


import com.shc.silenceengine.core.Display;
import com.shc.silenceengine.core.GameState;
import com.shc.silenceengine.core.SilenceEngine;
import com.shc.silenceengine.graphics.Batcher;
import com.shc.silenceengine.graphics.Color;
import com.shc.silenceengine.graphics.Graphics2D;
import com.shc.silenceengine.graphics.Paint;
import com.shc.silenceengine.math.Vector2;
import com.shc.silenceengine.utils.Logger;

/**
 * Created by Zach Piddock on 28/10/2015.
 */
public class TitleScreenState extends GameState {

    @Override
    public void onEnter() {

        Logger.info("Entered Title Screen");
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void render(float delta, Batcher batcher) {

        // Get the graphics
        Graphics2D graphics = SilenceEngine.graphics.getGraphics2D();

        // Draw the background
        graphics.setPaint(new Paint(Color.AZURE));
        graphics.fillRect(new Vector2(0, 0), Display.getWidth(), Display.getHeight());

        // draw the logo

        // draw the buttons
    }

    @Override
    public void resize() {

    }

    @Override
    public void onLeave() {

    }
}
