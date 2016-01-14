package io.github.shadowchild.heavensreign.gui.element;


import com.shc.silenceengine.core.SilenceEngine;
import com.shc.silenceengine.graphics.Batcher;
import com.shc.silenceengine.graphics.Graphics2D;
import com.shc.silenceengine.graphics.IFont;
import com.shc.silenceengine.math.Vector2;

/**
 * Created by Zach Piddock on 04/12/2015.
 */
public class GuiButton extends GuiElement {

    private String text;
    private IFont font;

    public GuiButton(Vector2 location, Vector2 size) {

        super(location, size);
    }
    
    public GuiButton(Vector2 location, Vector2 size, String text) {
        
        this(location, size, text, SilenceEngine.graphics.getGraphics2D().getFont());
    }
    
    public GuiButton(Vector2 location, Vector2 size, String text, IFont font) {
        
        super(location, size);
        this.text = text;
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
    public void render(Graphics2D graphics, Batcher batcher) {

        // draw the button texture
        graphics.drawTexture(getTexture(), this.location.getX(), this.location.getY());
        
        // get the coords for the center of the button
        float centerX = location.getX() + (size.getX() / 2);
        float centerY = location.getY() + (size.getY() / 2);
        
        // init correct coord values
        float correctX, correctY;
        String toRender;

        // set values from the string & font
        correctX = centerX - (font.getWidth(text) / 2);
        correctY = centerY - (font.getHeight() / 2);
        graphics.setFont(font);
        toRender = text;
        
        // finally draw the string
        graphics.drawString(toRender, correctX, correctY);
    }

    @Override
    public void doUpdate(float delta) {

    }
}
