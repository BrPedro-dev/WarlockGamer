package vehicles;

import random.Randomizer;
import status.PlayerStatus;
import status.StatusManager;

public class PlayerNave extends Vehicles {

    private Integer speed = 30;

    public PlayerNave(){
        super(Randomizer.getValue(400),635, "resource/spacenave.png");
        super.draw();
    }

    @Override
    public void delete(){
        super.delete();
        StatusManager.setPlayerStatus(PlayerStatus.DEAD);
    }

    public Integer getSpeed() {
        return speed;
    }
}
