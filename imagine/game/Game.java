package imagine.game;

import java.awt.Graphics2D;

import imagine.flow.*;

/**
 * Abstract class for creating a new game.
 * <p>
 * To use this class you must extend it into
 * your own game class.
 * 
 * @author Daniel O Sousa
 */
public abstract class Game {

    /**
     * The {@code GameFrame} where this game will be held.
     */
    private GameFrame gameFrame;

    /**
     * An object for controlling the flow of the game.
     */
    private GameFlow gameFlow;

    /**
     * Field which has the information of the default
     * width of the tiles of this {@code Game}.
     */
    private int tileWidth;

    /**
     * Field which has the information of the default
     * height of the tiles of this {@code Game}.
     */
    private int tileHeight;

    /**
     * Boolean value to configure if a tile
     * grid should be displayed. This grid is
     * usually great for debugging.
     */
    private boolean drawTileGrid = false;

    /**
     * Constructs a new {@code Game} instance
     * with the default size of {@code 1024} by {@code 576} pixels.
     */
    public Game() {
        createGameFrame();
        setSize(1024, 576);
        centralize();
    }

    /**
     * Creates a new {@code GameFrame}
     * instance for holding this game.
     */
    private void createGameFrame() {
        this.gameFrame = new GameFrame(this);
    }

    /**
     * Returns the frame which is holding this game.
     * 
     * @return the {@code GameFrame}
     */
    public GameFrame getGameFrame() {
        return this.gameFrame;
    }

    /**
     * Returns the width of the frame of this {@code Game}.
     * 
     * @return the {@code GameFrame} width
     */
    public int getGameFrameWidth() {
        return getGameFrame().getWidth();
    }

    /**
     * Returns the height of the frame of this {@code Game}.
     * 
     * @return the {@code GameFrame} height
     */
    public int getGameFrameHeight() {
        return getGameFrame().getHeight();
    }

    /**
     * Returns the width of the content pane
     * of the frame of this {@code Game}.
     * 
     * @return the content pane width
     */
    public int getContentPaneWidth() {
        return getGameFrame().getContentPaneWidth();
    }

    /**
     * Returns the height of the content pane
     * of the frame of this {@code Game}.
     * 
     * @return the content pane height
     */
    public int getContentPaneHeight() {
        return getGameFrame().getContentPaneHeight();
    }

    /**
     * Returns the panel where this {@code Game} is drawn.
     * 
     * @return the {@code GamePanel}
     */
    public GamePanel getGamePanel() {
        return getGameFrame().getGamePanel();
    }

    /**
     * Returns the width of the panel of this {@code Game}.
     * 
     * @return the {@code GamePanel} width
     */
    public int getGamePanelWidth() {
        return getGamePanel().getWidth();
    }

    /**
     * Returns the height of the panel of this {@code Game}.
     * 
     * @return the {@code GamePanel} height
     */
    public int getGamePanelHeight() {
        return getGamePanel().getHeight();
    }

    /**
     * Centralizes the game on the screen.
     */
    public void centralize() {
        gameFrame.setLocationRelativeTo(null);
    }

    /**
     * Causes a call to the
     * {@code repaint} method of
     * the {@code GamePanel}.
     */
    public void repaintGamePanel() {
        getGamePanel().repaint();
    }

    /**
     * Creates and starts a {@code GameFlow} to
     * loop through the game.
     * 
     * @param fps the fps with which the game
     * should iterate
     */
    public void createGameFlow(int fps) {
        this.gameFlow = new GameFlow(this, fps);
    }

    /**
     * Returns the {@code GameFlow} of this {@code Game}.
     * 
     * @return the {@code GameFlow}
     */
    public GameFlow getGameFlow() {
        return this.gameFlow;
    }

    /**
     * Returns the fps with which this
     * {@code Game} is configured to run.
     * {@code 0} is returned if no fps was
     * configured.
     * 
     * @return the fps of this {@code Game}
     */
    public int getFps() {
        if(gameFlow != null) {
            return gameFlow.getFps();
        } else {
            return 0;
        }
    }

    /**
     * Makes the flow of this {@code Game} finish.
     */
    public void killGameFlow() {
        if(gameFlow != null) {
            gameFlow.killFlow();
        }
    }

    /**
     * Sets if the fps should or shouldn't
     * be displayed on the console.
     * 
     * @param displayFps boolean to
     * configure the fps display
     */
    public void setDisplayFps(boolean displayFps) {
        if(gameFlow != null) {
            gameFlow.setDisplayFps(displayFps);
        }
    }

    /**
     * Returns {@code true} if the fps is configured
     * to be displayed on the console and {@code false}
     * otherwise. {@code false} is also returned
     * if there is no {@code GameFlow} executing.
     * 
     * @return boolean indicating fps display
     * state
     */
    public boolean getDisplayFps() {
        if(gameFlow != null) {
            return gameFlow.getDisplayFps();
        } else {
            return false;
        }
    }

