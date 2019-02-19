package cz.ryvo.dm;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import cz.ryvo.dm.domain.DirectionEnum;
import cz.ryvo.dm.domain.Party;
import cz.ryvo.dm.domain.Position2D;
import cz.ryvo.dm.domain.map.Dungeon;
import cz.ryvo.dm.domain.map.ExperimentalDungeonCreator;
import cz.ryvo.dm.domain.map.Level;
import cz.ryvo.dm.renderer.DungeonRenderer;
import cz.ryvo.dm.texture.SpriteManager;

public class DungeonMaster extends ApplicationAdapter {

	private static final Float SCALE = 4f;

	private SpriteBatch batch;
	private SpriteManager spriteManager;
	private Party party;

	@Override
	public void create () {
		batch = new SpriteBatch();
		spriteManager = new SpriteManager();
		party = new Party();
	}

	@Override
	public void render () {
		float deltaTime = Gdx.graphics.getRawDeltaTime();
		updateGame(deltaTime);
		renderGame();
	}

	@Override
	public void dispose () {
		spriteManager.dispose();
		batch.dispose();
	}

	private void updateGame(float deltaTime) {
		party.updateParty(deltaTime);
		if (party.canMove()) {
			if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
				party.turnLeft();
			}
			if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
				party.turnRight();
			}
			if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
				party.moveForward();
			}
			if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
				party.moveBackward();
			}
		}
	}

	private void renderGame() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

		ExperimentalDungeonCreator edc = new ExperimentalDungeonCreator();
		Dungeon dungeon = edc.createDungeon();
		Level level = dungeon.getLevel(0);

		DungeonRenderer renderer = new DungeonRenderer(batch, spriteManager);
		renderer.render(level, party.position, party.direction, SCALE);
		batch.end();
	}
}
