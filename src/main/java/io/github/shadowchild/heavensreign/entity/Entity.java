package io.github.shadowchild.heavensreign.entity;


import com.shc.silenceengine.graphics.Sprite;
import com.shc.silenceengine.math.geom2d.Polygon;
import com.shc.silenceengine.scene.entity.Entity2D;

/**
 * Created by Zach Piddock on 16/01/2016.
 */
public class Entity extends Entity2D {

    public Entity(Polygon polygon) {

        super(polygon);
    }

    public Entity(Sprite sprite, Polygon polygon) {

        super(sprite, polygon);
    }
}
