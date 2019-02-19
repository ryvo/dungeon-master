package cz.ryvo.dm.util;

import cz.ryvo.dm.domain.map.Dungeon;
import cz.ryvo.dm.domain.map.ExperimentalDungeonCreator;

public class DungeonUtils {

    public static Dungeon createDungeon() {
        ExperimentalDungeonCreator creator = new ExperimentalDungeonCreator();
        Dungeon dungeon = creator.createDungeon();
        return dungeon;
    }
}
