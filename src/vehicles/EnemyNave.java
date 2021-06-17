package vehicles;

import Random.Random;

public class EnemyNave extends Vehicles implements Runnable {

    private int enemyDead;
    private int speed = 15;
    private int chanceToSwitchMovement = 5;

    public EnemyNave() {
        super(Random.randomizer(600), 30, "enemyShip1.png");
        super.draw();
    }

    public void Loop() throws InterruptedException {
        int stage = 0;
        while (true) {
            if (stage == 0) {
                try {
                    Thread.sleep(100);
                    super.moveLeft(speed);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    stage = movementRate(stage);
                }
            } else if (stage == 1) {
                try {
                    Thread.sleep(100);
                    super.moveRigth(speed);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    stage = movementRate(stage);
                }

            }
        }
    }

    private Integer movementRate(Integer stage){
        Integer random = Random.randomizer(100);
        if (random < chanceToSwitchMovement) {
            if(stage == 1){
                System.out.println();
                return 0;
            } return 1;
        } return stage;
    }

    public void deleteEnemy() {
        super.delete();
        try {
            enemyDead = enemyDead + 1;
            Thread.sleep(1000);
            createEnemy();
            super.draw();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void createEnemy() {
        if (Random.randomizer(2)== 1) {
            super.changePicture("enemyShip1.png");
        } else {
            super.changePicture("enemyShip2.png");
        }
    }

    public int getEnemyDead() {
        return enemyDead;
    }

    @Override
    public void run() {
        try {
            Loop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

