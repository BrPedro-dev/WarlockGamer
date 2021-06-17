package game;

import factory.Build;
import sound.Sound;
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
    private Sound gameSoundFinal;
    private boolean status = true;

    public Game() {
        menu();
    }

    public void menu() {
        ControllerMenu controller1 = new ControllerMenu(this);
        controller1.init();
        playSound("Musicintro.wav");
    }

    public void start() {
        playSound("gamesound.wav");
        background = Build.createBackground();
        playerNave = Build.createPlayerNave();
        enemyNave = Build.createEnemyNave();
        bullet = Build.createBullet(playerNave.getXNave(), playerNave.getXNave(), enemyNave);
        controller = new Controller(playerNave, bullet, enemyNave);
        enemyBullet = new EnemyBullet(playerNave, enemyNave);
        score = new Text(645, 15, Integer.toString(enemyNave.getEnemyDead()));
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
            score.setText(Integer.toString(enemyNave.getEnemyDead()));
            score.draw();
            try {
                Thread.sleep(500);
                if (!playerNave.getStatus()) {
                    background.changeBackground();
                    score.delete();
                    playSound("gameOverSound.wav");
                    Thread.sleep(2500);
                    gameSoundFinal = new Sound("gameOverMusic.wav");
                    gameSoundFinal.play(false);
                    status = false;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void playSound(String path){
        Sound sound = Build.createSound(path);
        sound.play(false);
        sound.setLoop(100);
    }

    @Override
    public void run() {
        gameOver();
    }
}
