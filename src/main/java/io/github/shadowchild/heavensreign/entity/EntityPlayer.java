package io.github.shadowchild.heavensreign.entity;


import com.shc.silenceengine.backend.lwjgl3.opengl.Texture;
import com.shc.silenceengine.graphics.Sprite;
import com.shc.silenceengine.math.Vector2;
import io.github.shadowchild.heavensreign.inv.IInventory;
import io.github.shadowchild.heavensreign.inv.PlayerInventory;

public class EntityPlayer extends Entity {

    private IInventory inventory;

    public EntityPlayer(Vector2 position) {

        super(20, position,
                new Sprite(Texture.fromResource("assets/textures/entity/player/player.png"))
        );
        inventory = new PlayerInventory();
    }

    public IInventory getInventory() {

        return inventory;
    }
}
