package cz.ryvo.dm.domain.map;

import java.io.Serializable;

import cz.ryvo.dm.domain.Vector3D;

import static java.lang.String.format;

public class Dungeon implements Serializable {

    Level[] levels;

    public Dungeon() {}

    public Dungeon(Level[] levels) {
        this.levels = levels;
    }

    public Level getLevel(int z) {
        if (z < 0 || z >= levels.length) {
            throw new ArrayIndexOutOfBoundsException(format("Requested level is out of the dungeon bounds. Requested level %d. The size of the dungeon is %d.", z, levels.length));
        }
        return levels[z];
    }

    public Square getSquare(Vector3D position) {
        return levels[position.z].getSquare(position.x, position.y);
    }
}
