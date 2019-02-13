package cz.ryvo.dm.domain.map;

import java.io.DataOutputStream;
import java.io.IOException;

import static java.lang.String.format;

public class Dungeon extends Saveable {

    Level[] levels;

    public Level getLevel(int z) {
        if (z < 0 || z >= levels.length) {
            throw new ArrayIndexOutOfBoundsException(format("Requested level is out of the dungeon bounds. Requested level %d. The size of the dungeon is %d.", z, levels.length));
        }
        return levels[z];
    }

    @Override
    void saveData(DataOutputStream out) throws IOException {
        for (Level level: levels) {
            out.write(level.getData());
        }
    }
}
