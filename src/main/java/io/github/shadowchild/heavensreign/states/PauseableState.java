package io.github.shadowchild.heavensreign.states;


import com.shc.silenceengine.core.GameState;
import com.shc.silenceengine.graphics.Batcher;
import org.lwjgl.opengl.GL11;

/**
 * Created by Zach Piddock on 10/01/2016.
 */
public class PauseableState extends GameState {

    public boolean paused = false;

    /**
     * This is the method that updates the game state.
     * Any extending classes should call this super method
     * for a basic pause implementation
     *
     * @param delta
     * @param batcher
     */
    @Override
    public void render(float delta, Batcher batcher) {

        // TODO: Add render paused background method
        if(isPaused()) renderPausedBackground(delta, batcher);
        // this will now fall through
    }

    /**
     * This is the method that updates the game state.
     * Any extending classes should call this super method
     * for a basic pause implementation
     *
     * @param delta
     */
    @Override
    public void update(float delta) {

        if(isPaused()) return;
        // this will now fall through to inherited state
    }

    public boolean isPaused() {

        return paused;
    }

    public void pause() {

        this.paused = !paused;
    }

    public void renderPausedBackground(float delta, Batcher batcher) {

        GL11.glPushMatrix();
        {
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
            GL11.glColor4f(104f, 104f, 104f, 0.7f);
            // TODO: Render rectangle
        }
        GL11.glPopMatrix();
    }
}
