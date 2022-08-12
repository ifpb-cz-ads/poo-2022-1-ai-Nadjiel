package protozelda.obj.player;

import static java.awt.event.KeyEvent.*;

import protozelda.obj.State;

class Idle implements State {

    private Player_OBJ player;

    public Idle(Player_OBJ player) {
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
        if (
            player.keyIsPressed(VK_UP) ||
            player.keyIsPressed(VK_RIGHT) ||
            player.keyIsPressed(VK_DOWN) ||
            player.keyIsPressed(VK_LEFT)
        ) {
            player.setWalkingState();
        }
    }

    @Override
    public void update() {
        walk();
    }

}