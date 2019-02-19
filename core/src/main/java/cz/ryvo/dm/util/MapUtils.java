package cz.ryvo.dm.util;

import cz.ryvo.dm.domain.DirectionEnum;
import cz.ryvo.dm.domain.map.Block;
import cz.ryvo.dm.domain.map.Level;
import cz.ryvo.dm.domain.map.Square;

public class MapUtils {

    private static final Block PLAIN_BLOCK = new Block();

    public static Square[][] getVisibleSquares(Level level, int partyX, int partyY, DirectionEnum partyDirection) {
        switch (partyDirection) {
            case NORTH:
                return getVisibleSquaresNorth(level, partyX, partyY);
            case WEST:
                return getVisibleSquaresWest(level, partyX, partyY);
            case SOUTH:
                return getVisibleSquaresSouth(level, partyX, partyY);
            case EAST:
                return getVisibleSquaresEast(level, partyX, partyY);
            default:
                throw new IllegalArgumentException(String.format("Unknown direction '%s'.", partyDirection.name()));
        }
    }

    static Square[][] getVisibleSquaresNorth(Level level, int partyX, int partyY) {
        Square[][] visibleSquares = new Square[5][4];
        for (int i = 0; i < 5; i++) {
            int x = partyX + i - 2;
            for (int j = 0; j < 4; j++) {
                int y = partyY + j;
                visibleSquares[i][j] = isWithinLevelBounds(x, y, level) ? level.getSquare(x, y) : PLAIN_BLOCK;
            }
        }
        return visibleSquares;
    }

    static Square[][] getVisibleSquaresWest(Level level, int partyX, int partyY) {
        Square[][] visibleSquares = new Square[5][4];
        for (int i = 0; i < 4; i++) {
            int x = partyX - i;
            for (int j = 0; j < 5; j++) {
                int y = partyY - 2 + j;
                visibleSquares[j][i] = isWithinLevelBounds(x, y, level) ? level.getSquare(x, y) : PLAIN_BLOCK;
            }
        }
        return visibleSquares;
    }

    static Square[][] getVisibleSquaresSouth(Level level, int partyX, int partyY) {
        Square[][] visibleSquares = new Square[5][4];
        for (int i = 0; i < 5; i++) {
            int x = partyX + i - 2;
            for (int j = 0; j < 4; j++) {
                int y = partyY - j;
                visibleSquares[4 - i][j] = isWithinLevelBounds(x, y, level) ? level.getSquare(x, y) : PLAIN_BLOCK;
            }
        }
        return visibleSquares;
    }

    static Square[][] getVisibleSquaresEast(Level level, int partyX, int partyY) {
        Square[][] visibleSquares = new Square[5][4];
        for (int i = 0; i < 4; i++) {
            int x = partyX + i;
            for (int j = 0; j < 5; j++) {
                int y = partyY + 2 - j;
                visibleSquares[j][i] = isWithinLevelBounds(x, y, level) ? level.getSquare(x, y) : PLAIN_BLOCK;
            }
        }
        return visibleSquares;
    }

    private static boolean isWithinLevelBounds(int x, int y, Level level) {
        return x >= 0 && x < level.getSizeX() && y >= 0 && y < level.getSizeY();
    }
}
