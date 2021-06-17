package background;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Background {

    private Picture picture;

    public Background(){
        picture = new Picture(10,10,"background.png");
        picture.draw();
    }


    public void changeBackground(){
        picture.load("gameOver.png");
        picture.draw();
    }
}
