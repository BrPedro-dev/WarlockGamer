package vehicles;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class EnemyNave implements Runnable{

    private Picture enemyNave;

    public EnemyNave(){
        enemyNave = new Picture(random(200),random(100), "naves.png");
        enemyNave.draw();
    }


    public void Loop() throws InterruptedException {
        while (true){
            Thread.sleep(60);
            randomMove();
        }
    }

    private int random(int value){
        return (int) Math.ceil(Math.random() * value);
    }


    private void randomMove(){

        int randomDirection = random(2);

        switch (randomDirection){
            case 1:
                enemyNave.translate(20,0);
                break;
            case 2:
                enemyNave.translate(-20,0);
                break;
            /*case 3:
                enemyNave.translate(0,10);
                break;
            case 4:
                enemyNave.translate(0,-10);
                break;*/
        }

    }

    public int getXEnemyNave(){
        return enemyNave.getX();
    }

    public int getYEnemyNave(){
        return enemyNave.getY();
    }

    public void moveRigth() {
        return;
    }

    public void moveLeft() {
        return;
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

