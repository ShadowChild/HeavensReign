package io.github.shadowchild.vdgame.gui.element;


import com.shc.silenceengine.core.SilenceEngine;
import com.shc.silenceengine.graphics.Batcher;
import com.shc.silenceengine.graphics.Graphics2D;
import com.shc.silenceengine.graphics.IFont;
import com.shc.silenceengine.graphics.Sprite;
import com.shc.silenceengine.graphics.opengl.Texture;
import com.shc.silenceengine.math.Vector2;

/**
 * Created by Zach Piddock on 04/12/2015.
 */
public class GuiButton extends GuiElement {

    private GuiString string;
    private String text;
    private IFont font;

    public GuiButton(float x, float y, Vector2 size, GuiString string, Texture texture) {

        super(x, y, size);
        this.string = string;
        this.setTexture(texture);
    }
    
    public GuiButton(float x, float y, Vector2 size, String text, Texture texture) {
        
        this(x, y, size, text, SilenceEngine.graphics.getGraphics2D().getFont(), texture);
    }
    
    public GuiButton(float x, float y, Vector2 size, String text, IFont font, Texture texture) {
        
        super(x, y, size);
        this.text = text;
        this.font = font;
        this.setTexture(texture);
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

    public GuiString getString() {

        return string;
    }

    public void setString(GuiString string) {

        this.string = string;
    }

    @Override
    public void init() {

        sprites.add(new Sprite(getTexture()));
    }

    @Override
    public void render(Graphics2D graphics, Batcher batcher, float delta) {

        // draw the button texture
//        graphics.drawTexture(getTexture(), this.x, this.y);
        
        // get the coords for the center of the button
        float centerX = x + (size.getX() / 2);
        float centerY = y + (size.getY() / 2);
        
        // init correct coord values
        float correctX, correctY;
        String toRender;
        
        // check if the GuiString value exists
        if(string != null) {
            
            // set values from the GuiString
            correctX = centerX - (string.getFont().getWidth(string.getText()) / 2);
            correctY = centerY - (string.getFont().getHeight() / 2);

            graphics.setFont(string.getFont());
            toRender = string.getText();
        } else {
            
            // set values from the string & font
            correctX = centerX - (font.getWidth(text) / 2);
            correctY = centerY - (font.getHeight() / 2);
            graphics.setFont(font);
            toRender = text;
        }
        
        // finally draw the string
        graphics.drawString(toRender, correctX, correctY);
    }

    @Override
    public void doUpdate(float delta) {

    }
}