    /**
     * Sets the default width of the
     * tiles of this {@code Game}.
     * 
     * @param tileWidth the tile width to be set
     * 
     * @throws IllegalArgumentException if the passed
     * {@code tileWidth} is negative
     */
    private void setTileWidth(int tileWidth) {
        if(tileWidth < 0) {
            throw new IllegalArgumentException (
                "can't set tile width to " + tileWidth + ": " +
                tileWidth + " < 0"
            );
        }

        this.tileWidth = tileWidth;
    }

    /**
     * Sets the default height of the
     * tiles of this {@code Game}.
     * 
     * @param tileHeight the tile height to be set
     * 
     * @throws IllegalArgumentException if the passed
     * {@code tileHeight} is negative
     */
    private void setTileHeight(int tileHeight) {
        if(tileHeight < 0) {
            throw new IllegalArgumentException (
                "can't set tile height to " + tileHeight + ": "
                + tileHeight + " < 0"
            );
        }

        this.tileHeight = tileHeight;
    }

    /**
     * Sets the default size of the
     * tiles of this {@code Game}.
     * 
     * @param width the tile width to be set
     * @param height the tile height to be set
     * 
     * @throws IllegalArgumentException if the
     * passed {@code width} or {@code height}
     * is negative
     */
    public void setTileSize(int width, int height) {
        setTileWidth(width);
        setTileHeight(height);
    }

    /**
     * Sets the tile width in a way that the
     * determined {@code amount} of tiles
     * fits the screen horizontally.
     * 
     * @param amount the amount of tiles that the
     * game should have horizontally
     * 
     * @throws IllegalArgumentException if the
     * passed {@code amount} is negative
     */
    public void setHorizontalTileAmount(int amount) {
        if(amount < 0) {
            throw new IllegalArgumentException (
                "can't have " + amount + " tiles horizontally onscreen: " +
                amount + " < 0"
            );
        }

        setTileWidth (
            amount == 0 ?
            0 :
            getGamePanelWidth() / amount
        );
    }

    /**
     * Sets the tile height in a way that the
     * determined {@code amount} of tiles
     * fits the screen vertically.
     * 
     * @param amount the amount of tiles that the
     * game should have vertically
     * 
     * @throws IllegalArgumentException if the
     * passed {@code amount} is negative
     */
    public void setVerticalTileAmount(int amount) {
        if(amount < 0) {
            throw new IllegalArgumentException (
                "can't have " + amount + " tiles vertically onscreen: " +
                amount + " < 0"
            );
        }

        setTileHeight (
            amount == 0 ?
            0 :
            getGamePanelHeight() / amount
        );
    }

    /**
     * Returns the default width of
     * the tiles of this {@code Game}.
     * 
     * @return the default tile width
     */
    public int getTileWidth() {
        return this.tileWidth;
    }

    /**
     * Returns the default height of
     * the tiles of this {@code Game}.
     * 
     * @return the default tile height
     */
    public int getTileHeight() {
        return this.tileHeight;
    }

    /**
     * Specifies if a tile grid should be drawn.
     * This grid is usually good for debugging.
     * 
     * @param drawTileGrid boolean indicating
     * visibility of tile grid
     */
    public void setDrawTileGrid(boolean drawTileGrid) {
        this.drawTileGrid = drawTileGrid;
    }

    /**
     * Returns {@code true} or {@code false}
     * depending if the tile grid is configured
     * to be drawn or not.
     * 
     * @return boolean indicating tile grid
     * visibility
     */
    public boolean getDrawTileGrid() {
        return this.drawTileGrid;
    }

    /**
     * Sets the size of the frame
     * containing this {@code Game}.
     * 
     * @param width the width to be set
     * @param height the height to be set
     */
    public void setSize(int width, int height) {
        getGameFrame().setContentPaneSize(width, height);
        getGamePanel().setSize(width, height);
    }

    /**
     * Method executed once the flow of
     * this {@code Game} starts.
     * <p>
     * This method executes the {@code onStart} method.
     * 
     * @see #onStart()
     */
    public void start() {
        
        onStart();
    }

    /**
     * User defined method to specify
     * what should happen once this
     * {@code Game} starts.
     */
    public abstract void onStart();

    /**
     * Executed every frame of this {@code Game} to
     * update the current stage.
     * <p>
     * This method also executes the {@code onUpdate}
     * method.
     * 
     * @see #onUpdate()
     */
    public void update() {

        onUpdate();
    }
    
    /**
     * User defined method to specify
     * what should happen once this
     * {@code Game} updates.
     */
    public abstract void onUpdate();

    /**
     * Executed every frame of this {@code Game}
     * after the {@code update} method to
     * draw the current stage.
     * <p>
     * This method also executes the {@code onDraw}
     * method.
     * 
     * @param g2 a {@code Graphics2D} instance used
     * for drawing the game.
     * 
     * @see #update()
     * @see #onDraw(Graphics2D)
     */
    public void draw(Graphics2D g2) {

        onDraw(g2);
    }
    
    /**
     * User defined method to specify
     * what should happen every time this
     * {@code Game} is drawn.
     */
    public abstract void onDraw(Graphics2D g2);
    
}