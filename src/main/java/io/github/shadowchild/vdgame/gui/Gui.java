package io.github.shadowchild.vdgame.gui;


import com.shc.silenceengine.graphics.Batcher;
import com.shc.silenceengine.graphics.Graphics2D;

/**
 * Created by Zach Piddock on 04/12/2015.
 */
public abstract class Gui {

    public Gui() {


    }

    public abstract void init();

    public abstract void render(Graphics2D graphics, Batcher batcher, float delta);
}
