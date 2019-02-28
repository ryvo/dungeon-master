package cz.ryvo.dm.domain.map;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import java.io.Serializable;

import cz.ryvo.dm.domain.ObjectTypeEnum;
import cz.ryvo.dm.domain.VisibleAreaSquareLocationEnum;
import cz.ryvo.dm.texture.SpriteManager;

public abstract class Square implements Serializable {

    protected ObjectTypeEnum type;

    public void render(SpriteBatch batch, SpriteManager spriteManager, VisibleAreaSquareLocationEnum location, float scale) {
        if (type == ObjectTypeEnum.VOID) return;

        String spriteName = String.join("-", type.getValue(), location.getResourceName());
        Sprite sprite = spriteManager.getSprite(spriteName);

        Rectangle drawingRectangle = location.getDrawingRectangle();
        batch.draw(sprite, scale * drawingRectangle.x, scale * drawingRectangle.y, scale * drawingRectangle.width, scale * drawingRectangle.height);
    }

    public boolean canPartyWalkIn() {
        return false;
    }

    public boolean canPartyWalkOut() {
        return false;
    }
}
