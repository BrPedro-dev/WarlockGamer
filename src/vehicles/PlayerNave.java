package vehicles;

import org.academiadecodigo.simplegraphics.pictures.Picture;


public class PlayerNave extends vehicles {

    private Picture playerNave;
    private Boolean status = true;

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
        if(playerNave.getX() < 620) {
            playerNave.translate(30, 0);
        }
    }

    @Override
    public void moveLeft() {
        if (playerNave.getX() > 20) {
            playerNave.translate(-30, 0);
        }
    }

    public void delete(){
        playerNave.delete();
        status = false;
    }

    public Boolean getStatus() {
        return status;
    }

    public void draw(){
        playerNave.draw();
    }

}
