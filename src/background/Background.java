package background;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Background {

    private Picture picture;

    public Background(){
        picture = new Picture(10,10,"Sky_background.png");
        picture.draw();
    }

    public int getWidth(){
        return picture.getWidth();
    }

}
