package game.effectObject;

import base.FrameCounter;
import base.GameObject;
import game.player.Player;
import physic.BoxCollider;
import physic.PhysicBody;
import renderer.ImageRenderer;

public class EffectShield extends GameObject implements PhysicBody {
    public BoxCollider boxCollider;
    private FrameCounter frameCounter;
    public EffectShield(){
        this.boxCollider = new BoxCollider(30,30);
        this.renderer =new ImageRenderer("resources-rocket/resources/images/powerup_shield.png",30,30);
        this.frameCounter = new FrameCounter(400);
    }
    public void run(){
        this.boxCollider.position.set(this.position.x-15, this.position.y-15);
        if(this.frameCounter.run()){
            this.isAlive = false;
            this.frameCounter.reset();
        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        if(gameObject instanceof Player){
            this.isAlive = false;
        }

    }
}
