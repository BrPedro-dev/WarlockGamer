package vehicles;

import background.Background;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class PlayerNave extends vehicles {

    private Picture playerNave;
    private Background background;

    public PlayerNave(){
        background = new Background();
        playerNave = new Picture(200,530, "airplane (2).png");
        playerNave.draw();
    }

    public int getXNave(){
        return playerNave.getX();
    }

    public int getYNave(){
        return playerNave.getY();
    }

    @Override
    public void moveRigth() {
        if(background.getWidth() > playerNave.getX() + 156) {
            playerNave.translate(30, 0);
            System.out.println(playerNave.getX());
        }
    }

    @Override
    public void moveLeft() {
        if (playerNave.getX() > 20) {
            playerNave.translate(-30, 0);
            System.out.println(playerNave.getY());
        }
    }

}
