package io.github.shadowchild.vdgame.states;


import com.shc.silenceengine.core.GameState;
import com.shc.silenceengine.core.SilenceEngine;
import com.shc.silenceengine.graphics.Batcher;
import com.shc.silenceengine.graphics.Graphics2D;
import com.shc.silenceengine.utils.Logger;
import io.github.shadowchild.vdgame.gui.Gui;
import io.github.shadowchild.vdgame.gui.GuiTitleScreen;

/**
 * Created by Zach Piddock on 28/10/2015.
 */
public class TitleScreenState extends GameState {

    private Gui gui;

    @Override
    public void onEnter() {

        Logger.info("Entered Title Screen");
        gui = new GuiTitleScreen();
    }

    @Override
    public void update(float delta) {

        gui.update(delta);
    }

    @Override
    public void render(float delta, Batcher batcher) {

        // Get the graphics
        Graphics2D graphics = SilenceEngine.graphics.getGraphics2D();

        // Ask the gui to do the drawing
        gui.render(graphics, batcher, delta);
    }

    @Override
    public void resize() {

    }

    @Override
    public void onLeave() {

    }
}
