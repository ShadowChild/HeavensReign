package io.github.shadowchild.vdgame.gui.element;


import com.shc.silenceengine.graphics.Batcher;
import com.shc.silenceengine.graphics.Graphics2D;
import com.shc.silenceengine.graphics.Paint;
import com.shc.silenceengine.graphics.opengl.Texture;
import com.shc.silenceengine.math.Vector2;

/**
 * Created by Zach Piddock on 04/12/2015.
 */
public abstract class GuiElement {

    public float x, y;
    public Vector2 size;

    private Texture texture = null;
    private Paint paint = null;

    public GuiElement(float x, float y, Vector2 size) {

        this.x = x;
        this.y = y;
        init();
    }

    public abstract void init();

    public abstract void render(Graphics2D graphics, Batcher batcher, float delta);

    public abstract void update(float delta);

    public Texture getTexture() {

        return texture;
    }

    public void setTexture(Texture texture) {

        this.texture = texture;
    }

    public Paint getPaint() {

        return paint;
    }

    public void setPaint(Paint paint) {

        this.paint = paint;
    }
}
