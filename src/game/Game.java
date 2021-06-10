package game;

import background.Background;
import bullets.Bullet;
import controller.Controller;
import vehicles.EnemyNave;
import vehicles.PlayerNave;

public class Game extends Thread {

    private PlayerNave playerNave;
    private EnemyNave enemyNave;
    private Controller controller;
    private Background background;
    private Bullet bullet;

    public Game() {
        start();
    }

    public void start() {
        background = new Background();
        playerNave = new PlayerNave();
        enemyNave = new EnemyNave();
        bullet = new Bullet(playerNave.getXNave(), playerNave.getXNave(),enemyNave);
        controller = new Controller(playerNave, bullet,enemyNave);
        Thread t1 = new Thread(enemyNave);
        Thread t2 = new Thread(this);
        t1.start();
        controller.init();
    }

    private void checkDestruble() {
        System.out.println(bullet.getXBullet());
        System.out.println(enemyNave.getXEnemyNave());
    }


    public void run() {
        checkDestruble();
    }

}
