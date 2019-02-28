package cz.ryvo.dm.util;

import com.badlogic.gdx.math.Vector3;

import cz.ryvo.dm.domain.DirectionEnum;
import cz.ryvo.dm.domain.MovementEnum;
import cz.ryvo.dm.domain.Vector3D;

import static cz.ryvo.dm.util.DirectionUtils.getMovementDirection;
import static java.lang.String.format;

public class PartyUtils {

    public static Vector3D getForwardMovementVector(DirectionEnum direction, MovementEnum movement) {
        return getMovementVector(getMovementDirection(direction, movement));
    }

    public static Vector3D updatePosition(Vector3D partyPosition, Vector3D delta) {
        return new Vector3D(partyPosition.x + delta.x, partyPosition.y + delta.y, partyPosition.z + delta.z);
    }

    private static Vector3D getMovementVector(DirectionEnum direction) {
        switch (direction) {
            case NORTH:
                return new Vector3D(0, 1, 0);
            case WEST:
                return new Vector3D(-1, 0, 0);
            case SOUTH:
                return new Vector3D(0, -1, 0);
            case EAST:
                return new Vector3D(1, 0, 0);
            default:
                throw new IllegalArgumentException(format("Unsupported direction '%s'.", direction.name()));
        }
    }
}