package io.github.shadowchild.vdgame.gui.element;


import com.shc.silenceengine.graphics.Batcher;
import com.shc.silenceengine.graphics.Graphics2D;
import com.shc.silenceengine.graphics.Sprite;
import com.shc.silenceengine.graphics.opengl.Texture;
import com.shc.silenceengine.math.Vector2;

/**
 * Created by Zach Piddock on 13/12/2015.
 */
public class GuiImage extends GuiElement {

    public GuiImage(Texture logo, Vector2 pos) {

        super(pos.getX(), pos.getY(), new Vector2(logo.getWidth(), logo.getHeight()));
        setTexture(logo);
    }

    @Override
    public void init() {

        sprites.add(new Sprite(getTexture()));
    }

    @Override
    public void render(Graphics2D graphics, Batcher batcher, float delta) {

    }

    @Override
    public void doUpdate(float delta) {

    }
}
