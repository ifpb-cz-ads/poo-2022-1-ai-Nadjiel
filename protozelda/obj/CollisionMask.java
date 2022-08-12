package protozelda.obj;

import java.awt.Graphics2D;

import imagine.game.GameElement;

public class CollisionMask extends GameElement {

    private OBJ object;
    
    public CollisionMask(OBJ object, int x, int y, int width, int height) {
        storeObject(object);
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
    }

    private void storeObject(OBJ object) {
        if(object == null) {
            throw new IllegalArgumentException (
                "object == null!"
            );
        }

        this.object = object;
    }

    public int getSolidX() {
        return object.getX() + this.getX();
    }

    public int getSolidY() {
        return object.getY() + this.getY();
    }

    public int getSolidTop() {
        return object.getY() + this.getTop();
    }

    public int getSolidRight() {
        return object.getX() + this.getRight();
    }

    public int getSolidBottom() {
        return object.getY() + this.getBottom();
    }

    public int getSolidLeft() {
        return object.getX() + this.getLeft();
    }

    public int getApparentSolidX() {
        return object.getApparentX() + this.getX();
    }

    public int getApparentSolidY() {
        return object.getApparentY() + this.getY();
    }

    public int getApparentSolidTop() {
        return object.getApparentY() + this.getTop();
    }

    public int getApparentSolidRight() {
        return object.getApparentX() + this.getRight();
    }

    public int getApparentSolidBottom() {
        return object.getApparentY() + this.getBottom();
    }

    public int getApparentSolidLeft() {
        return object.getApparentX() + this.getLeft();
    }

    public void draw(Graphics2D g2) {
        g2.setColor(object.getColor());
        g2.fillRect (
            getApparentSolidX(),
            getApparentSolidY(),
            getWidth(),
            getHeight()
        );
    }

    @Override
    public String toString() {
        return
            "{ top: " + getSolidTop() +
            ", right: " + getSolidRight() +
            ", bottom: " + getSolidBottom() +
            ", left: " + getSolidLeft() + " }";
    }

}