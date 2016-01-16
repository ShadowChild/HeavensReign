package io.github.shadowchild.heavensreign;


import com.shc.silenceengine.core.Game;
import com.shc.silenceengine.core.gameloops.FixedCatchingUpGameLoop;
import io.github.shadowchild.common.util.Utils;
import io.github.shadowchild.heavensreign.game.HRGame;
import io.github.shadowchild.heavensreign.handler.ConfigurationHandler;

/**
 * Created by Zach Piddock on 27/10/2015.
 */
public class HeavensReign extends Game {

    public static void main(String... args) {

        Utils.initialise();
        ConfigurationHandler.handle();

        new HRGame().start(
                new FixedCatchingUpGameLoop().setTargetUpdatesPerSecond(60).setMaxSkippedFrames(5));
    }
}
