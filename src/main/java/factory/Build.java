package factory;

import background.Background;
import bullets.AlliedBullet;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import sound.Sound;
import vehicles.EnemyNave;
import vehicles.PlayerNave;

public class Build {

    private Build()
    {
    }

    public static Background createBackground(){
        return new Background();
    }

    public static Sound createSound(String path){
        return new Sound(path);
    }

    public static EnemyNave createEnemyNave(){
        return new EnemyNave();
    }

    public static PlayerNave createPlayerNave(){
        return new PlayerNave();
    }

    public static AlliedBullet createBullet(Integer setX, Integer setY, EnemyNave enemyNave){
        return new AlliedBullet(setX,setY,enemyNave);
    }

    public static Picture createPicture(Integer setX, Integer setY, String path){
        return new Picture(setX,setY,path);
    }

}
