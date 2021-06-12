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
    private int status = 0;

    public ControllerMenu(Game game) {
        pictures = new Picture(10,10,"start.png");
        pictures.draw();
        keyboard = new Keyboard(this);
        this.game = game;
    }

    public void init() {

        KeyboardEvent startEvent = new KeyboardEvent();
        startEvent.setKey(KeyboardEvent.KEY_S);
        startEvent.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(startEvent);

        KeyboardEvent credistEvent = new KeyboardEvent();
         credistEvent.setKey(KeyboardEvent.KEY_C);
         credistEvent.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener( credistEvent);

        KeyboardEvent rulesEvent = new KeyboardEvent();
        rulesEvent.setKey(KeyboardEvent.KEY_R);
        rulesEvent.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(rulesEvent);

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
            pictures.load("CreditsFInal.png");
        } else if (keyboardEvent.getKey() == KeyboardEvent.KEY_S && status == 0){
            status = status + 1;
            game.start();
        } else if(keyboardEvent.getKey() == KeyboardEvent.KEY_Q){
            System.exit(0);
        } else if (keyboardEvent.getKey() == KeyboardEvent.KEY_R){
            pictures.load("rules.png");
        }
    }
}
