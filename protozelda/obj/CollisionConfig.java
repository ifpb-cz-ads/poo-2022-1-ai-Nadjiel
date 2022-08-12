package protozelda.obj;

public class CollisionConfig {
    
    private boolean solid;

    public CollisionConfig() {
        this(true);
    }

    public CollisionConfig(boolean solid) {
        setSolid(solid);
    }

    public void setSolid(boolean solid) {
        this.solid = solid;
    }

    public boolean getSolid() {
        return this.solid;
    }

}