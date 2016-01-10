package io.github.shadowchild.heavensreign.gui.screen;


import com.shc.silenceengine.backend.lwjgl3.opengl.Texture;
import com.shc.silenceengine.core.Display;
import com.shc.silenceengine.graphics.Batcher;
import com.shc.silenceengine.graphics.Color;
import com.shc.silenceengine.graphics.Graphics2D;
import com.shc.silenceengine.graphics.Paint;
import com.shc.silenceengine.math.Vector2;
import io.github.shadowchild.heavensreign.gui.element.GuiButton;
import io.github.shadowchild.heavensreign.gui.element.GuiElement;
import io.github.shadowchild.heavensreign.gui.element.GuiImage;
import io.github.shadowchild.heavensreign.utils.DisplayUtils;
import io.github.shadowchild.heavensreign.utils.GuiUtils;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Zach Piddock on 04/12/2015.
 */
public class GuiTitleScreen extends Gui {

    Texture button_sheet;
    private final int buttonSpacing = 10; // figure out a nice number

    @Override
    public void init() {

        int centerX = DisplayUtils.getCenterCoords().getLeft();
        int centerY = DisplayUtils.getCenterCoords().getRight();

        String[] options = new String[] { "Play", "Options", "Quit" };

        button_sheet = Texture.fromResource("assets/textures/gui/gui_button_sheet.png");

//        // Initialise the elements
        Texture buttonTexture = DisplayUtils.createSubTexture(button_sheet, 0, 0, 500, 50);

        // TODO: Nicify this
        Pair<Integer, Integer> centerCoords = DisplayUtils.getCenterCoords();
        Vector2 size = new Vector2(DisplayUtils.LOGO.getWidth(), DisplayUtils.LOGO.getHeight());
        Vector2 fixedCoords = new Vector2(centerCoords.getLeft() - ((int)size.getX() / 2),
                (centerCoords.getRight() - ((int)size.getY() / 2) - 200)
        );
        GuiElement logo = new GuiImage(DisplayUtils.LOGO, fixedCoords);

        List<GuiButton> buttons = GuiUtils.createButtonList(options, centerX, 400, buttonSpacing, buttonTexture);

        // Add the elements to the arraylist
        forgroundElements.addAll(buttons.stream().collect(Collectors.toList()));
        forgroundElements.add(logo);
    }

    @Override
    public void render(Graphics2D graphics, Batcher batcher, float delta) {

        // Draw the background
        graphics.setPaint(new Paint(Color.AZURE));
        graphics.fillRect(new Vector2(0, 0), Display.getWidth(), Display.getHeight());

        // draw the elements
        for(GuiElement e : backgroundElements) {

            e.render(graphics, batcher, delta);
        }
        for(GuiElement e : forgroundElements) {

            e.render(graphics, batcher, delta);
        }
    }

    @Override
    public void doUpdate(float delta) {

    }

    @Override
    public void onAction(GuiElement element, Action action, int button, int mods) {

    }
}
