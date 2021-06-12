package game;

import Sound.Sound;
import background.Background;
import bullets.Bullet;
import bullets.EnemyBullet;
import controller.Controller;
import controller.ControllerMenu;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import vehicles.EnemyNave;
import vehicles.PlayerNave;

public class Game extends Thread {

    private PlayerNave playerNave;
    private EnemyNave enemyNave;
    private Controller controller;
    private Background background;
    private Bullet bullet;
    private EnemyBullet enemyBullet;
    private Text score;
    private Thread t1;
    private Thread t2;
    private Thread t3;
    private Sound menuSound;
    private Sound gameSound;
    private Sound gameOverSound;
    private Sound gameSoundFinal;
    private boolean status = true;

    public Game() {
        menu();
    }

    public void menu() {
        ControllerMenu controller1 = new ControllerMenu(this);
        controller1.init();
        menuSound = new Sound("Musicintro.wav");
        menuSound.play(false);
        menuSound.setLoop(60);
    }

    public void start() {
        menuSound.close();
        gameSound = new Sound("gamesound.wav");
        gameSound.play(false);
        gameSound.setLoop(50);
        background = new Background();
        playerNave = new PlayerNave();
        enemyNave = new EnemyNave();
        bullet = new Bullet(playerNave.getXNave(), playerNave.getXNave(), enemyNave);
        controller = new Controller(playerNave, bullet, enemyNave);
        enemyBullet = new EnemyBullet(playerNave, enemyNave);
        score = new Text(645, 15, Integer.toString(enemyNave.getScore()));
        score.setColor(Color.WHITE);
        score.draw();
        t1 = new Thread(enemyNave);
        t2 = new Thread(enemyBullet);
        t3 = new Thread(this::gameOver);
        t1.start();
        t2.start();
        t3.start();
        controller.init();
    }

    private void gameOver() {
        while (status) {
            score.setText(Integer.toString(enemyNave.getScore()));
            score.draw();
            try {
                Thread.sleep(500);
                if (!playerNave.getStatus()) {
                    background.changeBackground();
                    score.delete();
                    gameSound.close();
                    gameOverSound = new Sound("gameOverSound.wav");
                    gameOverSound.play(false);
                    Thread.sleep(3000);
                    gameSoundFinal = new Sound("gameOverMusicFinal.wav");
                    gameSoundFinal.play(false);
                    status = false;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        gameOver();
    }
}
