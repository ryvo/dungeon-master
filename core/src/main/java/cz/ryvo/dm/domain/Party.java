package cz.ryvo.dm.domain;

import cz.ryvo.dm.domain.map.Dungeon;
import cz.ryvo.dm.domain.map.Square;

import static cz.ryvo.dm.domain.DirectionEnum.NORTH;
import static cz.ryvo.dm.util.DirectionUtils.leftDirection;
import static cz.ryvo.dm.util.DirectionUtils.rightDirection;
import static cz.ryvo.dm.util.PartyUtils.getWalkDeltaVector;
import static cz.ryvo.dm.util.PartyUtils.updatePosition;

public class Party {

    public Vector3D position;
    public DirectionEnum direction;
    private int walkTickCounter;
    private Dungeon dungeon;
    public boolean evenStep; // To support alternation of floor, ceiling and wall textures to make walking more realistic.

    public Party(Dungeon dungeon) {
        this.position = new Vector3D(1, 1, 0);
        this.direction = NORTH;
        this.dungeon = dungeon;
        this.evenStep = false;
    }

    /**
     * Returns number of ticks a party needs wait until it's able to make another step. Number of
     * tick may differ depending on the party shape (injuries, load, magic etc.)
     */
    private int getWalkTicks() {
        return 2;
    }

    private void restoreWalkTicks() {
        walkTickCounter = getWalkTicks();
    }

    public void tick() {
        if (walkTickCounter > 0) walkTickCounter--;
    }

    public boolean canWalk() {
        return walkTickCounter == 0;
    }

    public void doWalkAction(WalkActionEnum walkAction) {
        switch (walkAction) {
            case STEP_FORWARD:
            case STEP_BACKWARD:
            case STRAFE_LEFT:
            case STRAFE_RIGHT:
                walk(walkAction);
                break;
            case TURN_LEFT:
            case TURN_RIGHT:
                turn(walkAction);
        }
    }

    private void turn(WalkActionEnum walkAction) {
        restoreWalkTicks();
        switch (walkAction) {
            case TURN_LEFT:
                direction = leftDirection(direction);
                break;
            case TURN_RIGHT:
                direction = rightDirection(direction);
        }
        toggleEvenStep();
    }

    private void walk(WalkActionEnum walkAction) {
        restoreWalkTicks();
        Vector3D walkDelta = getWalkDeltaVector(direction, walkAction);
        Vector3D newPosition = updatePosition(position, walkDelta);
        Square currentSquare = dungeon.getSquare(position);
        Square newSquare = dungeon.getSquare(newPosition);
        if (currentSquare.canPartyWalkOut() && newSquare.canPartyWalkIn()) {
            position = newPosition;
            toggleEvenStep();
        }
    }

    private void toggleEvenStep() {
        evenStep = !evenStep;
    }
}
