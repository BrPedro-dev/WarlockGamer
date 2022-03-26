package status;

public class StatusManager {

    private static GameStatus gameStatus = GameStatus.RUNNING;
    private static EnemyStatus enemyStatus = EnemyStatus.Dead;
    private static PlayerStatus playerStatus = PlayerStatus.ALIVE;

    private StatusManager(){
    }

    public static GameStatus getState() {
        return gameStatus;
    }

    public static void setState(GameStatus gameStatus) {
        StatusManager.gameStatus = gameStatus;
    }

    public static EnemyStatus getEnemyStatus() {
        return enemyStatus;
    }

    public static void setEnemyStatus(EnemyStatus enemyStatus) {
        if(verify()) {
            StatusManager.enemyStatus = enemyStatus;
        }
    }

    public static PlayerStatus getPlayerStatus() {
        return playerStatus;
    }

    public static void setPlayerStatus(PlayerStatus playerStatus) {
        if(verify()) {
            StatusManager.playerStatus = playerStatus;
        }
    }

    public static boolean alliedIsRunning(){
        return gameStatus == GameStatus.RUNNING && playerStatus == PlayerStatus.ALIVE;
    }

    private static boolean verify()
    {
        return gameStatus == GameStatus.RUNNING;
    }
}
