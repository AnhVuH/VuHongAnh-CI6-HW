import java.awt.*;

public class SpecialEnemy  extends GameObject{

    public Vector2D velocity;

    private EnemyShoot enemyShoot;
    public SpecialEnemy(){
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources-rocket/resources/images/circle.png",20,20);
        this.enemyShoot = new EnemyShoot();
    }

    @Override
    public void run(){
        super.run();
        this.position.addUp(this.velocity);
        this.enemyShoot.run(this);
        this.enemyShoot.bulletEnemies.forEach(bulletEnemy -> bulletEnemy.run());

    }

    @Override
    public void render(Graphics graphics){
        super.render(graphics);
        this.enemyShoot.bulletEnemies.forEach(bulletEnemy -> bulletEnemy.render(graphics));

    }
}