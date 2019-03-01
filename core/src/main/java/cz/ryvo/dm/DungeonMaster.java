package cz.ryvo.dm;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Locale;

import cz.ryvo.dm.action.EventQueue;
import cz.ryvo.dm.domain.WalkActionEnum;
import cz.ryvo.dm.domain.Party;
import cz.ryvo.dm.domain.map.Dungeon;
import cz.ryvo.dm.domain.map.ExperimentalDungeonCreator;
import cz.ryvo.dm.domain.map.Level;
import cz.ryvo.dm.renderer.DungeonRenderer;
import cz.ryvo.dm.texture.SpriteManager;

import static com.badlogic.gdx.Input.Keys.DOWN;
import static com.badlogic.gdx.Input.Keys.LEFT;
import static com.badlogic.gdx.Input.Keys.NUMPAD_1;
import static com.badlogic.gdx.Input.Keys.NUMPAD_2;
import static com.badlogic.gdx.Input.Keys.NUMPAD_3;
import static com.badlogic.gdx.Input.Keys.NUMPAD_4;
import static com.badlogic.gdx.Input.Keys.NUMPAD_5;
import static com.badlogic.gdx.Input.Keys.NUMPAD_6;
import static com.badlogic.gdx.Input.Keys.RIGHT;
import static com.badlogic.gdx.Input.Keys.UP;
import static cz.ryvo.dm.domain.WalkActionEnum.STEP_BACKWARD;
import static cz.ryvo.dm.domain.WalkActionEnum.STEP_FORWARD;
import static cz.ryvo.dm.domain.WalkActionEnum.STRAFE_LEFT;
import static cz.ryvo.dm.domain.WalkActionEnum.STRAFE_RIGHT;
import static cz.ryvo.dm.domain.WalkActionEnum.TURN_LEFT;
import static cz.ryvo.dm.domain.WalkActionEnum.TURN_RIGHT;
import static java.lang.String.format;

public class DungeonMaster extends ApplicationAdapter implements InputProcessor {

	private static final float SCALE = 4f;
	private static final float TICK_INTERVAL = 0.2f;
	private static final int WALK_QUEUE_SIZE = 5;

	private float tickTime;
	private EventQueue<WalkActionEnum> walkQueue;
	private DungeonRenderer renderer;

	private Dungeon dungeon;
	private SpriteBatch batch;
	private SpriteManager spriteManager;
	private Party party;
	private BitmapFont font;

	@Override
	public void create () {
		tickTime = 0;
		walkQueue = new EventQueue<>(WALK_QUEUE_SIZE);
		Gdx.input.setInputProcessor(this);

		batch = new SpriteBatch();
		spriteManager = new SpriteManager();
		renderer = new DungeonRenderer(batch, spriteManager);

		ExperimentalDungeonCreator edc = new ExperimentalDungeonCreator();
		dungeon = edc.createDungeon();

		party = new Party(dungeon);
		font = new BitmapFont();
	}

	/**
	 * Game timing is based on ticks. A tick is a base time unit. Each action takes certain number of
	 * ticks.
	 */
	@Override
	public void render () {
		tickTime += Gdx.graphics.getRawDeltaTime();
		if (tickTime >= TICK_INTERVAL) {
			// Tick now!
			tickTime = 0;
			updateGame();
		}
		renderGame();
	}

	private void updateGame() {
		party.tick();
		if (party.canWalk() && !walkQueue.isEmpty()) {
			party.doWalkAction(walkQueue.get());
		}
	}

	private void renderGame() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

		Level level = dungeon.getLevel(0);

		renderer.render(level, party, SCALE);

		font.draw(batch, format(Locale.US,"walkQueue size: %d", walkQueue.getSize()), 10, 650);
		font.draw(batch, format(Locale.US,"scale: %f", SCALE), 10, 630);

		batch.end();
	}

	@Override
	public void dispose () {
		spriteManager.dispose();
		batch.dispose();
	}

	@Override
	public boolean keyDown(int keycode) {
		switch (keycode) {
			case UP:
			case NUMPAD_5:
				walkQueue.put(STEP_FORWARD);
				break;
			case DOWN:
			case NUMPAD_2:
				walkQueue.put(STEP_BACKWARD);
				break;
			case NUMPAD_4:
				walkQueue.put(TURN_LEFT);
				break;
			case NUMPAD_6:
				walkQueue.put(TURN_RIGHT);
				break;
			case LEFT:
			case NUMPAD_1:
				walkQueue.put(STRAFE_LEFT);
				break;
			case RIGHT:
			case NUMPAD_3:
				walkQueue.put(STRAFE_RIGHT);
		}
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}
}
