package cz.ryvo.dm.texture;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.utils.Disposable;

import java.util.HashMap;
import java.util.Map;

import static java.lang.String.format;

public class SpriteManager implements Disposable {

    private static final String ATLAS_FILE_NAME = "map.atlas";

    private AssetManager manager;

    private Map<String, Sprite> sprites;

    public SpriteManager() {
        manager = new AssetManager();
        manager.load("map.atlas", TextureAtlas.class);
        manager.finishLoading();

        // Load all sprites into a map by name
        TextureAtlas textureAtlas = manager.get(ATLAS_FILE_NAME, TextureAtlas.class);
        this.sprites = new HashMap<>();
        for(AtlasRegion region: textureAtlas.getRegions()) {
            Sprite sprite = textureAtlas.createSprite(region.name);
            sprites.put(region.name, sprite);
        }
    }

    @Override
    public void dispose() {
        manager.dispose();
    }

    public Sprite getSprite(String name) {
        Sprite sprite = sprites.get(name);
        if (sprite == null) {
            throw new IllegalArgumentException(format("Unknown sprite name '%s'", name));
        }
        return sprite;
    }
}
