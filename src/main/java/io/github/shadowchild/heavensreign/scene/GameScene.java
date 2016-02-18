package io.github.shadowchild.heavensreign.scene;


import com.badlogic.ashley.core.Engine;
import com.shc.silenceengine.core.Display;
import com.shc.silenceengine.core.SilenceEngine;
import com.shc.silenceengine.graphics.Color;
import com.shc.silenceengine.graphics.Graphics2D;
import com.shc.silenceengine.graphics.Paint;
import com.shc.silenceengine.graphics.SpriteBatch;
import com.shc.silenceengine.graphics.cameras.BaseCamera;
import com.shc.silenceengine.input.Keyboard;
import com.shc.silenceengine.math.Frustum;
import com.shc.silenceengine.math.Vector2;
import com.shc.silenceengine.scene.Scene2D;
import io.github.shadowchild.heavensreign.entity.Entity;
import io.github.shadowchild.heavensreign.entity.EntityPlayer;

/**
 * Created by Zach Piddock on 16/01/2016.
 */
public class GameScene extends Scene2D {

    public final Engine ENGINE = new Engine();

    public EntityPlayer player;

    public GameScene(EntityPlayer player) {

        this.player = player;
    }

    @Override
    public void update(float delta) {

        ENGINE.update(delta);
        if(Keyboard.isPressed(Keyboard.KEY_W)) {

            addVelocity(0, -7.5f);
        }
        if(Keyboard.isPressed(Keyboard.KEY_D)) {

            addVelocity(7.5f, 0);
        }
        if(Keyboard.isPressed(Keyboard.KEY_A)) {

            addVelocity(-7.5f, 0);
        }
        if(Keyboard.isPressed(Keyboard.KEY_S)) {

            addVelocity(0, 7.5f);
        }
        ENGINE.getEntities().forEach(e -> ((Entity)e).update(delta));
        player.setVelocity(Vector2.ZERO);
    }

    public void addVelocity(float x, float y) {

        player.setVelocity(player.getVelocity().add(x,  y));
    }

    @Override
    public void render(float delta) {

        // Draw the background
        Graphics2D graphics = SilenceEngine.graphics.getGraphics2D();
        graphics.setPaint(new Paint(Color.AZURE));
        graphics.fillRect(new Vector2(0, 0), Display.getWidth(), Display.getHeight());

        // Draw the entities
        // Get the Frustum once to prevent unnecessary calculations
        Frustum frustum = BaseCamera.CURRENT.getFrustum();

        SpriteBatch batch = SilenceEngine.graphics.getSpriteBatch();
        batch.begin();
        {
            // for each entity, draw it
            for(com.badlogic.ashley.core.Entity ent : ENGINE.getEntities()) {

                Entity e = (Entity)ent;

                // TODO: Add frustrum culling and depth here

                e.render(delta, batch);
            }
        }
        batch.end();
    }

    public void addEntity(Entity entity) {

        ENGINE.addEntity(entity);
    }

    public void removeEntity(Entity entity) {

        ENGINE.removeEntity(entity);
    }
}
