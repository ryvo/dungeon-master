package cz.ryvo.dm.renderer;

import cz.ryvo.dm.Position2D;
import cz.ryvo.dm.domain.DirectionEnum;
import cz.ryvo.dm.domain.SquareVisualLocationEnum;
import cz.ryvo.dm.domain.map.Level;
import cz.ryvo.dm.domain.map.Square;
import cz.ryvo.dm.util.MapUtils;

import static cz.ryvo.dm.domain.SquareVisualLocationEnum.FAR_LEFT_2;
import static cz.ryvo.dm.domain.SquareVisualLocationEnum.FAR_LEFT_3;
import static cz.ryvo.dm.domain.SquareVisualLocationEnum.FAR_RIGHT_2;
import static cz.ryvo.dm.domain.SquareVisualLocationEnum.FAR_RIGHT_3;
import static cz.ryvo.dm.domain.SquareVisualLocationEnum.FRONT_1;
import static cz.ryvo.dm.domain.SquareVisualLocationEnum.FRONT_2;
import static cz.ryvo.dm.domain.SquareVisualLocationEnum.FRONT_3;
import static cz.ryvo.dm.domain.SquareVisualLocationEnum.LEFT_0;
import static cz.ryvo.dm.domain.SquareVisualLocationEnum.LEFT_1;
import static cz.ryvo.dm.domain.SquareVisualLocationEnum.LEFT_2;
import static cz.ryvo.dm.domain.SquareVisualLocationEnum.LEFT_3;
import static cz.ryvo.dm.domain.SquareVisualLocationEnum.RIGHT_0;
import static cz.ryvo.dm.domain.SquareVisualLocationEnum.RIGHT_1;
import static cz.ryvo.dm.domain.SquareVisualLocationEnum.RIGHT_2;
import static cz.ryvo.dm.domain.SquareVisualLocationEnum.RIGHT_3;

public class DungeonRenderer {

    private final SquareVisualLocationEnum[] squareRenderingOrder = {
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


    public void render(Level level, Position2D partyPosition, DirectionEnum partyDirection) {
        Square[][] squares = MapUtils.getVisibleSquares(level, partyPosition, partyDirection);

        for (SquareVisualLocationEnum location: squareRenderingOrder) {
            Square square = squares[location.getPosition().x][location.getPosition().y];
            if (square != null) {
                square.render(SquareVisualLocationEnum location);
            }
        }
    }

}
