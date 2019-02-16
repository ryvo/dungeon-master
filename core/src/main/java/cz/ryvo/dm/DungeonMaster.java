package cz.ryvo.dm;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import java.io.IOException;
import java.util.EnumMap;

import cz.ryvo.dm.domain.MapEnum;
import cz.ryvo.dm.domain.map.ExperimentalDungeonCreator;

import static cz.ryvo.dm.domain.MapEnum.CEILING;
import static cz.ryvo.dm.domain.MapEnum.FLOOR;
import static cz.ryvo.dm.domain.MapEnum.WALL_FAR_LEFT_2;
import static cz.ryvo.dm.domain.MapEnum.WALL_FAR_LEFT_3;
import static cz.ryvo.dm.domain.MapEnum.WALL_FAR_RIGHT_2;
import static cz.ryvo.dm.domain.MapEnum.WALL_FAR_RIGHT_3;

public class DungeonMaster extends ApplicationAdapter {

	private static final String ATLAS_FILE_NAME = "map.atlas";
	private static final Float SCALE = 4f;
	private static final int VIEW_WIDTH = 224;
	private static final int VIEW_HEIGHT = 224;

	SpriteBatch batch;
	AssetManager manager;
	EnumMap<MapEnum, Sprite> mapSprites;

	@Override
	public void create () {
		batch = new SpriteBatch();
		mapSprites = new EnumMap<MapEnum, Sprite>(MapEnum.class);

		manager = new AssetManager();
		manager.load("map.atlas", TextureAtlas.class);
		manager.finishLoading();

		TextureAtlas textureAtlas = manager.get(ATLAS_FILE_NAME, TextureAtlas.class);

		for(MapEnum mapEnum: MapEnum.values()) {
			Sprite sprite = textureAtlas.createSprite(mapEnum.getValue());
			//sprite.setBounds(0,0, SCALE * sprite.getWidth(), SCALE * sprite.getHeight());
			mapSprites.put(mapEnum, sprite);
		}

		ExperimentalDungeonCreator edc = new ExperimentalDungeonCreator();
		try {
			edc.serialize();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		Sprite sprite;
		sprite = mapSprites.get(FLOOR);
		batch.draw(sprite, SCALE * 0, SCALE * 0, SCALE * sprite.getWidth(), SCALE * sprite.getHeight());
		sprite = mapSprites.get(CEILING);
		batch.draw(sprite, SCALE * 0, SCALE * 97, SCALE * sprite.getWidth(), SCALE * sprite.getHeight());

//		sprite = mapSprites.get(WALL_FRONT_3);
//		batch.draw(sprite, SCALE * 78, SCALE * 62, SCALE * sprite.getWidth(), SCALE * sprite.getHeight());
//		sprite = mapSprites.get(WALL_FRONT_2);
//		batch.draw(sprite, SCALE * 60, SCALE * 43, SCALE * sprite.getWidth(), SCALE * sprite.getHeight());
//		sprite = mapSprites.get(WALL_FRONT_1);
//		batch.draw(sprite, SCALE * 32, SCALE * 16, SCALE * sprite.getWidth(), SCALE * sprite.getHeight());

//		sprite = mapSprites.get(WALL_LEFT_3);
//		batch.draw(sprite, SCALE * 7, SCALE * 62, SCALE * sprite.getWidth(), SCALE * sprite.getHeight());
//		sprite = mapSprites.get(WALL_LEFT_2);
//		batch.draw(sprite, SCALE * 0, SCALE * 43, SCALE * sprite.getWidth(), SCALE * sprite.getHeight());
//		sprite = mapSprites.get(WALL_LEFT_1);
//		batch.draw(sprite, SCALE * 0, SCALE * 16, SCALE * sprite.getWidth(), SCALE * sprite.getHeight());
//		sprite = mapSprites.get(WALL_LEFT_0);
//		batch.draw(sprite, SCALE * 0, SCALE * 0, SCALE * sprite.getWidth(), SCALE * sprite.getHeight());
//
//		sprite = mapSprites.get(WALL_RIGHT_3);
//		batch.draw(sprite, SCALE * 134, SCALE * 62, SCALE * sprite.getWidth(), SCALE * sprite.getHeight());
//		sprite = mapSprites.get(WALL_RIGHT_2);
//		batch.draw(sprite, SCALE * 146, SCALE * 43, SCALE * sprite.getWidth(), SCALE * sprite.getHeight());
//		sprite = mapSprites.get(WALL_RIGHT_1);
//		batch.draw(sprite, SCALE * 164, SCALE * 16, SCALE * sprite.getWidth(), SCALE * sprite.getHeight());
//		sprite = mapSprites.get(WALL_RIGHT_0);
//		batch.draw(sprite, SCALE * 191, SCALE * 0, SCALE * sprite.getWidth(), SCALE * sprite.getHeight());

		sprite = mapSprites.get(WALL_FAR_LEFT_3);
		batch.draw(sprite, SCALE * 0, SCALE * 62, SCALE * sprite.getWidth(), SCALE * sprite.getHeight());
		sprite = mapSprites.get(WALL_FAR_LEFT_2);
		batch.draw(sprite, SCALE * 0, SCALE * 60, SCALE * sprite.getWidth(), SCALE * sprite.getHeight());

		sprite = mapSprites.get(WALL_FAR_RIGHT_3);
		batch.draw(sprite, SCALE * 180, SCALE * 62, SCALE * sprite.getWidth(), SCALE * sprite.getHeight());
		sprite = mapSprites.get(WALL_FAR_RIGHT_2);
		batch.draw(sprite, SCALE * 216, SCALE * 60, SCALE * sprite.getWidth(), SCALE * sprite.getHeight());

		//batch.draw(mapSprites.get(FLOOR), 0, 0);
		batch.end();
	}

	@Override
	public void dispose () {
		manager.dispose();
		batch.dispose();
	}
}
