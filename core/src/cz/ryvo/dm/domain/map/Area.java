package cz.ryvo.dm.domain.map;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import static cz.ryvo.dm.domain.map.Square.SquareType.AREA;

public final class Area extends Square {

    Side floor;

    Side ceiling;

    public Area() {
        type = AREA;
    }

    @Override
    public void saveData(DataOutputStream out) throws IOException {
        out.writeByte(type.getCode());
    }
}
