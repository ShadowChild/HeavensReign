package io.github.shadowchild.heavensreign.scene;


import com.shc.silenceengine.core.Display;
import com.shc.silenceengine.core.SilenceEngine;
import com.shc.silenceengine.graphics.Color;
import com.shc.silenceengine.graphics.Graphics2D;
import com.shc.silenceengine.graphics.Paint;
import com.shc.silenceengine.input.Keyboard;
import com.shc.silenceengine.math.Vector2;
import com.shc.silenceengine.scene.Scene2D;
import io.github.shadowchild.heavensreign.entity.Player;

/**
 * Created by Zach Piddock on 16/01/2016.
 */
public class GameScene extends Scene2D {

    public Player player;

    public GameScene(Player player) {

        this.player = player;
    }

    @Override
    public void update(float delta) {

        super.update(delta);
        if(Keyboard.isPressed(Keyboard.KEY_W)) {

            player.setY(player.getY() - 1);
        }
        if(Keyboard.isPressed(Keyboard.KEY_D)) {

            player.setX(player.getX() + 1);
        }
        if(Keyboard.isPressed(Keyboard.KEY_A)) {

            player.setX(player.getX() - 1);
        }
        if(Keyboard.isPressed(Keyboard.KEY_S)) {

            player.setY(player.getY() + 1);
        }
    }

    @Override
    public void render(float delta) {

        Graphics2D graphics = SilenceEngine.graphics.getGraphics2D();
        graphics.setPaint(new Paint(Color.AZURE));
        graphics.fillRect(new Vector2(0, 0), Display.getWidth(), Display.getHeight());
        super.render(delta);
    }
}
