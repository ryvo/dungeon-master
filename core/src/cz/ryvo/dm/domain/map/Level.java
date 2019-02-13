package cz.ryvo.dm.domain.map;

import java.io.DataOutputStream;
import java.io.IOException;

import static java.lang.String.format;

public class Level extends Saveable {

    Square[][] squares;

    public Level(int xSize, int ySize) {
        if (xSize < 3 || ySize < 3) {
            throw new IllegalArgumentException("The size of the level is too small. Minimum size of a level is 3x3.");
        }
        if (xSize > 255 || ySize > 255) {
            throw new IllegalArgumentException("The size of the level is too large. Maximum size of a level is 255x255.");
        }
        squares = new Square[xSize][ySize];
    }

    public int getSizeX() {
        return squares.length;
    }

    public int getSizeY() {
        return squares[0].length;
    }

    public Square getSquare(int x, int y) {
        if(x < 0 || x >= getSizeX() || y < 0 || y >= getSizeY()) {
            throw new ArrayIndexOutOfBoundsException(format("Requested square is out of the level bounds. Requested square at position (%d,%d). The size of the level is (%d, %d).", x, y, squares[y].length, squares.length));
        }
        return squares[x][y];
    }

    public void setSquare(int x, int y, Square square) {
        if(x < 0 || x >= getSizeX() || y < 0 || y >= getSizeY()) {
            throw new ArrayIndexOutOfBoundsException(format("Requested square is out of the level bounds. Requested square at position (%d,%d). The size of the level is (%d, %d).", x, y, squares[y].length, squares.length));
        }
        squares[x][y] = square;
    }

    @Override
    public void saveData(DataOutputStream out) throws IOException {
        out.writeByte(getSizeX());
        out.writeByte(getSizeY());
        for (int x = 0; x < getSizeX(); x++) {
            for (int y = 0; y < getSizeX(); y++) {
                out.write(squares[x][y].getData());
            }
        }
    }
}
