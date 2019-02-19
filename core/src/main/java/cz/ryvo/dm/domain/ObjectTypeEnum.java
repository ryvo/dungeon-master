package cz.ryvo.dm.domain;

public enum ObjectTypeEnum {
    VOID(""),
    CEILING("ceiling"),
    FLOOR("floor"),
    WALL("wall");

    private String value;

    ObjectTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
