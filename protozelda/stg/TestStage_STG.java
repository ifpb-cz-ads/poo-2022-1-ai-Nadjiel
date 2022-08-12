package protozelda.stg;

import java.awt.Graphics2D;

import imagine.stage.Stage;
import imagine.game.Game;

import protozelda.bg.TestStage_BG;
import protozelda.obj.Obstacle_OBJ;
import protozelda.obj.player.Player_OBJ;

public class TestStage_STG extends Stage {

    private Player_OBJ player = new Player_OBJ(64 * 23 + 64 / 2, 64 * 28);

    public TestStage_STG(Game game) {
        super(game);
        setSize(getGamePanelWidth() * 3, getGamePanelHeight() * 3); // 48 by 30 tiles
        addBackground(new TestStage_BG());
        addObject(player);
        addObject(new Obstacle_OBJ(0, 0, 64 * 48, 64)); // north border
        addObject(new Obstacle_OBJ(getWidth() - 64, 64, 64, 64 * 43)); // east border
        addObject(new Obstacle_OBJ(0, getHeight() - 64, 64 * 48, 64)); // south border
        addObject(new Obstacle_OBJ(0, 64, 64, 64 * 43)); // west border
        addObject(new Obstacle_OBJ(64, 64 * 4, 64 * 4, 64)); // north mountain wall first chunck
        addObject(new Obstacle_OBJ(64 * 8, 64 * 4, 64 * 32, 64)); // north mountain wall second chunck
        addObject(new Obstacle_OBJ(getWidth() - 64 * 5, 64 * 4, 64 * 4, 64)); // north mountain wall third chunck
        addObject(new Obstacle_OBJ(64, 64 * 8, 64 * 22, 64)); // middle mountain wall first chunck
        addObject(new Obstacle_OBJ(getWidth() - 64 * 23, 64 * 8, 64 * 22, 64)); // middle mountain wall second chunck
        addObject(new Obstacle_OBJ(64, 64 * 12, 64 * 4, 64)); // south mountain wall first chunck
        addObject(new Obstacle_OBJ(64 * 8, 64 * 12, 64 * 32, 64)); // south mountain wall second chunck
        addObject(new Obstacle_OBJ(getWidth() - 64 * 5, 64 * 12, 64 * 4, 64)); // south mountain wall third chunck
        addObject(new Obstacle_OBJ(64, 64 * 15, 64 * 2, 64 * 3)); // middle forest first chunck
        addObject(new Obstacle_OBJ(64 * 10, 64 * 13, 64 * 4, 64 * 2)); // middle forest second chunck
        addObject(new Obstacle_OBJ(64 * 18, 64 * 16, 64 * 4, 64 * 2)); // middle forest third chunck
        addObject(new Obstacle_OBJ(64 * 26, 64 * 16, 64 * 4, 64 * 2)); // middle forest fourth chunck
        addObject(new Obstacle_OBJ(64 * 34, 64 * 13, 64 * 4, 64 * 2)); // middle forest fifth chunck
        addObject(new Obstacle_OBJ(64 * 45, 64 * 15, 64 * 2, 64 * 3)); // middle forest sixth chunck
        addObject(new Obstacle_OBJ(64, 64 * 19, 64 * 4, 64)); // river bushes first chunck
        addObject(new Obstacle_OBJ(64 * 8, 64 * 19, 64 * 5, 64)); // river bushes second chunck
        addObject(new Obstacle_OBJ(64 * 13, 64 * 20, 64 * 3, 64)); // river bushes third chunck
        addObject(new Obstacle_OBJ(64 * 20, 64 * 20, 64 * 3, 64)); // river bushes fourth chunck
        addObject(new Obstacle_OBJ(64 * 25, 64 * 20, 64 * 3, 64)); // river bushes fifth chunck
        addObject(new Obstacle_OBJ(64 * 32, 64 * 20, 64 * 3, 64)); // river bushes sixth chunck
        addObject(new Obstacle_OBJ(64 * 35, 64 * 19, 64 * 5, 64)); // river bushes seventh chunck
        addObject(new Obstacle_OBJ(getWidth() - 64 * 5, 64 * 19, 64 * 4, 64)); // river bushes eighth chunck
        addObject(new Obstacle_OBJ(64, 64 * 22, 64 * 2, 64)); // river bushes ninth chunck
        addObject(new Obstacle_OBJ(64 * 10, 64 * 22, 64 * 2, 64)); // river bushes tenth chunck
        addObject(new Obstacle_OBJ(64 * 12, 64 * 23, 64 * 10, 64)); // river bushes eleventh chunck
        addObject(new Obstacle_OBJ(64 * 26, 64 * 23, 64 * 10, 64)); // river bushes twelveth chunck
        addObject(new Obstacle_OBJ(64 * 36, 64 * 22, 64 * 2, 64)); // river bushes thirteenth chunck
        addObject(new Obstacle_OBJ(getWidth() - 64 * 3, 64 * 22, 64 * 2, 64)); // river bushes fourteenth chunck
        addObject(new Obstacle_OBJ(64, 64 * 20, 64 * 12, 64)); // river first chunck
        addObject(new Obstacle_OBJ(64, 64 * 21, 64 * 22, 64)); // river second chunck
        addObject(new Obstacle_OBJ(64 * 12, 64 * 22, 64 * 11, 64)); // river third chunck
        addObject(new Obstacle_OBJ(64 * 25, 64 * 22, 64 * 11, 64)); // river fourth chunck
        addObject(new Obstacle_OBJ(64 * 25, 64 * 21, 64 * 22, 64)); // river fifth chunck
        addObject(new Obstacle_OBJ(getWidth() - 64 * 13, 64 * 20, 64 * 12, 64)); // river sixth chunck
        addObject(new Obstacle_OBJ(64 * 3, 64 * 25, 64, 64 * 6)); // middle rocks west wall
        addObject(new Obstacle_OBJ(64 * 4, 64 * 28, 64 * 2, 64)); // middle rocks first intermediate wall
        addObject(new Obstacle_OBJ(64 * 6, 64 * 25, 64, 64 * 6)); // middle rocks center first wall
        addObject(new Obstacle_OBJ(64 * 7, 64 * 27, 64 * 2, 64)); // middle rocks second intermediate wall
        addObject(new Obstacle_OBJ(64 * 9, 64 * 25, 64, 64 * 6)); // middle rocks center second wall
        addObject(new Obstacle_OBJ(64 * 10, 64 * 28, 64 * 2, 64)); // middle rocks third intermediate wall
        addObject(new Obstacle_OBJ(64 * 12, 64 * 25, 64, 64 * 6)); // middle rocks east wall
        addObject(new Obstacle_OBJ(64 * 21, 64 * 26, 64, 64 * 5)); // bush path west chunck
        addObject(new Obstacle_OBJ(64 * 26, 64 * 26, 64, 64 * 5)); // bush path east chunck
        addObject(new Obstacle_OBJ(64 * 34, 64 * 26, 64, 64)); // graveyard first grave
        addObject(new Obstacle_OBJ(64 * 37, 64 * 26, 64, 64)); // graveyard second grave
        addObject(new Obstacle_OBJ(64 * 40, 64 * 26, 64, 64)); // graveyard third grave
        addObject(new Obstacle_OBJ(64 * 43, 64 * 26, 64, 64)); // graveyard fourth grave
        addObject(new Obstacle_OBJ(64 * 34, 64 * 30, 64, 64)); // graveyard fifth grave
        addObject(new Obstacle_OBJ(64 * 37, 64 * 30, 64, 64)); // graveyard seventh grave
        addObject(new Obstacle_OBJ(64 * 40, 64 * 30, 64, 64)); // graveyard eigth grave
        addObject(new Obstacle_OBJ(64 * 43, 64 * 30, 64, 64)); // graveyard ninth grave
        addObject(new Obstacle_OBJ(64, 64 * 33, 64 * 21, 64)); // south rocks north wall first chunck
        addObject(new Obstacle_OBJ(64 * 26, 64 * 33, 64 * 21, 64)); // south rocks north wall second chunck
        addObject(new Obstacle_OBJ(64 * 11, 64 * 34, 64, 64 * 4)); // south rocks west wall first chunck
        addObject(new Obstacle_OBJ(64 * 11, 64 * 40, 64, 64 * 4)); // south rocks west wall second chunck
        addObject(new Obstacle_OBJ(64 * 36, 64 * 34, 64, 64 * 4)); // south rocks east wall first chunck
        addObject(new Obstacle_OBJ(64 * 36, 64 * 40, 64, 64 * 4)); // south rocks east wall second chunck
        addObject(new Obstacle_OBJ(64, 64 * 34, 64 * 10, 64 * 3)); // southwest lake first chunck
        addObject(new Obstacle_OBJ(64, 64 * 37, 64 * 3, 64 * 4)); // southwest lake second chunck
        addObject(new Obstacle_OBJ(64 * 8, 64 * 37, 64 * 3, 64)); // southwest lake third chunck
        addObject(new Obstacle_OBJ(64 * 8, 64 * 40, 64 * 3, 64)); // southwest lake fourth chunck
        addObject(new Obstacle_OBJ(64, 64 * 41, 64 * 10, 64 * 3)); // southwest lake first chunck
        addObject(new Obstacle_OBJ(64 * 14, 64 * 35, 64 * 21, 64)); // south forest first chunck
        addObject(new Obstacle_OBJ(64 * 14, 64 * 36, 64 * 6, 64)); // south forest second chunck
        addObject(new Obstacle_OBJ(64 * 16, 64 * 37, 64 * 4, 64 * 2)); // south forest third chunck
        addObject(new Obstacle_OBJ(64 * 19, 64 * 39, 64, 64 * 2)); // south forest fourth chunck
        addObject(new Obstacle_OBJ(64 * 28, 64 * 36, 64, 64 * 5)); // south forest fifth chunck
        addObject(new Obstacle_OBJ(64 * 12, 64 * 42, 64 * 2, 64 * 2)); // south forest sixth chunck
        addObject(new Obstacle_OBJ(64 * 19, 64 * 43, 64, 64)); // south forest seventh chunck
        addObject(new Obstacle_OBJ(64 * 28, 64 * 43, 64, 64)); // south forest eighth chunck
        addObject(new Obstacle_OBJ(64 * 31, 64 * 37, 64 * 5, 64)); // south forest ninth chunck
        addObject(new Obstacle_OBJ(64 * 31, 64 * 40, 64 * 5, 64 * 4)); // south forest tenth chunck
        addObject(new Obstacle_OBJ(64 * 22, 64 * 38, 64 * 4, 64 * 4)); // south lake
        addObject(new Obstacle_OBJ(64 * 37, 64 * 34, 64 * 10, 64 * 2)); // southeast lakes first chunck
        addObject(new Obstacle_OBJ(64 * 37, 64 * 36, 64 * 3, 64)); // southeast lakes second chunck
        addObject(new Obstacle_OBJ(64 * 44, 64 * 36, 64 * 3, 64)); // southeast lakes third chunck
        addObject(new Obstacle_OBJ(64 * 37, 64 * 41, 64 * 3, 64)); // southeast lakes fourth chunck
        addObject(new Obstacle_OBJ(64 * 44, 64 * 41, 64 * 3, 64)); // southeast lakes fifth chunck
        addObject(new Obstacle_OBJ(64 * 37, 64 * 42, 64 * 10, 64 * 2)); // southeast lakes sixth chunck
        addObject(new Obstacle_OBJ(64 * 37, 64 * 37, 64 * 3, 64)); // southeast lake bushes first chunck
        addObject(new Obstacle_OBJ(64 * 44, 64 * 37, 64 * 3, 64)); // southeast lake bushes second chunck
        addObject(new Obstacle_OBJ(64 * 37, 64 * 40, 64 * 3, 64)); // southeast lake bushes third chunck
        addObject(new Obstacle_OBJ(64 * 44, 64 * 40, 64 * 3, 64)); // southeast lake bushes fourth chunck
        setCameraTypeFollow(player);
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