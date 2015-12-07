package io.github.shadowchild.vdgame.gui.element;


import com.shc.silenceengine.core.SilenceEngine;
import com.shc.silenceengine.graphics.Batcher;
import com.shc.silenceengine.graphics.Graphics2D;
import com.shc.silenceengine.graphics.IFont;
import com.shc.silenceengine.math.Vector2;

/**
 * Created by Zach Piddock on 04/12/2015.
 */
public class GuiButton extends GuiElement {

    private GuiString string;

    public GuiButton(float x, float y, Vector2 size, GuiString string) {

        super(x, y, size);
        this.string = string;
    }

    public GuiButton(float x, float y, Vector2 size, GuiString string) {

        this(x, y, size, string);
    }

    public GuiString getString() {

        return string;
    }

    public void setString(GuiString string) {

        this.string = string;
    }

    @Override
    public void init() {

    }

    @Override
    public void render(Graphics2D graphics, Batcher batcher, float delta) {

        // draw the button texture
        graphics.drawTexture(getTexture(), this.x, this.y);
        
        // find the correct x and y coords for the string
        float centerX = DisplayUtils.getCenterCoords().getLeft() - (size.getX() / 2);
        float centerY = DisplayUtils.getCenterCoords().getRight() - (size.getY() / 2);
        float correctX = centerX - (string.getFont().getWidth(string.getText()) / 2);
        float correctY = centerY - (string.getFont().getHeight() / 2);
        
        // set the font and then draw it
        graphics.setFont(string.getFont());
        graphics.drawString(string.getText(), correctX, correctY);
    }

    @Override
    public void update(float delta) {

    }
}
