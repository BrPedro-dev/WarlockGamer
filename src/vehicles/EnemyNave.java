package vehicles;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class EnemyNave implements Runnable {

    private Picture enemyNave;
    private volatile boolean status = false;
    private boolean status1 = false;
    private int score;

    public EnemyNave() {
        enemyNave = new Picture(200, 30, "enemyShip1.png");
        enemyNave.draw();
    }

    public void Loop() throws InterruptedException {
        int stage = 0;
        if (random(2) == 1) {
            stage = enemyMoveRigth();
        } else {
            stage = enemyMoveLeft();
        }
        while (true) {
            randomMove(stage);
            if (random(10) > 9) {
                stage = inverseMove(stage);
            }
        }
    }

    private int random(int value) {
        return (int) Math.ceil(Math.random() * value);
    }


    private void randomMove(int value) {

        int randomDirection = value;

        switch (randomDirection) {
            case 1:
                try {
                    enemyMoveLeft();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    break;
                }
            case 2:
                try {
                    enemyMoveRigth();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    break;
                }
        }
    }

    public int getXEnemyNave() {
        return enemyNave.getX();
    }

    public int getYEnemyNave() {
        return enemyNave.getY();
    }

    public void deleteEnemy() {
        enemyNave.delete();
        enemyNave.translate(random(100),0);
        status1 = true;
        try {
            score = score + 100;
            Thread.sleep(1000);
            createEnemy();
            enemyNave.draw();
            status1 = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private int enemyMoveLeft() throws InterruptedException {
        if (enemyNave.getX() < 620) {
            Thread.sleep(60);
            enemyNave.translate(15, 0);
            return 2;
        }
        return 1;
    }

    private int enemyMoveRigth() throws InterruptedException {
        if (enemyNave.getX() > 20) {
            Thread.sleep(60);
            enemyNave.translate(-15, 0);
            return 1;
        }
        return 2;
    }

    private int inverseMove(int number) {
        if (number == 1) {
            return 2;
        }
        return 1;
    }

    public boolean getStatus() {
        return status1;
    }

    public void createEnemy(){
        if(random(2) == 1){
            enemyNave.load("enemyShip1.png");
        } else {
            enemyNave.load("enemyShip2.png");
        }
    }

    public int getScore() {
        return score;
    }

    @Override
    public void run() {
        while (!status) {
            try {
                Loop();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

