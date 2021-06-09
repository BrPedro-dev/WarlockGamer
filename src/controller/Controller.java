package controller;

import bullets.Bullet;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import vehicles.EnemyNave;
import vehicles.PlayerNave;

public class Controller extends Thread implements KeyboardHandler{
    private PlayerNave playerNave;
    private Keyboard keyboard;
    private Bullet bullet;
    private EnemyNave enemyNave;

    public Controller()  {
        keyboard = new Keyboard(this);
        playerNave = new PlayerNave();

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

        enemyNave = new EnemyNave();


        try {
            bullet.moveBullet();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT) {
            playerNave.moveRigth();
        } else if (keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT){
            playerNave.moveLeft();
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE){
            bullet = new Bullet();
            Thread t1 = new Thread(bullet);
            t1.start();
        }
    }

}
