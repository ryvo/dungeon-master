package cz.ryvo.dm.domain.map;

import static cz.ryvo.dm.domain.ObjectTypeEnum.VOID;

public final class Area extends Square {

    Side floor;

    Side ceiling;

    public Area() {
        type = VOID;
    }

    @Override
    public boolean canPartyWalkIn() {
        return true;
    }

    @Override
    public boolean canPartyWalkOut() {
        return true;
    }
}
