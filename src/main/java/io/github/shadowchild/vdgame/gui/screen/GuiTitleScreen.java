package io.github.shadowchild.vdgame.gui.screen;


import com.shc.silenceengine.core.Display;
import com.shc.silenceengine.graphics.Batcher;
import com.shc.silenceengine.graphics.Color;
import com.shc.silenceengine.graphics.Graphics2D;
import com.shc.silenceengine.graphics.Paint;
import com.shc.silenceengine.graphics.opengl.Texture;
import com.shc.silenceengine.math.Vector2;
import io.github.shadowchild.vdgame.gui.element.GuiButton;
import io.github.shadowchild.vdgame.gui.element.GuiElement;
import io.github.shadowchild.vdgame.utils.DisplayUtils;
import org.apache.commons.lang3.tuple.Pair;

/**
 * Created by Zach Piddock on 04/12/2015.
 */
public class GuiTitleScreen extends Gui {

    Texture button_sheet;

    @Override
    public void init() {

        button_sheet = Texture.fromResource("assets/textures/gui/gui_button_sheet.png");

        // Initialise the elements
        Texture buttonTexture = DisplayUtils.createSubTexture(button_sheet, 0, 0, 500, 50);
        GuiElement optionsButton = new GuiButton(
                (Display.getWidth() / 2) - buttonTexture.getWidth() / 2, 400,
                new Vector2(buttonTexture.getWidth(), buttonTexture.getHeight()), "Options"
        );
        optionsButton.setTexture(buttonTexture);

        // Add the elements to the arraylist
        forgroundElements.add(optionsButton);
    }

    @Override
    public void render(Graphics2D graphics, Batcher batcher, float delta) {

        // Draw the background
        graphics.setPaint(new Paint(Color.AZURE));
        graphics.fillRect(new Vector2(0, 0), Display.getWidth(), Display.getHeight());

        // draw the logo
        graphics.setPaint(new Paint(Color.CRIMSON));
        Pair<Integer, Integer> centerCoords = DisplayUtils.getCenterCoords();
        Vector2 size = new Vector2(500, 300);
        Vector2 fixedCoords = new Vector2(centerCoords.getLeft() - ((int)size.getX() / 2),
                (centerCoords.getRight() - ((int)size.getY() / 2) - 200)
        );

        graphics.fillRect(fixedCoords, size.getX(), size.getY());

        // draw the elements
        for(GuiElement element : forgroundElements) element.render(graphics, batcher, delta);
    }

    @Override
    public void doUpdate(float delta) {

    }

    @Override
    public void onAction(GuiElement element, Action action, int button, int mods) {

    }
}
