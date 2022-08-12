package protozelda.obj.player;

import java.awt.Color;
import java.awt.Graphics2D;

import protozelda.obj.OBJ;
import protozelda.obj.Directional;
import protozelda.obj.State;
import protozelda.spr.WalkingLink_SPR;

public class Player_OBJ extends OBJ implements Directional {

    private State state;
    private int direction = DOWN;

    public Player_OBJ(int x, int y) {
        super (
            new WalkingLink_SPR(),
            x, y,
            64, 64
        );
        setSolid(false);
        setIdleState();
        setColor(new Color(200, 200, 200));
        setShowCollisionMask(false);
        setFrameY(direction);
    }

    private void setState(State state) {
        this.state = state;
    }

    public void setIdleState() {
        setState(new Idle(this));
    }

    public void setWalkingState() {
        setState(new Walking(this));
    }

    public void setDirection(int direction) {
        if(direction < UP || direction > LEFT) {
            throw new IllegalArgumentException (
                "invalid direction == " + direction + "!"
            );
        }

        this.direction = direction;
    }

    public int getDirection() {
        return this.direction;
    }

    @Override
    public void onStart() {
        
    }

    @Override
    public void onUpdate() {
        state.update();
        setFrameY(direction);
    }

    @Override
    public void onDraw(Graphics2D g2) {
        super.onDraw(g2);
    }
    
}
