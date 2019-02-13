package cz.ryvo.dm.domain.map;

public abstract class Square extends Saveable {

    protected SquareType type;

    public enum SquareType {
        AREA(0),
        BLOCK(2);

        private int code;

        SquareType(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }
    }
}
