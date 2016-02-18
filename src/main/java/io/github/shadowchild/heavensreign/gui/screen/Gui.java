package io.github.shadowchild.heavensreign.gui.screen;


import com.shc.silenceengine.core.IUpdatable;
import com.shc.silenceengine.graphics.Batcher;
import com.shc.silenceengine.graphics.Graphics2D;
import com.shc.silenceengine.graphics.Sprite;
import com.shc.silenceengine.input.Mouse;
import io.github.shadowchild.heavensreign.gui.element.GuiElement;

import java.util.ArrayList;

/**
 * Created by Zach Piddock on 04/12/2015.
 */
public abstract class Gui implements IUpdatable {

    ArrayList<GuiElement> backgroundElements = new ArrayList<>();
    ArrayList<GuiElement> forgroundElements = new ArrayList<>();
    ArrayList<Sprite> sprites = new ArrayList<>();

    public Gui() {

        init();
        postInit();
    }

    private void postInit() {

        backgroundElements.forEach(GuiElement::init);
        forgroundElements.forEach(GuiElement::init);
    }

    public abstract void init();

    public void render(Graphics2D graphics, Batcher batcher) {

        doRender(graphics, batcher);

        // draw the elements
        backgroundElements.stream()
                .filter(GuiElement::isVisible)
                .forEach(e -> e.render(graphics, batcher));

        forgroundElements.stream()
                .filter(GuiElement::isVisible)
                .forEach(e -> e.render(graphics, batcher));
    }

    public abstract void doRender(Graphics2D graphics, Batcher batcher);

    public abstract void doUpdate(float delta);

    public void onAction(GuiElement element, Action action){

        element.setAction(action);
    }

    public void update(float delta) {

        boolean mPressed = Mouse.isPressed(Mouse.MOUSE_BUTTON_1);
        boolean mReleased = Mouse.isReleased(Mouse.MOUSE_BUTTON_1);

        for(GuiElement element : forgroundElements) {

            if(element.intersects(Mouse.getX(), Mouse.getY())) {

                if (element.getAction() == null || element.getAction() == Action.LEAVING) {

                    onAction(element, Action.ENTERED);
                } else if(element.getAction() == Action.HOVERING && mPressed || element.getAction() == Action.MOUSE_DOWN) {

                    onAction(element, mPressed ? Action.MOUSE_DOWN : mReleased ? Action.MOUSE_UP : Action.HOVERING);
                } else if(!mPressed) {

                    onAction(element, Action.HOVERING);
                }
            }
            else if(element.getAction() == Action.HOVERING) {

                onAction(element, Action.LEAVING);
            }
        }
        doUpdate(delta);
    }

    public enum Action {

        ENTERED,
        HOVERING,
        LEAVING,
        MOUSE_DOWN,
        MOUSE_UP,
        KEY_DOWN,
        KEY_UP
    }
}
