package base;

import game.bullet.BulletEnemy;
import game.bullet.BulletPlayer;
import game.enemy.Enemy;
import game.enemy.SpecialEnemy;
import game.player.Player;
import physic.BoxCollider;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameObjectManager {

    public static GameObjectManager instance = new GameObjectManager();

    private List<GameObject> list;
    private List<GameObject> templist;

    private GameObjectManager(){
        this.list = new ArrayList<>();
        this.templist = new ArrayList<>();
    }

    public void add(GameObject gameObject){
        this.templist.add(gameObject);
    }


    public void runAll(){
        this.list.stream()
                .filter(gameObject -> gameObject.isAlive)
                .forEach(gameObject -> gameObject.run());

        this.list.addAll(this.templist);
        this.templist.clear();
    }

    public void renderAll(Graphics graphics){

        this.list.stream()
                .filter(gameObject -> gameObject.isAlive)
                .forEach(gameObject -> gameObject.render(graphics));

    }

    public Player findPlayer(){
        return (Player)this.list
                .stream()
                .filter(gameObject -> gameObject instanceof Player)
                .findFirst().orElse(null);
    }



//    public Enemy checkCollision(BulletPlayer bullet){
//        return (Enemy)this.list
//                .stream()
//                .filter(gameObject -> gameObject.isAlive)
//                .filter(gameObject -> gameObject instanceof Enemy)
//                .filter(gameObject -> {
//                    BoxCollider other = ((Enemy) gameObject).boxCollider;
//                    return bullet.boxCollider.checkBoxCollider(other);
//                })
//                .findFirst()
//                .orElse(null);
//    }
    
    public GameObject checkCollision(GameObject gameObjectCollied){
        if (gameObjectCollied instanceof BulletPlayer) {
            Enemy enemy = (Enemy)this.list
                    .stream()
                    .filter(gameObject -> gameObject.isAlive)
                    .filter(gameObject -> gameObject instanceof Enemy)
                    .filter(gameObject -> {
                        BoxCollider other = ((Enemy) gameObject).boxCollider;
                        return ((BulletPlayer)gameObjectCollied).boxCollider.checkBoxCollider(other);
                    })
                    .findFirst()
                    .orElse(null);
            SpecialEnemy specialEnemy = (SpecialEnemy)this.list
                    .stream()
                    .filter(gameObject -> gameObject.isAlive)
                    .filter(gameObject -> gameObject instanceof SpecialEnemy)
                    .filter(gameObject -> {
                        BoxCollider other = ((SpecialEnemy) gameObject).boxCollider;
                        return ((BulletPlayer)gameObjectCollied).boxCollider.checkBoxCollider(other);
                    })
                    .findFirst()
                    .orElse(null);

            BulletEnemy bulletEnemy = (BulletEnemy) this.list
                    .stream()
                    .filter(gameObject -> gameObject.isAlive)
                    .filter(gameObject -> gameObject instanceof BulletEnemy)
                    .filter(gameObject -> {
                        BoxCollider other = ((BulletEnemy) gameObject).boxCollider;
                        return ((BulletPlayer)gameObjectCollied).boxCollider.checkBoxCollider(other);
                    })
                    .findFirst()
                    .orElse(null);

            if(enemy!= null){
                return enemy;
            }
            if(bulletEnemy!= null){
                return bulletEnemy;
            }
            if(specialEnemy!= null){
                return specialEnemy;
            }
            else return null;
        }

        else if (gameObjectCollied instanceof Player) {
            Enemy enemy = (Enemy)this.list
                    .stream()
                    .filter(gameObject -> gameObject.isAlive)
                    .filter(gameObject -> gameObject instanceof Enemy)
                    .filter(gameObject -> {
                        BoxCollider other = ((Enemy) gameObject).boxCollider;
                        return ((Player)gameObjectCollied).boxCollider.checkBoxCollider(other);
                    })
                    .findFirst()
                    .orElse(null);

            SpecialEnemy specialEnemy = (SpecialEnemy)this.list
                    .stream()
                    .filter(gameObject -> gameObject.isAlive)
                    .filter(gameObject -> gameObject instanceof SpecialEnemy)
                    .filter(gameObject -> {
                        BoxCollider other = ((SpecialEnemy) gameObject).boxCollider;
                        return ((Player)gameObjectCollied).boxCollider.checkBoxCollider(other);
                    })
                    .findFirst()
                    .orElse(null);

            BulletEnemy bulletEnemy = (BulletEnemy) this.list
                    .stream()
                    .filter(gameObject -> gameObject.isAlive)
                    .filter(gameObject -> gameObject instanceof BulletEnemy)
                    .filter(gameObject -> {
                        BoxCollider other = ((BulletEnemy) gameObject).boxCollider;
                        return ((Player)gameObjectCollied).boxCollider.checkBoxCollider(other);
                    })
                    .findFirst()
                    .orElse(null);

            if(enemy!= null){
                return enemy;
            }
            if(bulletEnemy!= null){
                return bulletEnemy;
            }
            if(specialEnemy!= null){
                return specialEnemy;
            }
            else return null;
        }

        else return null;

    }



}