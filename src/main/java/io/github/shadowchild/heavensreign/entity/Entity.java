package io.github.shadowchild.heavensreign.entity;

import com.shc.silenceengine.graphics.Sprite;
import com.shc.silenceengine.graphics.SpriteBatch;
import com.shc.silenceengine.math.Vector2;

import io.github.shadowchild.heavensreign.entity.component.Components;
import io.github.shadowchild.heavensreign.entity.component.Components.ComponentHealth;
import io.github.shadowchild.heavensreign.entity.component.Components.ComponentPosition;
import io.github.shadowchild.heavensreign.entity.component.Components.ComponentSprite;

public class Entity extends com.badlogic.ashley.core.Entity {

	public Entity(int health, Vector2 position, Sprite sprite) {

		add(new Components.ComponentHealth(health));
		add(new Components.ComponentPosition(position));
		add(new Components.ComponentSprite(sprite));
	}

	public int getHealth() {

		ComponentHealth healthComp = Components.HEALTH.get(this);
		return healthComp.health;
	}

	public void changeHealth(int ammount) {

		ComponentHealth healthComp = Components.HEALTH.get(this);
		healthComp.health += ammount;
	}

	public void setHealth(int health) {

		ComponentHealth healthComp = Components.HEALTH.get(this);
		healthComp.health = health;
	}

	public Vector2 getPosition() {

		ComponentPosition positionComp = Components.POSITION.get(this);
		return positionComp.position;
	}

	public float getX() {

		ComponentPosition positionComp = Components.POSITION.get(this);
		return positionComp.position.getX();
	}

	public float getY() {

		ComponentPosition positionComp = Components.POSITION.get(this);
		return positionComp.position.getY();
	}

	public void setX(float x) {

		ComponentPosition positionComp = Components.POSITION.get(this);
		positionComp.position.setX(x);
	}

	public void setY(float y) {

		ComponentPosition positionComp = Components.POSITION.get(this);
		positionComp.position.setY(y);
	}

	public Sprite getSprite() {

		ComponentSprite spriteComp = Components.SPRITE.get(this);
		return spriteComp.sprite;
	}

	public void render(float delta, SpriteBatch batch) {

		Vector2 temp = Vector2.REUSABLE_STACK.pop();

		// The correct position is 'originalPos + (norm(velocity) * delta)' to get smooth movement.
		// TODO: Implement getVelocity() so that i can replace 'new Vector2()'
		temp.set(new Vector2()).normalizeSelf().scaleSelf(delta).addSelf(getPosition());

		batch.addSprite(getSprite(), temp);
		Vector2.REUSABLE_STACK.push(temp);
	}
}
