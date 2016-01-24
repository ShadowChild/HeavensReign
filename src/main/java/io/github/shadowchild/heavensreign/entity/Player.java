package io.github.shadowchild.heavensreign.entity;


import com.shc.silenceengine.backend.lwjgl3.opengl.Texture;
import com.shc.silenceengine.graphics.Sprite;
import com.shc.silenceengine.graphics.SpriteBatch;
import com.shc.silenceengine.math.geom2d.Rectangle;
import io.github.shadowchild.heavensreign.inv.IInventory;

/**
 * Created by Zach Piddock on 16/01/2016.
 */
public class Player extends Entity {

    public IInventory inventory;
    public EntityCapabilities capabilities = new EntityCapabilities();

    public Player(IInventory inventory) {

        super(new Sprite(Texture.fromResource("assets/textures/entity/player/player.png")),
                new Rectangle(256, 512)
        );
        this.inventory = inventory;
    }

    @Override
    public void render(float delta, SpriteBatch batch) {

        super.render(delta, batch);
    }
}
