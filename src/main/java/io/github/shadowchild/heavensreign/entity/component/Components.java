package io.github.shadowchild.heavensreign.entity.component;


import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;
import com.shc.silenceengine.graphics.Sprite;
import com.shc.silenceengine.math.Vector2;

public class Components {

    public static final ComponentMapper<ComponentHealth> HEALTH = ComponentMapper.getFor(
            ComponentHealth.class);
    public static final ComponentMapper<ComponentPosition> POSITION = ComponentMapper.getFor(
            ComponentPosition.class);
    public static final ComponentMapper<ComponentSprite> SPRITE = ComponentMapper.getFor(
            ComponentSprite.class);
    public static final ComponentMapper<ComponentVelocity> VELOCITY = ComponentMapper.getFor(
            ComponentVelocity.class);

    public static class ComponentHealth implements Component {

        public int health;

        public ComponentHealth(int health) {

            this.health = health;
        }
    }

    public static class ComponentPosition implements Component {

        public Vector2 position;

        public ComponentPosition(Vector2 position) {

            this.position = position;
        }
    }

    public static class ComponentVelocity implements Component {

        public Vector2 velocity = new Vector2();
    }

    public static class ComponentSprite implements Component {

        public Sprite sprite;

        public ComponentSprite(Sprite sprite) {

            this.sprite = sprite;
        }
    }
}
