package protozelda.obj.player;

import static java.awt.event.KeyEvent.*;

import protozelda.obj.State;
import protozelda.ProtoZelda;

class Walking implements State {

    private Player_OBJ player;

    public Walking(Player_OBJ player) {
        storePlayer(player);
    }

    private void storePlayer(Player_OBJ player) {
        if(player == null) {
            throw new IllegalArgumentException (
                "player == null!"
            );
        }
        
        this.player = player;
    }

    private void walk() {
        if(player.keyIsPressed(VK_UP)) {
            player.setYSpeed(-5);
            player.setDirection(Player_OBJ.UP);
        }
        if(player.keyIsPressed(VK_RIGHT)) {
            player.setXSpeed(5);
            player.setDirection(Player_OBJ.RIGHT);
        }
        if(player.keyIsPressed(VK_DOWN)) {
            player.setYSpeed(5);
            player.setDirection(Player_OBJ.DOWN);
        }
        if(player.keyIsPressed(VK_LEFT)) {
            player.setXSpeed(-5);
            player.setDirection(Player_OBJ.LEFT);
        }
    }

    private void stop() {
        // Stop for lack of input
        if (
            !player.keyIsPressed(VK_UP) &&
            !player.keyIsPressed(VK_DOWN)
        ) {
            player.setYSpeed(0);
        }
        if (
            !player.keyIsPressed(VK_RIGHT) &&
            !player.keyIsPressed(VK_LEFT)
        ) {
            player.setXSpeed(0);
        }

        // Go to idle state
        if (
            player.getYSpeed() == 0 &&
            player.getXSpeed() == 0
        ) {
            player.setIdleState();
        }
    }

    private void animate() {
        ProtoZelda game = (ProtoZelda) player.getGame();

        if(game == null) {
            player.nextFrameX();
            return;
        }
        
        if (
            game.getFrameCount() % ProtoZelda.ANIMATION_INTERVAL == 0
        ) {
            player.nextFrameX();
        }
    }

    private void attack() {
        if(player.keyIsPressed(VK_X)) {
            player.setXSpeed(0);
            player.setYSpeed(0);
        }
    }

    @Override
    public void update() {
        walk();
        animate();
        stop();
        attack();
    }

}