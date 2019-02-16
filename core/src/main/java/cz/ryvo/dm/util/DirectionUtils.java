package cz.ryvo.dm.util;

import cz.ryvo.dm.domain.DirectionEnum;

import static cz.ryvo.dm.domain.DirectionEnum.EAST;
import static cz.ryvo.dm.domain.DirectionEnum.WEST;

public class DirectionUtils {

    public static boolean isEastOrWest(DirectionEnum direction) {
        return direction == EAST || direction == WEST;
    }

    public static boolean isSouthOrNorth(DirectionEnum direction) {
        return !isEastOrWest(direction);
    }
}
