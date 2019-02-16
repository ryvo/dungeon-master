package cz.ryvo.dm.util;

import cz.ryvo.dm.Position2D;
import cz.ryvo.dm.domain.DirectionEnum;
import cz.ryvo.dm.domain.map.Level;
import cz.ryvo.dm.domain.map.Square;

import static cz.ryvo.dm.util.DirectionUtils.isEastOrWest;

public class MapUtils {

    public static Square[][] getVisibleSquares(Level level, Position2D partyPosition, DirectionEnum partyDirection) {
        return null;
    }

    static Square[][] getVisibleSquaresNorth(Level level, Position2D partyPosition) {
        Square[][] visibleSquares = new Square[5][4];
        for (int i = 0; i < 5; i++) {
            int x = partyPosition.x + i - 2;
            for (int j = 0; j < 4; j++) {
                int y = partyPosition.y + j;
                if (x >= 0 && x < level.getSizeX() && y >= 0 && y < level.getSizeY()) {
                    visibleSquares[i][j] = level.getSquare(x, y);
                }
            }
        }
        return visibleSquares;
    }

    static Square[][] getVisibleSquaresWest(Level level, Position2D partyPosition) {
        Square[][] visibleSquares = new Square[5][4];
        for (int i = 0; i < 4; i++) {
            int x = partyPosition.x - i;
            for (int j = 0; j < 5; j++) {
                int y = partyPosition.y - 2 + j;
                if (x >= 0 && x < level.getSizeX() && y >= 0 && y < level.getSizeY()) {
                    visibleSquares[j][i] = level.getSquare(x, y);
                }
            }
        }
        return visibleSquares;
    }

    static Square[][] getVisibleSquaresSouth(Level level, Position2D partyPosition) {
        Square[][] visibleSquares = new Square[5][4];
        for (int i = 0; i < 5; i++) {
            int x = partyPosition.x + i - 2;
            for (int j = 0; j < 4; j++) {
                int y = partyPosition.y - j;
                if (x >= 0 && x < level.getSizeX() && y >= 0 && y < level.getSizeY()) {
                    visibleSquares[4 - i][j] = level.getSquare(x, y);
                }
            }
        }
        return visibleSquares;
    }

    static Square[][] getVisibleSquaresEast(Level level, Position2D partyPosition) {
        Square[][] visibleSquares = new Square[5][4];
        for (int i = 0; i < 4; i++) {
            int x = partyPosition.x + i;
            for (int j = 0; j < 5; j++) {
                int y = partyPosition.y + j - 2;
                if (x >= 0 && x < level.getSizeX() && y >= 0 && y < level.getSizeY()) {
                    visibleSquares[j][i] = level.getSquare(x, y);
                }
            }
        }
        return visibleSquares;
    }
}
