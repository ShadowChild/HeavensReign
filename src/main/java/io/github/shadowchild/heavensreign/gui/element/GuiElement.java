package io.github.shadowchild.heavensreign.gui.element;


import com.shc.silenceengine.backend.lwjgl3.opengl.Texture;
import com.shc.silenceengine.core.IUpdatable;
import com.shc.silenceengine.graphics.Batcher;
import com.shc.silenceengine.graphics.Graphics2D;
import com.shc.silenceengine.graphics.Paint;
import com.shc.silenceengine.math.Vector2;

/**
 * Created by Zach Piddock on 04/12/2015.
 */
public abstract class GuiElement implements IUpdatable {

    public Vector2 location;
    public Vector2 size;

    private Texture texture;
    private Paint paint;

    private boolean isActive = true, isVisible = true;

    public GuiElement(Vector2 location, Vector2 size) {

        this.location = location;
        this.size = size;
    }
    
    public GuiElement(Vector2 location) {
        
        this.location = location;
    }

    public abstract void init();

    public abstract void render(Graphics2D graphics, Batcher batcher);

    public abstract void doUpdate(float delta);

    public void update(float delta) {

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

    public boolean intersects(float x, float y) {

        if(x < this.location.getX() || y < this.location.getY()) return false;

        if(x > (this.location.getX() + this.size.getX()) || y > (this.location.getY() + this.size.getY())) return false;

        return true;
    }

    public Vector2 getPosition() {

        return location;
    }

    public boolean isActive() {

        return isActive;
    }

    public void setActive(boolean active) {

        isActive = active;
    }

    public boolean isVisible() {

        return isVisible;
    }

    public void setVisible(boolean visible) {

        isVisible = visible;
    }
}
