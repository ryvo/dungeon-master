package cz.ryvo.dm.domain.map;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public abstract class Saveable {

    byte[] getData() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        saveData(dos);
        return baos.toByteArray();
    }

    abstract void saveData(DataOutputStream out) throws IOException;

//    void setData(byte[] data) {
//    }
}
