package cz.ryvo.dm.domain;

import cz.ryvo.dm.util.DirectionUtils;

public class Party {

    private float timeCounter;

    public float speed = 3f;

    public DirectionEnum direction = DirectionEnum.NORTH;

    public Position3D position = new Position3D(1, 1, 0);

    public void updateParty(float deltaTime) {
        timeCounter += deltaTime;
    }

    public boolean canMove() {
        return timeCounter > 1 / speed;
    }

    public void moveForward() {
        switch (direction) {
            case NORTH:
                position.y++;
                break;
            case WEST:
                position.x--;
                break;
            case SOUTH:
                position.y--;
                break;
            case EAST:
                position.x++;
                break;
        }
        resetTimeCounter();
    }

    public void moveBackward() {
        switch (direction) {
            case NORTH:
                position.y--;
                break;
            case WEST:
                position.x++;
                break;
            case SOUTH:
                position.y++;
                break;
            case EAST:
                position.x--;
                break;
        }
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
