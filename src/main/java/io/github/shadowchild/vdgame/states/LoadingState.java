package io.github.shadowchild.vdgame.states;

import com.shc.silenceengine.core.Display;
import com.shc.silenceengine.core.GameState;
import com.shc.silenceengine.core.ResourceLoader;
import com.shc.silenceengine.graphics.Batcher;
import com.shc.silenceengine.graphics.TrueTypeFont;
import com.shc.silenceengine.graphics.cameras.OrthoCam;
import com.shc.silenceengine.graphics.opengl.Texture;
import com.shc.silenceengine.utils.Logger;

/**
 * Created by Zach Piddock on 28/10/2015.
 */
public class LoadingState extends GameState {

    private ResourceLoader initialLoader, customLoader;

    private Texture logo;
    private int logoID;

    private TrueTypeFont font;
    private int fontID;

    private OrthoCam camera;

    private void doLoad() {

    }

    private void setResoures() {

    }

    @Override
    public void onEnter() {

        Logger.info("Entered Loading State");

        initialLoader = new ResourceLoader();

        doLoad();
        initialLoader.startLoading();
        setResoures();
        Logger.info("Finished Loading Resources for Custom Loading Screen");

        camera = new OrthoCam().initProjection(Display.getWidth(), Display.getHeight());
    }

    @Override
    public void update(float delta) {

        if(customLoader == null) {

            customLoader = new ResourceLoader();
            customLoader.setProgressRenderCallback(this::customProgressRenderCallback);
        }
    }

    @Override
    public void render(float delta, Batcher batcher) {

        camera.apply();

        if (customLoader != null) {

        }
    }

    @Override
    public void resize() {
    }

    @Override
    public void onLeave() {

        initialLoader.dispose();
        if(customLoader != null) {

            customLoader.dispose();
        }
        Logger.info("Left Loading State");
    }

    private void customProgressRenderCallback(String info, float percentage) {

    }
}
