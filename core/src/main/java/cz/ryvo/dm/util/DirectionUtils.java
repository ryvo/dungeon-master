package cz.ryvo.dm.util;

import java.util.TreeSet;

import cz.ryvo.dm.domain.DirectionEnum;

import static cz.ryvo.dm.domain.DirectionEnum.EAST;
import static cz.ryvo.dm.domain.DirectionEnum.NORTH;
import static cz.ryvo.dm.domain.DirectionEnum.SOUTH;
import static cz.ryvo.dm.domain.DirectionEnum.WEST;

public class DirectionUtils {

    private static TreeSet<DirectionEnum> directions;

    static {
        directions = new TreeSet<>();
        directions.add(NORTH);
        directions.add(WEST);
        directions.add(SOUTH);
        directions.add(EAST);
    }

    public static DirectionEnum leftDirection(DirectionEnum direction) {
        DirectionEnum leftDirection = directions.higher(direction);
        return (leftDirection != null) ? leftDirection : directions.first();
    }

    public static DirectionEnum rightDirection(DirectionEnum direction) {
        DirectionEnum rightDirection = directions.lower(direction);
        return (rightDirection != null) ? rightDirection : directions.last();
    }
}
