package vehicles;

import factory.Build;
import interfaces.Moves;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Vehicles implements Moves {

    private Picture picture;

    public Vehicles(Integer setX, Integer setY, String path){
        picture = Build.createPicture(setX, setY, path);
    }

    @Override
    public void moveRigth(Integer speed) {
        if(picture.getX() < 620) {
            picture.translate(speed, 0);
        }
    }

    @Override
    public void moveLeft(Integer speed) {
        if (picture.getX() > 30) {
            picture.translate(-speed, 0);
        }
    }

    public void draw(){
        picture.draw();
    }

    public int getXNave(){
        return picture.getX();
    }

    public int getYNave(){
        return picture.getY();
    }

    public void delete(){
        picture.delete();
    }

    public void changePicture(String pahth){
        picture.load(pahth);
    }

}
