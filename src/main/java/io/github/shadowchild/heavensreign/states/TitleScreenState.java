package io.github.shadowchild.heavensreign.states;


import com.shc.silenceengine.core.Game;
import com.shc.silenceengine.core.SilenceEngine;
import com.shc.silenceengine.graphics.Batcher;
import com.shc.silenceengine.graphics.Graphics2D;
import com.shc.silenceengine.input.Keyboard;
import com.shc.silenceengine.utils.Logger;
import io.github.shadowchild.heavensreign.gui.screen.Gui;
import io.github.shadowchild.heavensreign.gui.screen.GuiTitleScreen;

/**
 * Created by Zach Piddock on 28/10/2015.
 */
public class TitleScreenState extends PauseableState {

    private Gui gui;

    @Override
    public void onEnter() {

        Logger.info("Entered Title Screen");
        gui = new GuiTitleScreen();
    }

    @Override
    public void update(float delta) {

        gui.update(delta);
        if(Keyboard.isPressed(Keyboard.KEY_SPACE)) {

            Game.setGameState(new InGameState());
        }
    }

    @Override
    public void render(float delta, Batcher batcher) {

        // Get the graphics
        Graphics2D graphics = SilenceEngine.graphics.getGraphics2D();

        // Ask the gui to do the drawing
        gui.render(graphics, batcher);
    }

    @Override
    public void resize() {

    }

    @Override
    public void onLeave() {

        gui = null;
    }
}
