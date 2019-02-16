package cz.ryvo.dm.util;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import cz.ryvo.dm.Position2D;
import cz.ryvo.dm.domain.map.Area;
import cz.ryvo.dm.domain.map.Block;
import cz.ryvo.dm.domain.map.Dungeon;
import cz.ryvo.dm.domain.map.Square;

@RunWith(JUnit4.class)
public class MapUtilsTest {

    @Test
    public void getVisibleSquaresNorthTest() {
        Dungeon dungeon = DungeonUtils.createDungeon();
        Square[][] squares = MapUtils.getVisibleSquaresNorth(dungeon.getLevel(0), new Position2D(2, 3));
        Assert.assertEquals(squares.length, 5);
        Assert.assertEquals(squares[0].length, 4);

        Assert.assertTrue(squares[0][0] instanceof Block);
        Assert.assertTrue(squares[0][1] instanceof Block);
        Assert.assertTrue(squares[0][2] instanceof Block);
        Assert.assertTrue(squares[0][3] instanceof Block);

        Assert.assertTrue(squares[1][0] instanceof Area);
        Assert.assertTrue(squares[1][1] instanceof Area);
        Assert.assertTrue(squares[1][2] instanceof Area);
        Assert.assertTrue(squares[1][3] instanceof Block);

        Assert.assertTrue(squares[2][0] instanceof Area);
        Assert.assertTrue(squares[2][1] instanceof Block);
        Assert.assertTrue(squares[2][2] instanceof Block);
        Assert.assertTrue(squares[2][3] instanceof Block);

        Assert.assertTrue(squares[3][0] instanceof Area);
        Assert.assertTrue(squares[3][1] instanceof Area);
        Assert.assertTrue(squares[3][2] instanceof Area);
        Assert.assertTrue(squares[3][3] instanceof Block);

        Assert.assertTrue(squares[4][0] instanceof Area);
        Assert.assertTrue(squares[4][1] instanceof Area);
        Assert.assertTrue(squares[4][2] instanceof Area);
        Assert.assertTrue(squares[4][3] instanceof Block);
    }

    @Test
    public void getVisibleSquaresWestTest() {
        Dungeon dungeon = DungeonUtils.createDungeon();
        Square[][] squares = MapUtils.getVisibleSquaresWest(dungeon.getLevel(0), new Position2D(4, 4));
        Assert.assertEquals(squares.length, 5);
        Assert.assertEquals(squares[0].length, 4);

        Assert.assertTrue(squares[0][0] instanceof Area);
        Assert.assertTrue(squares[0][1] instanceof Area);
        Assert.assertTrue(squares[0][2] instanceof Block);
        Assert.assertTrue(squares[0][3] instanceof Area);

        Assert.assertTrue(squares[1][0] instanceof Area);
        Assert.assertTrue(squares[1][1] instanceof Area);
        Assert.assertTrue(squares[1][2] instanceof Area);
        Assert.assertTrue(squares[1][3] instanceof Area);

        Assert.assertTrue(squares[2][0] instanceof Area);
        Assert.assertTrue(squares[2][1] instanceof Area);
        Assert.assertTrue(squares[2][2] instanceof Block);
        Assert.assertTrue(squares[2][3] instanceof Area);

        Assert.assertTrue(squares[3][0] instanceof Area);
        Assert.assertTrue(squares[3][1] instanceof Area);
        Assert.assertTrue(squares[3][2] instanceof Block);
        Assert.assertTrue(squares[3][3] instanceof Area);

        Assert.assertTrue(squares[4][0] instanceof Block);
        Assert.assertTrue(squares[4][1] instanceof Block);
        Assert.assertTrue(squares[4][2] instanceof Block);
        Assert.assertTrue(squares[4][3] instanceof Block);
    }

    @Test
    public void getVisibleSquaresSouthTest() {
        Dungeon dungeon = DungeonUtils.createDungeon();
        Square[][] squares = MapUtils.getVisibleSquaresSouth(dungeon.getLevel(0), new Position2D(3, 3));
        Assert.assertEquals(squares.length, 5);
        Assert.assertEquals(squares[0].length, 4);

        Assert.assertTrue(squares[0][0] instanceof Area);
        Assert.assertTrue(squares[0][1] instanceof Area);
        Assert.assertTrue(squares[0][2] instanceof Area);
        Assert.assertTrue(squares[0][3] instanceof Block);

        Assert.assertTrue(squares[1][0] instanceof Area);
        Assert.assertTrue(squares[1][1] instanceof Area);
        Assert.assertTrue(squares[1][2] instanceof Area);
        Assert.assertTrue(squares[1][3] instanceof Block);

        Assert.assertTrue(squares[2][0] instanceof Area);
        Assert.assertTrue(squares[2][1] instanceof Area);
        Assert.assertTrue(squares[2][2] instanceof Area);
        Assert.assertTrue(squares[2][3] instanceof Block);

        Assert.assertTrue(squares[3][0] instanceof Area);
        Assert.assertTrue(squares[3][1] instanceof Block);
        Assert.assertTrue(squares[3][2] instanceof Block);
        Assert.assertTrue(squares[3][3] instanceof Block);

        Assert.assertTrue(squares[4][0] instanceof Area);
        Assert.assertTrue(squares[4][1] instanceof Area);
        Assert.assertTrue(squares[4][2] instanceof Area);
        Assert.assertTrue(squares[4][3] instanceof Block);
    }

    @Test
    public void getVisibleSquaresEastTest() {
        Dungeon dungeon = DungeonUtils.createDungeon();
        Square[][] squares = MapUtils.getVisibleSquaresEast(dungeon.getLevel(0), new Position2D(1, 3));
        Assert.assertEquals(squares.length, 5);
        Assert.assertEquals(squares[0].length, 4);

        Assert.assertTrue(squares[0][0] instanceof Area);
        Assert.assertTrue(squares[0][1] instanceof Block);
        Assert.assertTrue(squares[0][2] instanceof Area);
        Assert.assertTrue(squares[0][3] instanceof Area);

        Assert.assertTrue(squares[1][0] instanceof Area);
        Assert.assertTrue(squares[1][1] instanceof Block);
        Assert.assertTrue(squares[1][2] instanceof Area);
        Assert.assertTrue(squares[1][3] instanceof Area);

        Assert.assertTrue(squares[2][0] instanceof Area);
        Assert.assertTrue(squares[2][1] instanceof Area);
        Assert.assertTrue(squares[2][2] instanceof Area);
        Assert.assertTrue(squares[2][3] instanceof Area);

        Assert.assertTrue(squares[3][0] instanceof Area);
        Assert.assertTrue(squares[3][1] instanceof Block);
        Assert.assertTrue(squares[3][2] instanceof Area);
        Assert.assertTrue(squares[3][3] instanceof Area);

        Assert.assertTrue(squares[4][0] instanceof Area);
        Assert.assertTrue(squares[4][1] instanceof Block);
        Assert.assertTrue(squares[4][2] instanceof Area);
        Assert.assertTrue(squares[4][3] instanceof Area);
    }
}
