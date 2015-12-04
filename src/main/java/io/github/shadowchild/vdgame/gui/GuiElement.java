package io.github.shadowchild.vdgame.gui;


import com.shc.silenceengine.graphics.Paint;
import com.shc.silenceengine.graphics.opengl.Texture;
import com.shc.silenceengine.math.Vector2;

/**
 * Created by Zach Piddock on 04/12/2015.
 */
public class GuiElement {

    public float x, y;
    public Vector2 size;

    public Texture texture = null;
    public Paint paint = null;

    public GuiElement(float x, float y, Vector2 size) {

        this.x = x;
        this.y = y;
    }

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
