package io.github.shadowchild.heavensreign.utils;


import com.shc.silenceengine.backend.lwjgl3.opengl.Texture;
import com.shc.silenceengine.math.Vector2;
import io.github.shadowchild.heavensreign.gui.element.GuiButton;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zach Piddock on 14/12/2015.
 */
public class GuiUtils {

    public static float getCorrectedValue(float correctFrom, float value) {

        return correctFrom - (value / 2);
    }

    public static List<GuiButton> createButtonList(String[] options, float centerPointX, float centerPointY, float buttonSpacer, Texture buttonTexture) {

        List<GuiButton> list = new ArrayList<>();

        for(int i = 0; i < options.length; i++) {

            float correctedX = getCorrectedValue(centerPointX, buttonTexture.getWidth());
            float correctedY = getCorrectedValue(centerPointY, buttonTexture.getHeight());

            correctedY += ((buttonTexture.getHeight() + buttonSpacer) * i);

            Vector2 size = new Vector2(buttonTexture.getWidth(), buttonTexture.getHeight());

            GuiButton button = new GuiButton(correctedX, correctedY, size, options[i]);
            button.setTexture(buttonTexture);

            list.add(button);
        }

        return list;
    }
}
