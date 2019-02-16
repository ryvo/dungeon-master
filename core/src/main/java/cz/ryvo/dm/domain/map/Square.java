package cz.ryvo.dm.domain.map;

import java.io.Serializable;

import cz.ryvo.dm.domain.SquareVisualLocationEnum;

public abstract class Square implements Serializable {

    protected SquareType type;

    public SquareType getType() {
        return type;
    }

    public abstract void render(SquareVisualLocationEnum location);

    public enum SquareType {
        AREA(0),
        BLOCK(1);

        private int code;

        SquareType(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }

        public static SquareType fromCode(int code) {
            for (SquareType squareType: SquareType.values()) {
                if (squareType.getCode() == code) return squareType;
            }
            throw new IllegalArgumentException(String.format("Unknown SquareType '%d'.", code));
        }
    }
}
