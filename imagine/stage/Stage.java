package imagine.stage;

import java.awt.Graphics2D;

import imagine.flow.GameFluid;
import imagine.game.Game;

/**
 * Class for creating a stage for a {@code Game}.
 * 
 * @author Daniel O Sousa
 */
public abstract class Stage implements GameFluid {

    /**
     * {@code Game} which has this {@code Stage}.
     */
    private Game game;

    /**
     * The title of this {@code Stage}.
     */
    private String title;

    /**
     * The width of this {@code Stage}.
     */
    private int width;

    /**
     * The height of this {@code Stage}.
     */
    private int height;

    /**
     * Creates a new {@code Stage} that will
     * belong to the passed {@code game}.
     * 
     * @param game the {@code Game} to which
     * this {@code Stage} belongs
     */
    public Stage(Game game) {
        storeGame(game);
    }

    /**
     * Stores the {@code Game}
     * that has this {@code Stage}.
     * 
     * @param game the game to which this
     * {@code Stage} belongs
     */
    private void storeGame(Game game) {
        if(game == null) {
            throw new IllegalArgumentException("cannot store null game");
        }

        this.game = game;
    }

    /**
     * Returns the {@code Game} to which
     * this {@code Stage} belongs.
     * 
     * @return the {@code Game} of
     * this {@code Stage}
     */
    public Game getGame() {
        return this.game;
    }

    /**
     * Returns the width of the {@code GamePanel}
     * where this {@code Stage} is exhibited.
     * 
     * @return the width of the {@code GamePanel}
     */
    public int getGamePanelWidth() {
        if(game != null) {
            return game.getGamePanelWidth();
        } else {
            return 0;
        }
    }

    /**
     * Returns the height of the {@code GamePanel}
     * where this {@code Stage} is exhibited.
     * 
     * @return the height of the {@code GamePanel}
     */
    public int getGamePanelHeight() {
        if(game != null) {
            return game.getGamePanelHeight();
        } else {
            return 0;
        }
    }

    /**
     * Sets the title of this {@code Stage}.
     * 
     * @param title the title to be set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returns the title of this {@code Stage}.
     * 
     * @return this {@code Stage}'s title
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Sets the width of this {@code Stage},
     * if the passed {@code width} is greater
     * or equal to {@code 0}.
     * 
     * @param width the width to be set
     * 
     * @throws IllegalArgumentException if the
     * {@code width} argument is negative
     */
    public void setWidth(int width) {
        if(width < 0) {
            throw new IllegalArgumentException (
                "width cannot be negative"
            );
        }

        this.width = width;
    }

    /**
     * Returns the width of this {@code Stage}.
     * 
     * @return this {@code Stage}'s width
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * Sets the height of this {@code Stage},
     * if the passed {@code height} is greater
     * or equal to {@code 0}.
     * 
     * @param height the height to be set
     * 
     * @throws IllegalArgumentException if the
     * {@code height} argument is negative
     */
    public void setHeight(int height) {
        if(height < 0) {
            throw new IllegalArgumentException (
                "height cannot be negative"
            );
        }

        this.height = height;
    }

    /**
     * Returns the height of this {@code Stage}.
     * 
     * @return this {@code Stage}'s height
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * Sets the width of this {@code Stage}, if it is
     * greater or equal to {@code 0}, and does the
     * same with the height.
     * 
     * @param width the width to be set
     * @param height the height to be set
     * 
     * @throws IllegalArgumentException if the
     * {@code width} or {@code height} arguments
     * are negative
     */
    public void setSize(int width, int height) {
        setWidth(width);
        setHeight(height);
    }

    /**
     * Executes the {@code start} method of
     * the backgrounds, objects, foregrounds
     * and camera of this {@code Stage}.
     * <p>
     * Also Executes this {@code Stage}'s
     * {@code onStart} method.
     * 
     * @see #onStart()
     */
    public void start() {
        
        onStart();
    }

    /**
     * This method is used to define what
     * should happen when this {@code Stage}
     * is started.
     */
    public abstract void onStart();

    /**
     * This method is executed every
     * frame to call the {@code update}
     * method of the backgrounds, objects,
     * foregrounds and camera of this
     * {@code Stage}.
     * <p>
     * This method also calls this
     * {@code Stage}'s {@code onUpdate}
     * method.
     * 
     * @see #onUpdate()
     */
    public void update() {
        
        onUpdate();
    }

    /**
     * This method is used to define what
     * should happen when this {@code Stage}
     * is updated.
     */
    public abstract void onUpdate();

    /**
     * This method is executed every frame
     * to call the {@code draw} method of
     * the backgrounds, objects, foregrounds
     * and camera of this {@code Stage},
     * passing the {@code g2} argument.
     * <p>
     * This method also calls this 
     * {@code Stage}'s {@code onDraw} method.
     * 
     * @param g2 the {@code Graphics2D} instance
     *           to draw this {@code Stage}'s
     *           objects with
     * 
     * @see #onDraw(Graphics2D)
     */
    public void draw(Graphics2D g2) {
        
        onDraw(g2);
    }

    /**
     * This method is used to define what
     * should happen every time this
     * {@code Stage} is drawn.
     * <p>
     * The {@code g2} parameter is used to
     * do optional customized drawings.
     * 
     * @param g2 a {@code Graphics2D} instance
     * to draw with
     */
    public abstract void onDraw(Graphics2D g2);

}