package vehicles;

import Random.Random;

public class PlayerNave extends Vehicles {

    private Boolean status = true;
    private Integer speed = 30;

    public PlayerNave(){
        super(Random.randomizer(400),635, "resource/spacenave.png");
        super.draw();
    }

    public void delete(){
        super.delete();
        status = false;
    }

    public Boolean getStatus() {
        return status;
    }

    public Integer getSpeed() {
        return speed;
    }
}
