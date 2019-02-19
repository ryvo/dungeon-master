package cz.ryvo.dm.domain.map;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import cz.ryvo.dm.domain.VisibleAreaSquareLocationEnum;
import cz.ryvo.dm.texture.SpriteManager;

import static cz.ryvo.dm.domain.ObjectTypeEnum.WALL;

public final class Block extends Square {

    Side north;

    Side west;

    Side south;

    Side east;

    public Block() {
        type = WALL;
    }

    private void renderWall(VisibleAreaSquareLocationEnum location) {

    }
}
