package cz.ryvo.dm.domain.map;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import static cz.ryvo.dm.domain.map.Square.SquareType.BLOCK;

public final class Block extends Square {

    Side north;

    Side west;

    Side south;

    Side east;

    public Block() {
        type = BLOCK;
    }

    @Override
    public void saveData(DataOutputStream out) throws IOException {
        out.writeByte(type.getCode());
    }
}
