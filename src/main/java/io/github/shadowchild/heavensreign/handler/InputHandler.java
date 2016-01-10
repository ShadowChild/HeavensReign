package io.github.shadowchild.heavensreign.handler;


import com.shc.silenceengine.core.glfw.Window;

/**
 * Created by Zach Piddock on 12/12/2015.
 */
public class InputHandler {

    public static void keyCallback(Window window, int key, int scanCode, int action, int mods) {

    }

    public static void cursorPosCallback(Window window, double x, double y) {

        System.out.println(String.format("MouseX = %s, MouseY = %s", x, y));
    }

    public static void mouseInputCallback(Window window, int button, int action, int mods) {

        System.out.println(String.format("ButtonID = %d, Action = %d, Mods = %d", button, action, mods));
    }
}
