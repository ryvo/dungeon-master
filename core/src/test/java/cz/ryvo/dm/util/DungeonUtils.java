package cz.ryvo.dm.util;

import cz.ryvo.dm.domain.map.Area;
import cz.ryvo.dm.domain.map.Block;
import cz.ryvo.dm.domain.map.Dungeon;
import cz.ryvo.dm.domain.map.Level;
import cz.ryvo.dm.domain.map.Square;
import cz.ryvo.dm.domain.map.Square.SquareType;

public class DungeonUtils {

    // array[x][y]
    private static int[][] levelInts = {
            {1,1,1,1,1,1,1},
            {1,0,0,0,0,0,1},
            {1,1,1,0,1,1,1},
            {1,0,0,0,0,0,1},
            {1,0,0,0,0,0,1},
            {1,0,0,0,0,0,1},
            {1,1,1,1,1,1,1},
    };

    private static Square intToSquare(int i) {
        SquareType squareType = SquareType.fromCode(i);
        switch (squareType) {
            case AREA:
                return new Area();
            case BLOCK:
                return new Block();
        }
        throw new InternalError(String.format("Unsupported SquareType '%s'.", squareType.name()));
    }

    private static Square[][] intsToSquares(int[][] ints) {
        Square[][] squares = new Square[ints.length][ints[0].length];
        for (int x = 0; x < squares.length; x++) {
            for (int y = 0; y < squares[x].length; y++) {
                squares[x][y] = intToSquare(ints[x][y]);
            }
        }
        return squares;
    }

    public static Dungeon createDungeon() {
        Level[] levels = { new Level(intsToSquares(levelInts)) };
        Dungeon dungeon = new Dungeon(levels);
        return dungeon;
    }
}
