package background;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Background {

    private final Picture picture;

    public Background() {
        picture = new Picture(10, 10, "resource/background.png");
        picture.draw();
    }


    public void changeBackground() {
        picture.load("resource/gameOver.png");
        picture.draw();
    }
}
