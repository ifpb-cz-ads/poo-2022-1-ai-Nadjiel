package protozelda.bg;

import java.awt.Graphics2D;

import imagine.scenario.Scenario;
import imagine.sprite.SpriteSheet;

public class TestStage_BG extends Scenario {

    public TestStage_BG() {
        super (
            new SpriteSheet (
                "protozelda/assets/sprites/stg/teststage-bg.png"
            )
        );
        setWidth(64 * 48);
        setHeight(64 * 45);
        setTypeNoRepeat();
    }

    @Override
    public void onStart() {
        
    }

    @Override
    public void onUpdate() {
        
    }

    @Override
    public void onDraw(Graphics2D g2) {
        
    }
    
}