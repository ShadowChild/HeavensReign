package io.github.shadowchild.vdgame.gui.screen;


import com.shc.silenceengine.core.Display;
import com.shc.silenceengine.core.SilenceEngine;
import com.shc.silenceengine.graphics.Batcher;
import com.shc.silenceengine.graphics.Color;
import com.shc.silenceengine.graphics.Graphics2D;
import com.shc.silenceengine.graphics.Paint;
import com.shc.silenceengine.graphics.Sprite;
import com.shc.silenceengine.graphics.SpriteBatch;
import com.shc.silenceengine.graphics.opengl.Texture;
import com.shc.silenceengine.math.Vector2;
import io.github.shadowchild.vdgame.gui.element.GuiButton;
import io.github.shadowchild.vdgame.gui.element.GuiElement;
import io.github.shadowchild.vdgame.gui.element.GuiImage;
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
                new Vector2(buttonTexture.getWidth(), buttonTexture.getHeight()), "Options",
                SilenceEngine.graphics.getGraphics2D().getFont(),
                buttonTexture
        );

        Pair<Integer, Integer> centerCoords = DisplayUtils.getCenterCoords();
        Vector2 size = new Vector2(DisplayUtils.LOGO.getWidth(), DisplayUtils.LOGO.getHeight());
        Vector2 fixedCoords = new Vector2(centerCoords.getLeft() - ((int)size.getX() / 2),
                (centerCoords.getRight() - ((int)size.getY() / 2) - 200)
        );
        GuiElement logo = new GuiImage(DisplayUtils.LOGO, fixedCoords);

        // Add the elements to the arraylist
        forgroundElements.add(optionsButton);
        forgroundElements.add(logo);
    }

    @Override
    public void render(Graphics2D graphics, Batcher batcher, float delta) {

        // Draw the background
        graphics.setPaint(new Paint(Color.AZURE));
        graphics.fillRect(new Vector2(0, 0), Display.getWidth(), Display.getHeight());

        // draw the elements
        SpriteBatch batch = SilenceEngine.graphics.getSpriteBatch();

        batch.begin();
        for(GuiElement element : forgroundElements) {
            for(Sprite sprite : element.getSprites()) {

                batch.addSprite(sprite, element.getPosition());
            }
            element.render(graphics, batcher, delta);
        }
        batch.end();
    }

    @Override
    public void doUpdate(float delta) {

    }

    @Override
    public void onAction(GuiElement element, Action action, int button, int mods) {

    }
}
