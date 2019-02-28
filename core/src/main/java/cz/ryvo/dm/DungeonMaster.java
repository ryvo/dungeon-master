package cz.ryvo.dm;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.LinkedList;

import cz.ryvo.dm.domain.MovementEnum;
import cz.ryvo.dm.domain.Party;
import cz.ryvo.dm.domain.Vector3D;
import cz.ryvo.dm.domain.map.Dungeon;
import cz.ryvo.dm.domain.map.ExperimentalDungeonCreator;
import cz.ryvo.dm.domain.map.Level;
import cz.ryvo.dm.domain.map.Square;
import cz.ryvo.dm.renderer.DungeonRenderer;
import cz.ryvo.dm.texture.SpriteManager;
import cz.ryvo.dm.util.PartyUtils;

import static cz.ryvo.dm.util.PartyUtils.getForwardMovementVector;
import static cz.ryvo.dm.util.PartyUtils.updatePosition;

public class DungeonMaster extends ApplicationAdapter {

	private static final Float SCALE = 4f;

	private Dungeon dungeon;
	private SpriteBatch batch;
	private SpriteManager spriteManager;
	private Party party;
	private LinkedList actionBuffer;

	@Override
	public void create () {
		ExperimentalDungeonCreator edc = new ExperimentalDungeonCreator();
		dungeon = edc.createDungeon();
		batch = new SpriteBatch();
		spriteManager = new SpriteManager();
		party = new Party();
		actionBuffer = new LinkedList();
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

	private void updateParty(MovementEnum movement) {
		Vector3D delta = getForwardMovementVector(party.direction, movement);
		Vector3D newPosition = updatePosition(party.position, delta);
		Square currentSquare = dungeon.getSquare(party.position);
		Square newSquare = dungeon.getSquare(newPosition);
		if (currentSquare.canPartyWalkOut() && newSquare.canPartyWalkIn()) {
			party.position = newPosition;
		}
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
				updateParty(MovementEnum.FORWARD);
			}
			if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
				party.moveBackward();
				updateParty(MovementEnum.BACKWARD);
			}
		}
	}

	private void renderGame() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

		Level level = dungeon.getLevel(0);

		DungeonRenderer renderer = new DungeonRenderer(batch, spriteManager);
		renderer.render(level, party.position, party.direction, SCALE);
		batch.end();
	}
}
