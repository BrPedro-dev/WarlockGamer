package vehicles;

public enum Directions implements Runnable {
    RIGHT("Right", () -> System.out.println("Right")),
    LEFT("Left", () -> System.out.println("Left"));

    private Runnable runnable;
    private final String direction;

    Directions(final String direction,final Runnable runnable){
        this.direction = direction;
        this.runnable = runnable;
    }

     String getDirection() {
        return direction;
    }

    void setRunnable(Runnable runnable) {
        this.runnable = runnable;
    }

    @Override
    public void run() {
        runnable.run();
    }
}
