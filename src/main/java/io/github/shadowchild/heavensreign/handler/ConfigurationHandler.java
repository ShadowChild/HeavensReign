package io.github.shadowchild.heavensreign.handler;


import com.shc.silenceengine.core.Display;
import io.github.shadowchild.cybernize.config.Config;
import io.github.shadowchild.cybernize.config.Configuration;
import io.github.shadowchild.heavensreign.utils.Settings;

/**
 * Created by Zach Piddock on 03/11/2015.
 */
public class ConfigurationHandler {

    private static Config conf = new Configuration(Configuration.ConfigType.INI,
            "config/General"
    ).load();

    public static void handle() {

        handleGeneral();
    }

    private static void handleGeneral() {

        Settings.lastWindowX = conf.getInteger("Window", "Last Window X Co-ords", 0, null);
        Settings.lastWindowY = conf.getInteger("Window", "Last Window Y Co-ords", 0, null);
        Settings.fullscreen = conf.getBoolean("Window", "Should Be Fullscreen?", false, null);
        Settings.vsync = conf.getBoolean("Window", "Use VSync?", false, null);
        Settings.aspectRatio = conf.getString("Window", "Aspect Ratio", "16:9",
                "Leave the backslash in or the game may crash"
        );
        Settings.resizable = conf.getBoolean("Window", "Resizable Window?", false, null);
    }

    public static void reloadConfig() {

        conf = new Configuration(Configuration.ConfigType.INI, "config/General").load();

        handle();

        Display.setFullScreen(Settings.fullscreen);
        Display.setVSync(Settings.vsync);
        Display.setResizable(Settings.resizable);
    }
}
