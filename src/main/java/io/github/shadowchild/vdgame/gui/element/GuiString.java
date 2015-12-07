package io.github.shadowchild.vdgame.gui.element;


import com.shc.silenceengine.core.SilenceEngine;
import com.shc.silenceengine.graphics.Batcher;
import com.shc.silenceengine.graphics.Graphics2D;
import com.shc.silenceengine.graphics.IFont;
import com.shc.silenceengine.math.Vector2;

/**
 * Created by Zach Piddock on 04/12/2015.
 */
public class GuiString extends GuiElement {

    private String text;
    private IFont font = SilenceEngine.graphics.getGraphics2D().getFont();

    public GuiString(float x, float y, String text) {

        super(x, y, size);
        this.text = text;
    }

    public GuiButton(float x, float y, String text, IFont font) {

        this(x, y, text);
        this.font = font;
    }

    public String getText() {

        return text;
    }

    public void setText(String text) {

        this.text = text;
    }

    public IFont getFont() {

        return font;
    }

    public void setFont(IFont font) {

        this.font = font;
    }

    @Override
    public void init() {

    }

    @Override
    public void render(Graphics2D graphics, Batcher batcher, float delta) {

        graphics.drawString(text, this.x, this.y);
    }

    @Override
    public void update(float delta) {

    }
}
