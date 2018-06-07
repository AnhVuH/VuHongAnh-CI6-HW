package game.bullet;


import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.enemy.Enemy;
import physic.BoxCollider;
import renderer.ImageRenderer;

import java.awt.*;

public class BulletPlayer extends GameObject {

    public Vector2D velocity;
    public BoxCollider boxCollider;


    public BulletPlayer() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources-rocket/resources/images/circle.png", 4, 4);
        this.boxCollider = new BoxCollider(6, 6);
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position.x - 3, this.position.y - 3);
        if(GameObjectManager.instance.checkCollision(this) !=null)
        {
            GameObjectManager.instance.checkCollision(this).isAlive =false;
            this.isAlive =false;
        }

//        Enemy enemy = GameObjectManager.instance.checkCollision(this);
//
//        if (enemy != null) {
//            enemy.isAlive = false;
//            this.isAlive = false;
//        }

    }
}