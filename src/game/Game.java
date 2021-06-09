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

    public Game() throws InterruptedException {
        background = new Background();
        controller = new Controller();
        //enemyNave = new EnemyNave();
        //bullet = new Bullet();
        Thread t1 = new Thread(enemyNave);
        t1.start();
        Thread t2 = new Thread(bullet);
        t2.start();
        controller.init();
    }
}
