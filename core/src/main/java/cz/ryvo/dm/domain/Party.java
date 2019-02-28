package cz.ryvo.dm.domain;

import cz.ryvo.dm.util.DirectionUtils;

public class Party {

    private float timeCounter;

    public float speed = 3f;

    public DirectionEnum direction = DirectionEnum.NORTH;

    public Vector3D position = new Vector3D(1, 1, 0);

    public void updateParty(float deltaTime) {
        timeCounter += deltaTime;
    }

    public boolean canMove() {
        return timeCounter > 1 / speed;
    }

    public void moveForward() {
        resetTimeCounter();
    }

    public void moveBackward() {
        resetTimeCounter();
    }

    public void turnLeft() {
        direction = DirectionUtils.leftDirection(direction);
        resetTimeCounter();
    }

    public void turnRight() {
        direction = DirectionUtils.rightDirection(direction);
        resetTimeCounter();
    }

    private void resetTimeCounter() {
        timeCounter = 0;
    }
}
