package protozelda.obj;

import static protozelda.util.Util.*;

public class Collision implements Directional {

    private OBJ object;
    private OBJ obstacle;
    private boolean status = false;
    private boolean xAligned = false;
    private boolean yAligned = false;
    private int direction;
    private int topDistance;
    private int rightDistance;
    private int bottomDistance;
    private int leftDistance;
    private int distance;

    public Collision(OBJ object, OBJ obstacle) {
        storeObject(object);
        storeObstacle(obstacle);
        calculateDistances();
        calculateDistance();
        calculateAlignement();
        calculateStatus();
        calculateDirection();
    }

    private void storeObject(OBJ object) {
        if(object == null) {
            throw new IllegalArgumentException (
                "object == null!"
            );
        }

        this.object = object;
    }

    public OBJ getObject() {
        return this.object;
    }

    private void storeObstacle(OBJ obstacle) {
        if(obstacle == null) {
            throw new IllegalArgumentException (
                "obstacle == null!"
            );
        }

        this.obstacle = obstacle;
    }

    public OBJ getObstacle() {
        return this.obstacle;
    }

    public int getObstacleSolidTop() {
        return obstacle.getSolidTop();
    }

    public int getObstacleSolidRight() {
        return obstacle.getSolidRight();
    }

    public int getObstacleSolidBottom() {
        return obstacle.getSolidBottom();
    }

    public int getObstacleSolidLeft() {
        return obstacle.getSolidLeft();
    }

    private void storeTopDistance(int distance) {
        this.topDistance = distance;
    }

    public int getTopDistance() {
        return this.topDistance;
    }

    private void storeRightDistance(int distance) {
        this.rightDistance = distance;
    }

    public int getRightDistance() {
        return this.rightDistance;
    }

    private void storeBottomDistance(int distance) {
        this.bottomDistance = distance;
    }

    public int getBottomDistance() {
        return this.bottomDistance;
    }

    private void storeLeftDistance(int distance) {
        this.leftDistance = distance;
    }

    public int getLeftDistance() {
        return this.leftDistance;
    }

    private void storeDistances(int top, int right, int bottom, int left) {
        storeTopDistance(top);
        storeRightDistance(right);
        storeBottomDistance(bottom);
        storeLeftDistance(left);
    }

    private void calculateDistances() {
        storeDistances (
            object.getSolidTop() - obstacle.getSolidBottom(),
            obstacle.getSolidLeft() - object.getSolidRight(),
            obstacle.getSolidTop() - object.getSolidBottom(),
            object.getSolidLeft() - obstacle.getSolidRight()
        );
    }

    private void storeDistance(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return this.distance;
    }

    private void calculateDistance() {
        if (
            topDistance > 0 ||
            rightDistance > 0 ||
            bottomDistance > 0 ||
            leftDistance > 0
        ) {
            storeDistance (
                positiveMin (
                    topDistance,
                    positiveMin (
                        rightDistance,
                        positiveMin (
                            bottomDistance,
                            leftDistance
                        )
                    )
                )
            );
        }

        storeDistance (
            Math.max (
                topDistance,
                Math.max (
                    rightDistance,
                    Math.max (
                        bottomDistance,
                        leftDistance
                    )
                )
            )
        );
    }

    private void storeXAligned(boolean xAligned) {
        this.xAligned = xAligned;
    }

    public boolean isXAligned() {
        return this.xAligned;
    }

    private void storeYAligned(boolean yAligned) {
        this.yAligned = yAligned;
    }

    public boolean isYAligned() {
        return this.yAligned;
    }

    private void calculateAlignement() {
        if(topDistance < 0 && bottomDistance < 0) {
            storeXAligned(true);
        }
        if(leftDistance < 0 && rightDistance < 0) {
            storeYAligned(true);
        }
    }

    private void storeDirection(int direction) {
        this.direction = direction;
    }

    public int getDirection() {
        return this.direction;
    }

    private void calculateDirection() {
        if(distance == topDistance) {
            storeDirection(UP);
        }
        if(distance == rightDistance) {
            storeDirection(RIGHT);
        }
        if(distance == bottomDistance) {
            storeDirection(DOWN);
        }
        if(distance == leftDistance) {
            storeDirection(LEFT);
        }
    }

    private void storeStatus(boolean status) {
        this.status = status;
    }

    public boolean getStatus() {
        return this.status;
    }

    private void calculateStatus() {
        if (
            (
                sign(topDistance) +
                sign(rightDistance) +
                sign(bottomDistance) +
                sign(leftDistance)
            ) <= -3
        ) {
            storeStatus(true);
        }
    }

    private String interpretDirection() {
        switch(direction) {
            case UP: return "up";
            case RIGHT: return "right";
            case DOWN: return "down";
            case LEFT: return "left";
            default: return null;
        }
    }

    @Override
    public String toString() {
        return
            "{\n\tobject: " + object +
            ";\n\tobstacle: " + obstacle +
            ";\n\tstatus: " + status +
            ";\n\talignment: " + "x: " + xAligned + ", y: " + yAligned +
            ";\n\tdirection: " + interpretDirection() +
            ";\n\tdistances: " + topDistance + ", " + rightDistance + ", " + bottomDistance + ", " + leftDistance +
            ";\n\tdistance: " + getDistance() +
            ";\n}";
    }
    
}