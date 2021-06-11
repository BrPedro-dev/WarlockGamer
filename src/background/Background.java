package background;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Background {

    private Picture picture;

    public Background(){
        picture = new Picture(10,10,"background.png");
        picture.draw();
    }


    public void changeBackground(){
        picture.load("gameover.png");
        picture.draw();
    }
}
