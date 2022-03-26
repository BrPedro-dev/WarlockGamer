package controller;

import bullets.AlliedBullet;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import status.StatusManager;
import vehicles.EnemyNave;
import vehicles.PlayerNave;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Controller implements KeyboardHandler {
    private final PlayerNave playerNave;
    private final Keyboard keyboard;
    private AlliedBullet alliedBullet;
    private final EnemyNave enemyNave;
    private final ExecutorService singleExecutor;
    private long lastKeyReleased = System.currentTimeMillis();
    private long newKeyReleased = -1;

    public Controller(PlayerNave playerNave, AlliedBullet alliedBullet, EnemyNave enemyNave) {
        keyboard = new Keyboard(this);
        this.playerNave = playerNave;
        this.alliedBullet = alliedBullet;
        this.enemyNave = enemyNave;
        singleExecutor = Executors.newCachedThreadPool();
    }

    public void init() {

        setKeyboardEvent(KeyboardEventType.KEY_PRESSED, KeyboardEvent.KEY_RIGHT);
        setKeyboardEvent(KeyboardEventType.KEY_PRESSED, KeyboardEvent.KEY_LEFT);
        setKeyboardEvent(KeyboardEventType.KEY_RELEASED, KeyboardEvent.KEY_SPACE);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT) {
            playerNave.moveRight(playerNave.getSpeed());
        } else if (keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT) {
            playerNave.moveLeft(playerNave.getSpeed());
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        if(!delay())
        {
            lastKeyReleased = System.currentTimeMillis();
            return;
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE && StatusManager.alliedIsRunning()) {
            alliedBullet = new AlliedBullet(playerNave.getXNave(), playerNave.getYNave(), enemyNave);
            singleExecutor.submit(alliedBullet);
            newKeyReleased = System.currentTimeMillis();
        }
    }

    private boolean delay()
    {
        return lastKeyReleased - 20 > newKeyReleased;
    }

    private void setKeyboardEvent(KeyboardEventType keyboardEventType, int key)
    {
        final KeyboardEvent keyboardEvent = new KeyboardEvent();
        keyboardEvent.setKey(key);
        keyboardEvent.setKeyboardEventType(keyboardEventType);
        keyboard.addEventListener(keyboardEvent);
    }

}
