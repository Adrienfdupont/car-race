import java.util.Timer;
import java.util.TimerTask;

public class Car {

    private int speed = 0;
    private int minSpeed;
    private int maxSpeed;
    private double distance = 0;

    private boolean running;
    private String pilot;
    public Car(){};

    public Car(int minSpeed, int maxSpeed, String pilot) {
        this.minSpeed = minSpeed;
        this.maxSpeed = maxSpeed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getMinSpeed() {
        return minSpeed;
    }

    public void setMinSpeed(int minSpeed) {
        this.minSpeed = minSpeed;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public String getPilot() {
        return pilot;
    }

    public void setPilot(String pilot) {
        this.pilot = pilot;
    }

    public void run(){
        running = true;
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                updateSpeed();
                updateDistance();
            }
        };
        timer.schedule(task, 0, 60000);
    }

    public void updateSpeed(){
        speed = (int) Math.floor(Math.random() * (maxSpeed - minSpeed + 1) + minSpeed);
        showSpeed();
    }

    public void showSpeed(){
        System.out.println(speed);
    }

    public void updateDistance(){
        distance = distance + speed / 60;
    }
}