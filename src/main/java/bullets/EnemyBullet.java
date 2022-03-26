package bullets;

import random.Randomizer;
import factory.Build;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import status.StatusManager;
import vehicles.EnemyNave;
import vehicles.PlayerNave;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class EnemyBullet implements Runnable {

    private Picture bullet;
    private final PlayerNave playerNave;
    private final EnemyNave enemyNave;
    private final AtomicBoolean status = new AtomicBoolean(true);

    public EnemyBullet(PlayerNave playerNave, EnemyNave enemyNave) {
        this.enemyNave = enemyNave;
        this.playerNave = playerNave;
    }

    public void moveBullet() throws InterruptedException {

        while (bullet.getY() < 650) {

            TimeUnit.MILLISECONDS.sleep(20);
            bullet.translate(0, 10);

            if (verifyContactWithPlayer()) {
                bullet.delete();
                playerNave.delete();
            }
        }

        bullet.delete();
    }


    private boolean verifyContactWithPlayer() {

        final boolean verifyXPosition = bullet.getX() >= playerNave.getXNave() - 5;
        final boolean verifyYPosition = bullet.getX() <= playerNave.getXNave() + 85;
        final boolean verifyContactWithBullet = (playerNave.getYNave() == bullet.getY() + 20);

        return verifyContactWithBullet && verifyXPosition && verifyYPosition;
    }

    private boolean verify() {
        return StatusManager.alliedIsRunning() && (Randomizer.getValue(10) > 7);
    }

    private void drawBullet() {
        bullet = Build.createPicture(enemyNave.getXNave() + 40, enemyNave.getYNave() + 35,
                "resource/Ohb8MN (1) (1).png");
        bullet.draw();
    }

    public void run() {
        while (status.get()) {
            if (verify()) {
                try {
                    drawBullet();
                    moveBullet();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
