package io.github.shadowchild.vdgame.gui;


import com.shc.silenceengine.core.Display;
import com.shc.silenceengine.graphics.Batcher;
import com.shc.silenceengine.graphics.Color;
import com.shc.silenceengine.graphics.Graphics2D;
import com.shc.silenceengine.graphics.Paint;
import com.shc.silenceengine.math.Vector2;
import io.github.shadowchild.vdgame.utils.DisplayUtils;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;

/**
 * Created by Zach Piddock on 04/12/2015.
 */
public class GuiTitleScreen extends Gui {

    private ArrayList<GuiElement> guiElements = new ArrayList<>();

    @Override
    public void init() {

        // Initialise the elements

        // Add the elements to the arraylist
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
    }

    @Override
    public void update(float delta) {

    }
}
