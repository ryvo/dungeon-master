package cz.ryvo.dm.domain.map;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ExperimentalDungeonCreator {

    public Dungeon createDungeon() {
        Dungeon dungeon = new Dungeon();
        Level level = new Level(7, 7);

        Area area = new Area();
        for (int x = 0; x < level.getSizeX(); x++) {
            for (int y = 0; y < level.getSizeY(); y++) {
                level.setSquare(x, y, area);
            }
        }

        Wall wall = new Wall();
        Block block = new Block();
        block.north = wall;
        block.west = wall;
        block.south = wall;
        block.east = wall;

        for (int x = 0; x < level.getSizeX(); x++) {
            level.setSquare(x, 0, block);
            level.setSquare(x, level.getSizeY() - 1, block);
        }

        for (int y = 0; y < level.getSizeY(); y++) {
            level.setSquare(0, y, block);
            level.setSquare(level.getSizeX() - 1, y, block);
        }

        level.setSquare(2, 1, block);
        level.setSquare(2, 2, block);
        level.setSquare(2, 4, block);
        level.setSquare(2, 5, block);

        dungeon.levels = new Level[] {level};

        return dungeon;
    }

    public void serialize() throws IOException {
        FileOutputStream fileOut =
        new FileOutputStream("c:\\5\\dungeon.dat");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        Dungeon dungeon = createDungeon();
        out.writeObject(dungeon);
        out.close();
        fileOut.close();
/*
        File file = new File("c:\\5\\dungeon.dat");
        FileOutputStream fos = new FileOutputStream(file);
        try {
            Dungeon dungeon = createDungeon();
            fos.write(dungeon.getData());
        } finally {
            fos.close();
        }
*/
    }
}
