package cz.ryvo.dm.renderer;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import cz.ryvo.dm.domain.Position2D;
import cz.ryvo.dm.domain.DirectionEnum;
import cz.ryvo.dm.domain.Position3D;
import cz.ryvo.dm.domain.VisibleAreaSquareLocationEnum;
import cz.ryvo.dm.domain.map.Level;
import cz.ryvo.dm.domain.map.Square;
import cz.ryvo.dm.texture.SpriteManager;
import cz.ryvo.dm.util.MapUtils;

import static cz.ryvo.dm.domain.ObjectTypeEnum.CEILING;
import static cz.ryvo.dm.domain.ObjectTypeEnum.FLOOR;
import static cz.ryvo.dm.domain.VisibleAreaSquareLocationEnum.FAR_LEFT_2;
import static cz.ryvo.dm.domain.VisibleAreaSquareLocationEnum.FAR_LEFT_3;
import static cz.ryvo.dm.domain.VisibleAreaSquareLocationEnum.FAR_RIGHT_2;
import static cz.ryvo.dm.domain.VisibleAreaSquareLocationEnum.FAR_RIGHT_3;
import static cz.ryvo.dm.domain.VisibleAreaSquareLocationEnum.FRONT_1;
import static cz.ryvo.dm.domain.VisibleAreaSquareLocationEnum.FRONT_2;
import static cz.ryvo.dm.domain.VisibleAreaSquareLocationEnum.FRONT_3;
import static cz.ryvo.dm.domain.VisibleAreaSquareLocationEnum.LEFT_0;
import static cz.ryvo.dm.domain.VisibleAreaSquareLocationEnum.LEFT_1;
import static cz.ryvo.dm.domain.VisibleAreaSquareLocationEnum.LEFT_2;
import static cz.ryvo.dm.domain.VisibleAreaSquareLocationEnum.LEFT_3;
import static cz.ryvo.dm.domain.VisibleAreaSquareLocationEnum.RIGHT_0;
import static cz.ryvo.dm.domain.VisibleAreaSquareLocationEnum.RIGHT_1;
import static cz.ryvo.dm.domain.VisibleAreaSquareLocationEnum.RIGHT_2;
import static cz.ryvo.dm.domain.VisibleAreaSquareLocationEnum.RIGHT_3;

public class DungeonRenderer {

    private final VisibleAreaSquareLocationEnum[] squareRenderingOrder = {
            FAR_LEFT_3,
            FAR_LEFT_2,
            FAR_RIGHT_3,
            FAR_RIGHT_2,
            LEFT_3,
            RIGHT_3,
            LEFT_2,
            RIGHT_2,
            FRONT_3,
            LEFT_1,
            RIGHT_1,
            FRONT_2,
            LEFT_0,
            RIGHT_0,
            FRONT_1
    };

    private final SpriteBatch batch;
    private final SpriteManager spriteManager;

    public DungeonRenderer(SpriteBatch batch, SpriteManager spriteManager ) {
        this.batch = batch;
        this.spriteManager = spriteManager;
    }

    public void render(Level level, Position3D partyPosition, DirectionEnum partyDirection, float scale) {
        renderCeiling(scale);
        renderFloor(scale);
        Square[][] squares = MapUtils.getVisibleSquares(level, partyPosition.x, partyPosition.y, partyDirection);
        for (VisibleAreaSquareLocationEnum location: squareRenderingOrder) {
            Square square = squares[location.getSquarePosition().x][location.getSquarePosition().y];
            square.render(batch, spriteManager, location, scale);
        }
    }

    private void renderFloor(float scale) {
        Sprite sprite = spriteManager.getSprite(FLOOR.getValue());
		batch.draw(sprite, scale * 0, scale * 0, scale * sprite.getWidth(), scale * sprite.getHeight());
    }

    private void renderCeiling(float scale) {
        Sprite sprite = spriteManager.getSprite(CEILING.getValue());
		batch.draw(sprite, scale * 0, scale * 97, scale * sprite.getWidth(), scale * sprite.getHeight());
    }
}
