package cz.ryvo.dm.action;

import cz.ryvo.dm.domain.MovementEnum;

public class MoveAction {
    public MovementEnum movement;

    public MoveAction(MovementEnum movement) {
        this.movement = movement;
    }
}
