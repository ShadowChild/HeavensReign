package io.github.shadowchild.vdgame.states;

import com.shc.silenceengine.core.GameState;
import com.shc.silenceengine.graphics.Batcher;
import com.shc.silenceengine.utils.Logger;

/**
 * Created by Zach Piddock on 28/10/2015.
 */
public class LoadingState extends GameState {

    @Override
    public void onEnter() {

        Logger.info("Entered Loading State");
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void render(float delta, Batcher batcher) {
    }

    @Override
    public void resize() {
    }

    @Override
    public void onLeave() {

        Logger.info("Left Loading State");
    }
}
