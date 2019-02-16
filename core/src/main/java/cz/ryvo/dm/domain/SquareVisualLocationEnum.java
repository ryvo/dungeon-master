package cz.ryvo.dm.domain;

import cz.ryvo.dm.Position2D;

public enum SquareVisualLocationEnum {
    FRONT_1("front-1", new Position2D(2, 1)),
    FRONT_2("front-2", new Position2D(2, 2)),
    FRONT_3("front-3", new Position2D(2, 3)),
    LEFT_0("left-0", new Position2D(1, 0)),
    LEFT_1("left-1", new Position2D(1, 1)),
    LEFT_2("left-2", new Position2D(1, 2)),
    LEFT_3("left-3", new Position2D(1, 3)),
    FAR_LEFT_2("far-left-2", new Position2D(0, 2)),
    FAR_LEFT_3("far-left-3", new Position2D(0, 3)),
    RIGHT_0("right-0", new Position2D(3, 0)),
    RIGHT_1("right-1", new Position2D(3, 1)),
    RIGHT_2("right-2", new Position2D(3, 2)),
    RIGHT_3("right-3", new Position2D(3, 3)),
    FAR_RIGHT_2("far-right-2", new Position2D(4, 2)),
    FAR_RIGHT_3("far-right-3", new Position2D(4, 3));

    private String value;
    private Position2D position;

    SquareVisualLocationEnum(String value, Position2D position) {
        this.value = value;
        this.position = position;
    }

    public String getValue() {
        return this.value;
    }

    public Position2D getPosition() {
        return position;
    }
}