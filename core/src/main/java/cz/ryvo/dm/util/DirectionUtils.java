package cz.ryvo.dm.util;

import java.util.TreeSet;

import cz.ryvo.dm.domain.DirectionEnum;
import cz.ryvo.dm.domain.WalkActionEnum;

import static cz.ryvo.dm.domain.DirectionEnum.EAST;
import static cz.ryvo.dm.domain.DirectionEnum.NORTH;
import static cz.ryvo.dm.domain.DirectionEnum.SOUTH;
import static cz.ryvo.dm.domain.DirectionEnum.WEST;
import static java.lang.String.format;

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

    public static DirectionEnum rearDirection(DirectionEnum direction) {
        return rightDirection(rightDirection(direction));
    }

    public static DirectionEnum getMovementDirection(DirectionEnum direction, WalkActionEnum walkAction) {
        switch (walkAction) {
            case STEP_FORWARD:
                return direction;
            case STEP_BACKWARD:
                return rearDirection(direction);
            case TURN_LEFT:
            case STRAFE_LEFT:
                return leftDirection(direction);
            case TURN_RIGHT:
            case STRAFE_RIGHT:
                return rightDirection(direction);
            default:
                throw new IllegalArgumentException(format("Unsupported movement '%s'.", walkAction.name()));
        }
    }
}