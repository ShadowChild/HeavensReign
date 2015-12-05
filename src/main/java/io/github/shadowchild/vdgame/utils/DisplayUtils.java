package io.github.shadowchild.vdgame.utils;


import com.shc.silenceengine.core.Display;
import com.shc.silenceengine.graphics.opengl.Texture;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

/**
 * Created by Zach Piddock on 04/12/2015.
 */
public class DisplayUtils {

    public static Pair<Integer, Integer> getDisplaySize() {

        return new ImmutablePair<>(Display.getWidth(), Display.getHeight());
    }

    public static Pair<Integer, Integer> getCenterCoords() {

        Pair<Integer, Integer> displaySize = getDisplaySize();
        return new ImmutablePair<>(displaySize.getLeft() / 2, displaySize.getRight() / 2);
    }

    public static Texture createSubTexture(Texture parent, float xPos, float yPos, float width, float height) {

        // first we lay out the values we need
        float parentWidth = parent.getWidth(), parentHeight = parent.getHeight();
        float minU; // min width
        float maxU; // max width
        float minV; // min height
        float maxV; // max height

        // now for the calculations
        minU = ((xPos * 100) / parentWidth) / 100;
        maxU = ((width * 100) / parentWidth) / 100;
        minV = ((yPos * 100) / parentHeight) / 100;
        maxV = ((height * 100) / parentHeight) / 100;

        return parent.getSubTexture(minU, minV, maxU, maxV, width, height);
    }
}
