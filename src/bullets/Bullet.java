package bullets;

import sound.Sound;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import vehicles.EnemyNave;

public class Bullet implements Runnable {

    private Picture bullet;
    private EnemyNave enemyNave;
    private Sound bulletSound;

    public Bullet(Integer setX, Integer setY, EnemyNave enemyNave) {
        bullet = new Picture(setX + 40, setY - 35, "resource/bullet(1).png");
        this.enemyNave = enemyNave;
    }

    public void moveBullet() throws InterruptedException {
        bulletSound = new Sound("resource/shotSound.wav");
        bulletSound.play(false);
        while (bullet.getY() > -170) {
            Thread.sleep(40);
            bullet.translate(0, -10);
            if ((enemyNave.getYNave() == bullet.getY() + 20)) {
                    if(bullet.getX() >= enemyNave.getXNave() - 5
                            && bullet.getX() <= enemyNave.getXNave() +85){
                    bullet.delete();
                    enemyNave.deleteEnemy();
                }
            }
        } bullet.delete();
    }

    private void drawBullet() {
        bullet.draw();
    }

    public void run() {
        drawBullet();
        try {
            moveBullet();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        bullet.delete();
    }

}
