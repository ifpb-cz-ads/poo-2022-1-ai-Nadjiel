package protozelda.obj;

import java.awt.Color;
import java.awt.Graphics2D;

public class Obstacle_OBJ extends OBJ {

    public Obstacle_OBJ(int x, int y, int width, int height) {
        super(null, x, y, width, height);
        setColor(new Color(200, 76, 12, 127));
        setShowCollisionMask(false);
    }

    @Override
    public void onStart() {
        
    }

    @Override
    public void onDraw(Graphics2D g2) {
        super.onDraw(g2);
    }

    @Override
    public void onUpdate() {
        
    }
    
}
