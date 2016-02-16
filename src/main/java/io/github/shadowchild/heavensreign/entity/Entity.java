package io.github.shadowchild.heavensreign.entity;


import com.shc.silenceengine.graphics.Sprite;
import com.shc.silenceengine.graphics.SpriteBatch;
import com.shc.silenceengine.math.Vector2;
import io.github.shadowchild.heavensreign.entity.component.Components;

public class Entity extends com.badlogic.ashley.core.Entity {

    public Entity(int health, Vector2 position, Sprite sprite) {

        add(new Components.ComponentHealth(health));
        add(new Components.ComponentPosition(position));
        add(new Components.ComponentSprite(sprite));
        add(new Components.ComponentVelocity());
    }

    public int getHealth() {

        Components.ComponentHealth healthComp = Components.HEALTH.get(this);
        return healthComp.health;
    }

    public void changeHealth(int ammount) {

        Components.ComponentHealth healthComp = Components.HEALTH.get(this);
        healthComp.health += ammount;
    }

    public void setHealth(int health) {

        Components.ComponentHealth healthComp = Components.HEALTH.get(this);
        healthComp.health = health;
    }

    public Vector2 getPosition() {

        Components.ComponentPosition positionComp = Components.POSITION.get(this);
        return positionComp.position;
    }

    public float getX() {

        Components. ComponentPosition positionComp = Components.POSITION.get(this);
        return positionComp.position.getX();
    }

    public float getY() {

        Components.ComponentPosition positionComp = Components.POSITION.get(this);
        return positionComp.position.getY();
    }

    public void setX(float x) {

        Components.ComponentPosition positionComp = Components.POSITION.get(this);
        positionComp.position.setX(x);
    }

    public void setY(float y) {

        Components.ComponentPosition positionComp = Components.POSITION.get(this);
        positionComp.position.setY(y);
    }

    public void setPosition(Vector2 position) {

        Components.ComponentPosition positionComp = Components.POSITION.get(this);
        positionComp.position.set(position);
    }

    public Sprite getSprite() {

        Components.ComponentSprite sprite = Components.SPRITE.get(this);
        return sprite.sprite;
    }

    public Vector2 getVelocity() {

        Components.ComponentVelocity velocity = Components.VELOCITY.get(this);
        return velocity.velocity;
    }

    public void setVelocity(Vector2 newVelocity) {

        Components.ComponentVelocity velocity = Components.VELOCITY.get(this);
        velocity.velocity.set(newVelocity);
    }

    public void render(float delta, SpriteBatch batch) {

        Vector2 temp = Vector2.REUSABLE_STACK.pop();

        // The correct position is 'originalPos + (norm(velocity) * delta)' to get smooth movement.
        temp.set(getVelocity()).normalizeSelf().scaleSelf(delta).addSelf(getPosition());

        batch.addSprite(getSprite(), temp);
        Vector2.REUSABLE_STACK.push(temp);
    }

    public void update(float delta) {

        if (getVelocity() == Vector2.ZERO)
            return;

        Vector2 tempVec2 = Vector2.REUSABLE_STACK.pop();

        // Calculate the new position
        setPosition(tempVec2.set(getPosition()).addSelf(getVelocity()));

        Vector2.REUSABLE_STACK.push(tempVec2);

        getSprite().update(delta);
//        sprite.setRotation(getRotation());
    }
}
