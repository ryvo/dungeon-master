package cz.ryvo.dm.domain;

import com.badlogic.gdx.math.Rectangle;

public enum VisibleAreaSquareLocationEnum {
    FRONT_1("front-1",         new Position2D(2, 1), new Rectangle(32, 16, 160, 111)),
    FRONT_2("front-2",         new Position2D(2, 2), new Rectangle(59, 43, 106, 74)),
    FRONT_3("front-3",         new Position2D(2, 3), new Rectangle(78, 62, 70, 49)),
    LEFT_0("left-0",           new Position2D(1, 0), new Rectangle(0, 0, 33, 136)),
    LEFT_1("left-1",           new Position2D(1, 1), new Rectangle(0, 16, 60, 111)),
    LEFT_2("left-2",           new Position2D(1, 2), new Rectangle(0, 43, 78, 74)),
    LEFT_3("left-3",           new Position2D(1, 3), new Rectangle(7, 62, 83, 49)),
    RIGHT_0("right-0",         new Position2D(3, 0), new Rectangle(191, 0, 33, 136)),
    RIGHT_1("right-1",         new Position2D(3, 1), new Rectangle(164, 16, 60, 111)),
    RIGHT_2("right-2",         new Position2D(3, 2), new Rectangle(146, 43, 78, 74)),
    RIGHT_3("right-3",         new Position2D(3, 3), new Rectangle(134, 62, 83, 49)),
    FAR_LEFT_2("far-left-2",   new Position2D(0, 2), new Rectangle(0, 60, 8, 52)),
    FAR_LEFT_3("far-left-3",   new Position2D(0, 3), new Rectangle(0, 62, 44, 49)),
    FAR_RIGHT_2("far-right-2", new Position2D(4, 2), new Rectangle(216, 60, 8, 52)),
    FAR_RIGHT_3("far-right-3", new Position2D(4, 3), new Rectangle(180, 62, 44, 49));

    //		sprite = mapSprites.get(WALL_LEFT_1);
//		batch.draw(sprite, SCALE * 0, SCALE * 16, SCALE * sprite.getWidth(), SCALE * sprite.getHeight());

    //		sprite = mapSprites.get(WALL_FRONT_3);
//		batch.draw(sprite, SCALE * 78, SCALE * 62, SCALE * sprite.getWidth(), SCALE * sprite.getHeight());
//		sprite = mapSprites.get(WALL_FRONT_2);
//		batch.draw(sprite, SCALE * 60, SCALE * 43, SCALE * sprite.getWidth(), SCALE * sprite.getHeight());
//		sprite = mapSprites.get(WALL_FRONT_1);
//		batch.draw(sprite, SCALE * 32, SCALE * 16, SCALE * sprite.getWidth(), SCALE * sprite.getHeight());

    private String resourceName;
    private Position2D squarePosition;
    private Rectangle drawingRectangle;

    VisibleAreaSquareLocationEnum(String resourceName, Position2D squarePosition, Rectangle drawingRectangle) {
        this.resourceName = resourceName;
        this.squarePosition = squarePosition;
        this.drawingRectangle = drawingRectangle;
    }

    public String getResourceName() {
        return this.resourceName;
    }

    public Position2D getSquarePosition() {
        return squarePosition;
    }

    public Rectangle getDrawingRectangle() {
        return drawingRectangle;
    }
}