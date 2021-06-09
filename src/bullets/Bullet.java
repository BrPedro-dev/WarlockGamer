package bullets;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Bullet implements Runnable{
    Picture picture;

    public Bullet(){
        picture = new Picture(0,500,"bullet.png");
        picture.draw();
    }

    public void moveBullet() throws InterruptedException {
        while (picture.getY() > -170){
            Thread.sleep(80);
            picture.translate(0,-10);
        } picture.delete();
    }

    public void run(){
        try {
            moveBullet();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
