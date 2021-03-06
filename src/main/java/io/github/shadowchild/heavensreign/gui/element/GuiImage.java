package io.github.shadowchild.heavensreign.gui.element;


import com.shc.silenceengine.backend.lwjgl3.opengl.Texture;
import com.shc.silenceengine.graphics.Batcher;
import com.shc.silenceengine.graphics.Graphics2D;
import com.shc.silenceengine.math.Vector2;

/**
 * Created by Zach Piddock on 13/12/2015.
 */
public class GuiImage extends GuiElement {

    public GuiImage(Texture logo, Vector2 location) {

        super(location, new Vector2(logo.getWidth(), logo.getHeight()));
        setTexture(logo);
    }

    @Override
    public void init() {

    }

    @Override
    public void render(Graphics2D graphics, Batcher batcher) {

        graphics.drawTexture(getTexture(), location);
    }

    @Override
    public void doUpdate(float delta) {

    }
}
