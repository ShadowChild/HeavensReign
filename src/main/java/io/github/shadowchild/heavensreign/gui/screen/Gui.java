package io.github.shadowchild.heavensreign.gui.screen;


import com.shc.silenceengine.core.IUpdatable;
import com.shc.silenceengine.graphics.Batcher;
import com.shc.silenceengine.graphics.Graphics2D;
import com.shc.silenceengine.graphics.Sprite;
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

    public abstract void render(Graphics2D graphics, Batcher batcher);

    public abstract void doUpdate(float delta);

    public abstract void onAction(GuiElement element, Action action, int button, int mods);

    public void update(float delta) {



        for(GuiElement e : forgroundElements) {


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
