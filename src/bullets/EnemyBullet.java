package bullets;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import vehicles.EnemyNave;
import vehicles.PlayerNave;

public class EnemyBullet implements Runnable {
    private Picture bullet;
    private PlayerNave playerNave;
    private EnemyNave enemyNave;
    private Boolean status;

    public EnemyBullet(PlayerNave playerNave, EnemyNave enemyNave) {
        this.enemyNave = enemyNave;
        this.playerNave = playerNave;
    }

    public void moveBullet() throws InterruptedException {
        bullet = new Picture(enemyNave.getXEnemyNave() + 40, enemyNave.getYEnemyNave() + 35, "Ohb8MN (1) (1).png");
        while (bullet.getY() < 650) {
            drawBullet();
            Thread.sleep(15);
            bullet.translate(0, 10);
            if ((playerNave.getYNave() == bullet.getY() + 20)) {
                if (bullet.getX() >= playerNave.getXNave() - 5
                        && bullet.getX() <= playerNave.getXNave() + 85) {
                    bullet.delete();
                    playerNave.delete();
                }
            }
        }
        bullet.delete();
    }

    private void drawBullet() {
        bullet.draw();
    }

    public void run() {
        while (true) {
            if (playerNave.getStatus()) {
                if ((int) Math.ceil(Math.random() * 10) > 2) {
                    try {
                        moveBullet();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }
}
