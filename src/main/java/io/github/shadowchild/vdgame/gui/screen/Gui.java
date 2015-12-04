package io.github.shadowchild.vdgame.gui.screen;


import com.shc.silenceengine.graphics.Batcher;
import com.shc.silenceengine.graphics.Graphics2D;
import io.github.shadowchild.vdgame.gui.element.GuiElement;

import java.util.ArrayList;

/**
 * Created by Zach Piddock on 04/12/2015.
 */
public abstract class Gui {

    ArrayList<GuiElement> guiElements = new ArrayList<>();

    public Gui() {

        init();
    }

    public abstract void init();

    public abstract void render(Graphics2D graphics, Batcher batcher, float delta);

    public abstract void update(float delta);
}
