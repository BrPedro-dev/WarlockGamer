package bullets;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import vehicles.EnemyNave;

public class Bullet implements Runnable{

    private Picture bullet;
    private EnemyNave enemyNave;

    public Bullet(Integer setX, Integer setY, EnemyNave enemyNave){
        bullet = new Picture(setX + 40,setY - 35,"bullet(1).png");
        this.enemyNave = enemyNave;
    }

    public void moveBullet() throws InterruptedException {
        while (bullet.getY() > -170){
            System.out.println(bullet.getX());
            Thread.sleep(40);
            bullet.translate(0,-10);
            if((enemyNave.getYEnemyNave() == bullet.getY() + 20)
                    && (bullet.getX() - 5 >= enemyNave.getYEnemyNave() &&
                    bullet.getX() <= enemyNave.getXEnemyNave() + 85)){

                enemyNave.deleteEnemy();
                bullet.delete();
            }
        } bullet.delete();
    }

    private void drawBullet(){
        bullet.draw();
    }

    public int getXBullet(){
        return bullet.getX();
    }

    public int getYBullet(){
        return bullet.getY();
    }

    public void run(){
        drawBullet();
        try {
            moveBullet();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
