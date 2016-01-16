package io.github.shadowchild.heavensreign.scene;


import com.shc.silenceengine.core.Display;
import com.shc.silenceengine.core.SilenceEngine;
import com.shc.silenceengine.graphics.Color;
import com.shc.silenceengine.graphics.Graphics2D;
import com.shc.silenceengine.graphics.Paint;
import com.shc.silenceengine.math.Vector2;
import com.shc.silenceengine.scene.Scene2D;

/**
 * Created by Zach Piddock on 16/01/2016.
 */
public class GameScene extends Scene2D {

    @Override
    public void update(float delta) {

        super.update(delta);
    }

    @Override
    public void render(float delta) {

        Graphics2D graphics = SilenceEngine.graphics.getGraphics2D();
        graphics.setPaint(new Paint(Color.AZURE));
        graphics.fillRect(new Vector2(0, 0), Display.getWidth(), Display.getHeight());
        super.render(delta);
    }
}
