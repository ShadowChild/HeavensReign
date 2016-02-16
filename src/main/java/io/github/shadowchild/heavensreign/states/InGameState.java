package io.github.shadowchild.heavensreign.states;


import com.shc.silenceengine.core.Display;
import com.shc.silenceengine.graphics.Batcher;
import com.shc.silenceengine.graphics.cameras.OrthoCam;
import com.shc.silenceengine.math.Vector2;

import io.github.shadowchild.heavensreign.entity.EntityPlayer;
import io.github.shadowchild.heavensreign.scene.GameScene;

/**
 * Created by Zach Piddock on 28/10/2015.
 */
public class InGameState extends PauseableState {

	public GameScene mainScene;
	public OrthoCam cam;
	public EntityPlayer player;
	//	public Player player;

	@Override
	public void onEnter() {

		player = new EntityPlayer(new Vector2(0, 0));
		mainScene = new GameScene(player);
		cam = new OrthoCam();
		mainScene.addEntity(player);
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
