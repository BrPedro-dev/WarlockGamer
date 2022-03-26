package vehicles;

import random.Randomizer;
import status.GameStatus;
import status.StatusManager;

import java.util.concurrent.TimeUnit;

public class EnemyNave extends Vehicles implements Runnable {

    private int enemyDead;
    private static final int SPEED = 20;
    private long lastMove = System.currentTimeMillis();
    private long newMove = -1;

    public EnemyNave() {
        super(Randomizer.getValue(600), 30, "resource/enemyShip1.png");
        super.draw();
        setDirection();
    }

    private void move() throws InterruptedException {

        Directions direction =  Directions.values()[Randomizer.getValue(2)];

        while (StatusManager.getState() == GameStatus.RUNNING) {

            TimeUnit.MILLISECONDS.sleep(100);
            direction.run();

            if(!delay()){
                lastMove = System.currentTimeMillis();
                continue;
            }

            direction = movementRate(direction);

        }

    }

    private Directions movementRate(Directions direction){

        newMove = System.currentTimeMillis();

        int chanceToSwitchMovement = 50;
        if (Randomizer.getValue(100) < chanceToSwitchMovement) {
            return Directions.values()[Randomizer.getValue(2)];
        }

        return direction;
    }

    private void setDirection(){
        Directions.RIGHT.setRunnable(() -> moveRight(SPEED));
        Directions.LEFT.setRunnable(() -> moveLeft(SPEED));
    }

    public void deleteEnemy() {
        super.delete();
        try {
            enemyDead = enemyDead + 1;
            Thread.sleep(1000);
            changeOfShip();
            super.draw();
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }

    }

    private void changeOfShip() {
        if (Randomizer.getValue(2)== 1) {
            super.changePicture("resource/enemyShip1.png");
        } else {
            super.changePicture("resource/enemyShip2.png");
        }
    }

    public int getEnemyDead() {
        return enemyDead;
    }

    private boolean delay()
    {
        return lastMove - 500 > newMove ;
    }

    @Override
    public void run() {
        try {
            move();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

