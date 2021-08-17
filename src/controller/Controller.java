package controller;

import bullets.Bullet;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import vehicles.EnemyNave;
import vehicles.PlayerNave;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Controller implements KeyboardHandler{
    private PlayerNave playerNave;
    private Keyboard keyboard;
    private Bullet bullet;
    private EnemyNave enemyNave;
    private ExecutorService singleExecutor;

    public Controller(PlayerNave playerNave, Bullet bullet, EnemyNave enemyNave)  {
        keyboard = new Keyboard(this);
        this.playerNave = playerNave;
        this.bullet = bullet;
        this.enemyNave = enemyNave;
        singleExecutor = Executors.newSingleThreadExecutor();
    }

    public void init() {

        KeyboardEvent moveRigthEvent = new KeyboardEvent();
        moveRigthEvent.setKey(KeyboardEvent.KEY_RIGHT);
        moveRigthEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(moveRigthEvent);

        KeyboardEvent moveLeftEvent = new KeyboardEvent();
        moveLeftEvent.setKey(KeyboardEvent.KEY_LEFT);
        moveLeftEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(moveLeftEvent);

        KeyboardEvent bulletEvent = new KeyboardEvent();
        bulletEvent.setKey(KeyboardEvent.KEY_SPACE);
        bulletEvent.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(bulletEvent);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT) {
            playerNave.moveRigth(playerNave.getSpeed());
        } else if (keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT){
            playerNave.moveLeft(playerNave.getSpeed());
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE){
            if(playerNave.getStatus()) {
                bullet = new Bullet(playerNave.getXNave(), playerNave.getYNave(), enemyNave);
                Thread t1 = new Thread(bullet);
                //singleExecutor.submit(bullet);
                t1.start();
            }
            //singleExecutor.shutdown();
        }
    }

}
