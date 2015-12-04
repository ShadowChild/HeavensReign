package io.github.shadowchild.vdgame.utils;


import com.shc.silenceengine.core.Display;
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
}
