package protozelda;

import java.awt.Graphics2D;

import imagine.game.Game;
import protozelda.stg.TestStage_STG;

public class ProtoZelda extends Game {

    private final int ORIGINAL_SCREEN_WIDTH = 256;
    private final int ORIGINAL_SCREEN_HEIGHT = 240;
    private final int ORIGINAL_TILE_SIZE = 16;
    private final int SCALE = 4;
    public static final int ANIMATION_INTERVAL = 5;
    private long frameCount = 0;

    public ProtoZelda() {
        getGameFrame().setTitle("ProtoZelda");
        setSize(ORIGINAL_SCREEN_WIDTH * SCALE, ORIGINAL_SCREEN_HEIGHT * SCALE);
        setTileSize(ORIGINAL_TILE_SIZE * SCALE, ORIGINAL_TILE_SIZE * SCALE);
        centralize();
        addStage(new TestStage_STG(this));
        nextStage();
        createGameFlow(60);
        setDisplayFps(true);
    }

    private void incrementFrameCount() {
        frameCount++;
    }

    public long getFrameCount() {
        return frameCount;
    }

    @Override
    public void onStart() {
        
    }

    @Override
    public void onUpdate() {
        incrementFrameCount();
    }

    @Override
    public void onDraw(Graphics2D g2) {
        
    }

}