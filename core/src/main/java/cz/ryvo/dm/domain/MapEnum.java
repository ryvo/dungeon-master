package cz.ryvo.dm.domain;

public enum MapEnum {
    CEILING("ceiling"),
    FLOOR("floor"),
    WALL_FRONT_1("wall-front-1"),
    WALL_FRONT_2("wall-front-2"),
    WALL_FRONT_3("wall-front-3"),
    WALL_LEFT_0("wall-left-0"),
    WALL_LEFT_1("wall-left-1"),
    WALL_LEFT_2("wall-left-2"),
    WALL_LEFT_3("wall-left-3"),
    WALL_RIGHT_0("wall-right-0"),
    WALL_RIGHT_1("wall-right-1"),
    WALL_RIGHT_2("wall-right-2"),
    WALL_RIGHT_3("wall-right-3"),
    WALL_FAR_LEFT_2("wall-far-left-2"),
    WALL_FAR_LEFT_3("wall-far-left-3"),
    WALL_FAR_RIGHT_2("wall-far-right-2"),
    WALL_FAR_RIGHT_3("wall-far-right-3");

    private String value;

    MapEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public MapEnum byValue(String value) {
        for(MapEnum mapEnum: MapEnum.values()) {
            if (mapEnum.value.equals(value)) return mapEnum;
        }
        throw new IllegalArgumentException("Illegal MapEnum value");
    }
}

