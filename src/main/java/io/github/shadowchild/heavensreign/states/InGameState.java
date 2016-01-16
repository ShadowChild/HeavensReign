package io.github.shadowchild.heavensreign.states;


import com.shc.silenceengine.core.Display;
import com.shc.silenceengine.graphics.Batcher;
import com.shc.silenceengine.graphics.cameras.OrthoCam;
import com.shc.silenceengine.scene.Scene2D;
import io.github.shadowchild.heavensreign.entity.Player;
import io.github.shadowchild.heavensreign.inv.PlayerInventory;
import io.github.shadowchild.heavensreign.scene.GameScene;

/**
 * Created by Zach Piddock on 28/10/2015.
 */
public class InGameState extends PauseableState {

    public Scene2D mainScene;
    public OrthoCam cam;
    public Player player;

    @Override
    public void onEnter() {

        mainScene = new GameScene();
        cam = new OrthoCam();
        player = new Player(new PlayerInventory());
        mainScene.addChild(player);
    }

    @Override
    public void update(float delta) {

        mainScene.update(delta);
    }

    @Override
    public void render(float delta, Batcher batcher) {

        cam.apply();
        mainScene.render(delta);
    }

    @Override
    public void resize() {

        cam.initProjection(Display.getWidth(), Display.getHeight());
    }

    @Override
    public void onLeave() {

    }
}
