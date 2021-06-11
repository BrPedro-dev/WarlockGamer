package controller;

import game.Game;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class ControllerMenu implements KeyboardHandler {

    private Keyboard keyboard;
    private Game game;
    private Picture pictures;

    public ControllerMenu(Game game) {
        pictures = new Picture(10,10,"start.png");
        pictures.draw();
        keyboard = new Keyboard(this);
        this.game = game;
    }

    public void init() {

        KeyboardEvent moveSEvent = new KeyboardEvent();
        moveSEvent.setKey(KeyboardEvent.KEY_S);
        moveSEvent.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(moveSEvent);

        KeyboardEvent moveREvent = new KeyboardEvent();
         moveREvent.setKey(KeyboardEvent.KEY_C);
         moveREvent.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener( moveREvent);

        KeyboardEvent bulletEvent = new KeyboardEvent();
        bulletEvent.setKey(KeyboardEvent.KEY_SPACE);
        bulletEvent.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(bulletEvent);

        KeyboardEvent  exitEvent = new KeyboardEvent();
        exitEvent.setKey(KeyboardEvent.KEY_Q);
        exitEvent.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(exitEvent);

    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_C) {
            pictures.load("credits.png");
        } else if (keyboardEvent.getKey() == KeyboardEvent.KEY_S){
            game.start();
        } else if(keyboardEvent.getKey() == KeyboardEvent.KEY_Q){
            System.exit(0);
        }
    }
}
