package bullets;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import sound.Sound;
import vehicles.EnemyNave;

import java.util.concurrent.TimeUnit;

public class AlliedBullet implements Runnable {

    private final Picture bullet;
    private final EnemyNave enemyNave;
    private final Sound bulletSound = new Sound("resource/shotSound.wav");

    public AlliedBullet(Integer setX, Integer setY, EnemyNave enemyNave) {
        bullet = new Picture(setX + 40, setY - 35, "resource/bullet(1).png");
        this.enemyNave = enemyNave;
    }

    public void moveBullet() throws InterruptedException {

        while (bullet.getY() > 0) {
            TimeUnit.MILLISECONDS.sleep(40);
            bullet.translate(0, -10);
            if (verify()) {
                bullet.delete();
                enemyNave.deleteEnemy();
            }
        }
        bullet.delete();
    }


    private void drawBullet() {
        bullet.draw();
    }

    private boolean verify() {

        final boolean verifyXPosition = bullet.getX() >= enemyNave.getXNave() - 5;
        final boolean verifyYPosition = bullet.getX() <= enemyNave.getXNave() + 85;
        final boolean verifyContactWithBullet = enemyNave.getYNave() == bullet.getY() + 20;

        return verifyContactWithBullet && verifyXPosition && verifyYPosition;
    }

    public void run() {
        try {
            drawBullet();
            bulletSound.play(false);
            moveBullet();
        } catch (InterruptedException e) {
            bullet.delete();
        }
    }

}
