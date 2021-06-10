package vehicles;

import org.academiadecodigo.simplegraphics.pictures.Picture;


public class PlayerNave extends vehicles {

    private Picture playerNave;

    public PlayerNave(){
        playerNave = new Picture(200,635, "spacenave.png");
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
        if(playerNave.getX() < 425) {
            playerNave.translate(15, 0);
        }
    }

    @Override
    public void moveLeft() {
        if (playerNave.getX() > 20) {
            playerNave.translate(-15, 0);
            System.out.println(playerNave.getY());
        }
    }

}
