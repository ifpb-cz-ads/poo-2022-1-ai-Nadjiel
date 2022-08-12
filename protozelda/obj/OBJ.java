package protozelda.obj;

import java.awt.Graphics2D;
import java.util.ArrayList;

import imagine.object.GameObject;
import imagine.sprite.SpriteSheet;

public abstract class OBJ extends GameObject {

    private CollisionMask collisionMask;
    private boolean solid = true;
    private boolean showCollisionMask = false;

    public OBJ(SpriteSheet spriteSheet, int x, int y, int width, int height) {
        super(spriteSheet, x, y, width, height);
        setCollisionMask(new CollisionMask (
            this, 0, 0,
            getWidth(), getHeight()
        ));
    }

    public void setCollisionMask(CollisionMask collisionMask) {
        if(collisionMask == null) {
            throw new IllegalArgumentException (
                "collisionMask == null!"
            );
        }

        this.collisionMask = collisionMask;
    }

    public CollisionMask getCollisionMask() {
        return this.collisionMask;
    }

    public int getCollisionMaskWidth() {
        return collisionMask.getWidth();
    }

    public int getCollisionMaskHeight() {
        return collisionMask.getHeight();
    }

    public void setSolid(boolean solid) {
        this.solid = solid;
    }

    public boolean getSolid() {
        return this.solid;
    }

    public void setShowCollisionMask(boolean showCollisionMask) {
        this.showCollisionMask = showCollisionMask;
    }

    public boolean getShowCollisionMask() {
        return this.showCollisionMask;
    }

    public int getSolidTop() {
        return collisionMask.getSolidTop();
    }

    public int getSolidRight() {
        return collisionMask.getSolidRight();
    }

    public int getSolidBottom() {
        return collisionMask.getSolidBottom();
    }

    public int getSolidLeft() {
        return collisionMask.getSolidLeft();
    }

    public int getApparentSolidTop() {
        return collisionMask.getApparentSolidTop();
    }

    public int getApparentSolidRight() {
        return collisionMask.getApparentSolidRight();
    }

    public int getApparentSolidBottom() {
        return collisionMask.getApparentSolidBottom();
    }

    public int getApparentSolidLeft() {
        return collisionMask.getApparentSolidLeft();
    }

    public ArrayList<Collision> getCollisions(CollisionConfig config) {
        if(getStage() == null) {
            return null;
        }

        ArrayList<Collision> results = new ArrayList<Collision>();

        ArrayList<GameObject> gObjects = getStage().getObjects();
        for(GameObject gObject : gObjects) {
            OBJ obj = (OBJ) gObject;
            if(obj == this) {
                continue;
            }
            if(
                (
                    obj.getApparentSolidBottom() < 0 ||
                    obj.getApparentSolidTop() > getCamera().getHeight()
                ) ||
                (
                    obj.getApparentSolidRight() < 0 ||
                    obj.getApparentSolidLeft() > getCamera().getWidth()
                )
            ) {
                continue;
            }
            if (
                config != null &&
                config.getSolid() != obj.getSolid()
            ) {
                continue;
            }

            Collision collision = new Collision(this, obj);

            if(!collision.isXAligned() && !collision.isYAligned()) {
                continue;
            }
            if(results.isEmpty()) {
                results.add(collision);
                continue;
            }

            for(Collision result : results) {
                if(result == collision) {
                    continue;
                }
                if(result.getDirection() != collision.getDirection()) {
                    if(results.indexOf(result) < results.size() - 1) {
                        continue;
                    }
                    results.add(collision);
                    break;
                }
                if(result.getDistance() > collision.getDistance()) {
                    results.set(results.indexOf(result), collision);
                    break;
                }
                if(result.getDistance() == collision.getDistance()) {
                    results.add(collision);
                    break;
                }
                
                break;
            }
        }

        return results;
    }

    public boolean keyIsPressed(int keyCode) {
        return getGame().keyIsPressed(keyCode);
    }

    @Override
    public void move() {
        if(getXSpeed() == 0 && getYSpeed() == 0) {
            return;
        }

        // Don't trespass stage boundaries

        // X boundaries
        if (getLeft() + getXSpeed() < 0) {
            setX(0);
            setXSpeed(0);
        } else if (getRight() + getXSpeed() > getStageWidth()) {
            setX(getStageWidth() - getWidth());
            setXSpeed(0);
        }
        
        // Y boundaries
        if (getTop() + getYSpeed() < 0) {
            setY(0);
            setYSpeed(0);
        } else if (getBottom() + getYSpeed() > getStageHeight()) {
            setY(getStageHeight() - getHeight());
            setYSpeed(0);
        }

        // Don't trespass solid objects
        ArrayList<Collision> collisions = getCollisions(new CollisionConfig(true));

        if(!collisions.isEmpty()) {
            for(Collision collision : collisions) {
                // Y collision handling
                if (
                    getSolidRight() > collision.getObstacleSolidLeft() &&
                    getSolidLeft() < collision.getObstacleSolidRight()
                ) {
                    if (
                        getSolidTop() + getYSpeed() < collision.getObstacleSolidBottom() &&
                        getSolidTop() + getYSpeed() > collision.getObstacleSolidBottom() - 16
                    ) {
                        setY(collision.getObstacleSolidBottom());
                        setYSpeed(0);
                    }
                    if (
                        getSolidBottom() + getYSpeed() > collision.getObstacleSolidTop() &&
                        getSolidBottom() + getYSpeed() < collision.getObstacleSolidTop() + 16
                    ) {
                        setY(collision.getObstacleSolidTop() - getCollisionMaskHeight());
                        setYSpeed(0);
                    }
                }
        
                // X collision handling
                if (
                    getSolidBottom() > collision.getObstacleSolidTop() &&
                    getSolidTop() < collision.getObstacleSolidBottom()
                ) {
                    if (
                        getSolidLeft() + getXSpeed() < collision.getObstacleSolidRight() &&
                        getSolidLeft() + getXSpeed() > collision.getObstacleSolidRight() - 16
                    ) {
                        setX(collision.getObstacleSolidRight());
                        setXSpeed(0);
                    }
                    if (
                        getSolidRight() + getXSpeed() > collision.getObstacleSolidLeft() &&
                        getSolidRight() + getXSpeed() < collision.getObstacleSolidLeft() + 16
                    ) {
                        setX(collision.getObstacleSolidLeft() - getCollisionMaskWidth());
                        setXSpeed(0);
                    }
                }
            }
        }
        
        increaseX(getXSpeed());
        increaseY(getYSpeed());
    }

    @Override
    public void onDraw(Graphics2D g2) {
        if(showCollisionMask) {
            collisionMask.draw(g2);
        }
    }
    
}