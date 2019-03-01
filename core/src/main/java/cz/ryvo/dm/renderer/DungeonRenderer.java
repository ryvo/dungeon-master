package cz.ryvo.dm.renderer;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import cz.ryvo.dm.domain.DirectionEnum;
import cz.ryvo.dm.domain.Party;
import cz.ryvo.dm.domain.Vector3D;
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

    public void render(Level level, Party party, float scale) {
        renderCeiling(scale, party.evenStep);
        renderFloor(scale, party.evenStep);
        Square[][] squares = MapUtils.getVisibleSquares(level, party.position.x, party.position.y, party.direction);
        for (VisibleAreaSquareLocationEnum location: squareRenderingOrder) {
            Square square = squares[location.getSquarePosition().x][location.getSquarePosition().y];
            square.render(batch, spriteManager, location, party.evenStep, scale);
        }
    }

    private void renderFloor(float scale, boolean evenStep) {
        String spriteName = FLOOR.getValue().concat((evenStep) ? "-alt" : "");
        Sprite sprite = spriteManager.getSprite(spriteName);
        batch.draw(sprite, scale * 0, scale * 0, scale * sprite.getWidth(), scale * sprite.getHeight());
    }

    private void renderCeiling(float scale, boolean evenStep) {
        String spriteName = CEILING.getValue().concat((evenStep) ? "-alt" : "");
        Sprite sprite = spriteManager.getSprite(spriteName);
		batch.draw(sprite, scale * 0, scale * 97, scale * sprite.getWidth(), scale * sprite.getHeight());
    }
}
