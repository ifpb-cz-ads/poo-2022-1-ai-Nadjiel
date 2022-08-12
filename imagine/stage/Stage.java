package imagine.stage;

import java.util.ArrayList;
import java.awt.Graphics2D;

import imagine.flow.GameFluid;
import imagine.game.Game;
import imagine.object.GameObject;
import imagine.camera.*;
import imagine.camera.type.CameraType;

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
     * The objects of this {@code Stage}.
     */
    private ArrayList<GameObject> objects = new ArrayList<GameObject>();

    /**
     * The camera of this {@code Stage}.
     */
    private Camera camera;

    /**
     * Creates a new {@code Stage} that will
     * belong to the passed {@code game}.
     * 
     * @param game the {@code Game} to which
     * this {@code Stage} belongs
     */
    public Stage(Game game) {
        storeGame(game);
        createCamera();
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
     * Adds a {@code GameObject} to the
     * end of the list of objects of this
     * {@code Stage}. This object will be
     * the last to be updated and drawn
     * each frame of the game.
     * <p>
     * The {@code object} argument cannot
     * be null.
     * 
     * @param object the {@code GameObject}
     * to be added
     * 
     * @throws IllegalArgumentException if the
     * {@code object} argument is {@code null}
     */
    public void addObject(GameObject object) {
        addLastObject(object);
    }

    /**
     * Adds a {@code GameObject} to the
     * end of the list of objects of this
     * {@code Stage}. This object will be
     * the last to be updated and drawn
     * each frame of the game.
     * <p>
     * The {@code object} argument cannot
     * be null.
     * 
     * @param object the {@code GameObject}
     * to be added
     * 
     * @throws IllegalArgumentException if the
     * {@code object} argument is {@code null}
     */
    public void addLastObject(GameObject object) {
        if(object == null) {
            throw new IllegalArgumentException (
                "cannot add null object"
            );
        }

        object.setStage(this);
        objects.add(object);
    }

    /**
     * Adds a {@code GameObject} to the specified {@code position}
     * in the list of objects of this {@code Stage} if the
     * {@code position} isn't invalid
     * ({@code position < 0 || position > objects.size()})
     * and the {@code object} isn't {@code null}.
     * 
     * @param position the position where to add the {@code object}
     * @param object the {@code GameObject} to be added
     * 
     * @throws IndexOutOfBoundsException if the {@code position}
     * is invalid
     * @throws IllegalArgumentException if the {@code object}
     * is {@code null}
     */
    public void addNthObject(int position, GameObject object) {
        if(position < 0 || position > objects.size()) {
            throw new IndexOutOfBoundsException (
                "cannot add object to position " + position +
                " (objects amount is: " + objects.size() + ")"
            );
        }
        if(object == null) {
            throw new IllegalArgumentException (
                "cannot add null object"
            );
        }

        object.setStage(this);
        objects.add(position, object);
    }

    /**
     * Adds a {@code GameObject} to the
     * beginning of the list of objects of this
     * {@code Stage}. This object will be
     * the first to be updated and drawn
     * each frame of the game.
     * <p>
     * The {@code object} argument cannot
     * be null.
     * 
     * @param object the {@code GameObject}
     * to be added
     * 
     * @throws IllegalArgumentException if the
     * {@code object} argument is {@code null}
     */
    public void addFirstObject(GameObject object) {
        if(object == null) {
            throw new IllegalArgumentException (
                "cannot add null object"
            );
        }
        
        object.setStage(this);
        objects.add(0, object);
    }

    /**
     * Removes and returns the last
     * {@code GameObject} of the list of
     * objects of this {@code Stage} if
     * there are any.
     * 
     * @return the removed {@code GameObject}
     */
    public GameObject removeLastObject() {
        if(objects.isEmpty()) {
            return null;
        }

        GameObject removedObject = objects.remove(objects.size() - 1);
        removedObject.setStage(null);
        return removedObject;
    }

    /**
     * Removes and returns from the objects of this
     * {@code Stage}, if there are any, the {@code GameObject}
     * specified by the {@code position} position.
     * If the {@code position} does not correspond
     * to any object of this {@code Stage}
     * ({@code position < 0 || position >= objects.size()}),
     * an exception is thrown.
     * 
     * @param position the position where to remove a
     * {@code GameObject} from
     * 
     * @throws IndexOutOfBoundsException if the position does
     * not correspond to any object
     */
    public GameObject removeObject(int position) {
        if(objects.isEmpty()) {
            return null;
        }
        if(position < 0 || position >= objects.size()) {
            throw new IndexOutOfBoundsException (
                "position " + position +
                " does not correspond to any object"
            );
        }

        GameObject removedObject = objects.remove(position);
        removedObject.setStage(null);
        return removedObject;
    }

    /**
     * Removes the specified {@code GameObject}
     * from this {@code Stage}, if it is present.
     * 
     * @param object the {@code GameObject} to
     * be removed
     */
    public void removeObject(GameObject object) {
        if(objects.remove(object)) {
            object.setStage(null);
        }
    }

    /**
     * Removes and returns the first
     * {@code GameObject} from the list of
     * objects of this {@code Stage}, if
     * there are any.
     * 
     * @return the removed {@code GameObject}
     */
    public GameObject removeFirstObject() {
        if(objects.isEmpty()) {
            return null;
        }

        GameObject removedObject = objects.remove(0);
        removedObject.setStage(null);
        return removedObject;
    }

    /**
     * Returns an {@code ArrayList} containing
     * the objects of this {@code Stage}.
     * 
     * @return the objects of this {@code Stage}
     */
    public ArrayList<GameObject> getObjects() {
        return objects;
    }

    /**
     * Returns the {@code GameObject} specified
     * by the {@code position} argument, if it
     * exists, else, returns {@code null}.
     * 
     * @param position the position where to
     * get the object from
     * 
     * @return the object of this {@code Stage}
     * specified by the position {@code position}
     */
    public GameObject getObject(int position) {
        if(position < 0 || position >= objects.size()) {
            return null;
        }

        return objects.get(position);
    }

    /**
     * Creates a {@code Camera} for
     * this {@code Stage}.
     */
    private void createCamera() {
        this.camera = new Camera(this);
    }

    /**
     * Returns the {@code Camera} of
     * this {@code Stage}.
     * 
     * @return the {@code Camera} of
     * this {@code Stage}
     */
    public Camera getCamera() {
        return this.camera;
    }

    /**
     * Sets the coordinates of the
     * {@code Camera} of this {@code Stage}.
     * 
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public void setCameraCoordinates(int x, int y) {
        camera.setCoordinates(x, y);
    }

    /**
     * Sets the speed on the x axis of
     * the {@code Camera} of this {@code Stage}.
     * 
     * @param xSpeed the speed to be set
     */
    public void setCameraXSpeed(int xSpeed) {
        camera.setXSpeed(xSpeed);
    }

    /**
     * Sets the speed on the y axis of
     * the {@code Camera} of this {@code Stage}.
     * 
     * @param ySpeed the speed to be set
     */
    public void setCameraYSpeed(int ySpeed) {
        camera.setYSpeed(ySpeed);
    }

    /**
     * Sets the type of the {@code Camera} of
     * this {@code Stage} to the passed
     * {@code CameraType}.
     * 
     * @param type the type to be set
     */
    public void setCameraType(CameraType type) {
        camera.setType(type);
    }

    /**
     * Sets the type of the {@code Camera} of
     * this {@code Stage} to the {@code Static}
     * {@code CameraType}.
     */
    public void setCameraTypeStatic() {
        camera.setTypeStatic();
    }

    /**
     * Sets the type of the {@code Camera} of
     * this {@code Stage} to the {@code AutoScroll}
     * {@code CameraType}.
     */
    public void setCameraTypeAutoScroll() {
        camera.setTypeAutoScroll();
    }

    /**
     * Sets the type of the {@code Camera} of
     * this {@code Stage} to the {@code Follow}
     * {@code CameraType}.
     * 
     * @param target the {@code GameObject} that
     * the camera should follow
     */
    public void setCameraTypeFollow(GameObject target) {
        camera.setTypeFollow(target);
    }

    /**
     * Returns the {@code CameraType} of
     * the {@code Camera} of this {@code Stage}.
     * 
     * @return the {@code CameraType}
     */
    public CameraType getCameraType() {
        return camera.getType();
    }

    /**
     * Sets the {@code CameraGrid} of the
     * {@code Camera} of this {@code Stage}.
     * 
     * @param grid the camera grid
     */
    public void setCameraGrid(CameraGrid grid) {
        camera.setGrid(grid);
    }

    /**
     * Defines if the {@code CameraGrid} should
     * be drawn or not.
     * 
     * @param drawGrid boolean specifying if
     * the {@code CameraGrid} should be drawn
     */
    public void setDrawCameraGrid(boolean drawGrid) {
        camera.setDrawGrid(drawGrid);
    }

    /**
     * Returns {@code true} if the
     * {@code CameraGrid} is configured
     * to be drawn and {@code false}
     * otherwise.
     * 
     * @return boolean specifying if the
     * {@code CameraGrid} is being drawn
     */
    public boolean getDrawCameraGrid() {
        return camera.getDrawGrid();
    }

    /**
     * Starts every object of this
     * {@code Stage}.
     */
    private void startObjects() {
        for(GameObject object : objects) {
            object.start();
        }
    }

    /**
     * Updates every object of this
     * {@code Stage}.
     */
    private void updateObjects() {
        for(GameObject object : objects) {
            object.update();
        }
    }

    /**
     * Draws every object of this
     * {@code Stage}.
     * 
     * @param g2 a {@code Graphics2D} with
     * which the objects are drawn
     */
    private void drawObjects(Graphics2D g2) {
        for(GameObject object : objects) {
            object.draw(g2);
        }
    }
    
    /**
     * Starts the camera of this
     * {@code Stage}.
     */
    private void startCamera() {
        camera.start();
    }

    /**
     * Updates the camera of this
     * {@code Stage}.
     */
    private void updateCamera() {
        camera.update();
    }

    /**
     * Draws the camera of this
     * {@code Stage}.
     * 
     * @param g2 a {@code Graphics2D} instance
     * with which the camera can be drawn
     */
    private void drawCamera(Graphics2D g2) {
        camera.draw(g2);;
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
        startObjects();
        startCamera();

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
        updateObjects();
        updateCamera();

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
        drawObjects(g2);
        drawCamera(g2);
        
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