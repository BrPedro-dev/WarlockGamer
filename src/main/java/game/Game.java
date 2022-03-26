package game;

import factory.Build;
import sound.Sound;
import background.Background;
import bullets.AlliedBullet;
import bullets.EnemyBullet;
import controller.Controller;
import controller.ControllerMenu;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import status.PlayerStatus;
import status.StatusManager;
import vehicles.EnemyNave;
import vehicles.PlayerNave;

public class Game implements Runnable{

    private PlayerNave playerNave;
    private EnemyNave enemyNave;
    private Controller controller;
    private Background background;
    private AlliedBullet AlliedBullet;
    private EnemyBullet enemyBullet;
    private Text score;
    private Thread t1;
    private Thread t2;
    private Thread t3;
    private Sound gameSoundFinal;
    private boolean status = true;
    private Sound introSound;
    private Sound mainSound;
    private Sound finalSound;

    public Game() {
        menu();
    }

    public void menu() {
        ControllerMenu controller1 = new ControllerMenu(this);
        controller1.init();
        introSound = new Sound("resource/Musicintro.wav");
        playSound(introSound);
    }

    public void start() {
        stopSound(introSound);
        mainSound = new Sound("resource/gamesound.wav");
        playSound(mainSound);
        background = Build.createBackground();
        playerNave = Build.createPlayerNave();
        enemyNave = Build.createEnemyNave();
        AlliedBullet = Build.createBullet(playerNave.getXNave(), playerNave.getXNave(), enemyNave);
        controller = new Controller(playerNave, AlliedBullet, enemyNave);
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
                if (StatusManager.getPlayerStatus() == PlayerStatus.DEAD) {
                    background.changeBackground();
                    score.delete();
                    stopSound(mainSound);
                    finalSound = new Sound("resource/gameOverSound.wav");
                    playSound(finalSound);
                    Thread.sleep(2500);
                    gameSoundFinal = new Sound("resource/gameOverMusic.wav");
                    gameSoundFinal.play(false);
                    playSound(gameSoundFinal);
                    status = false;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void playSound(Sound sound){
        sound.play(false);
        sound.setLoop(100);
    }

    private void stopSound(Sound sound){
        sound.stop();
    }

    @Override
    public void run() {
        gameOver();
    }
}
