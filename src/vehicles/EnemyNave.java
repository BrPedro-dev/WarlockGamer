package vehicles;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class EnemyNave implements Runnable {

    private Picture enemyNave;

    public EnemyNave() {
        enemyNave = new Picture(200, 30, "AlienNave.png");
        enemyNave.draw();
        System.out.println(enemyNave.getX() + " " + enemyNave.getY());
    }

    public void Loop() throws InterruptedException {
        while (true) {
            Thread.sleep(60);
            randomMove();
        }
    }

    private int random(int value) {
        return (int) Math.ceil(Math.random() * value);
    }

    private void randomMove() {

        int randomDirection = random(0);

        switch (randomDirection) {
            case 1:
                if (enemyNave.getX() < 420) {
                    enemyNave.translate(20, 0);
                }
                break;
            case 2:
                if (enemyNave.getX() > 20) {
                    enemyNave.translate(-20, 0);
                }
                break;
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

