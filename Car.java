import java.util.Timer;
import java.util.TimerTask;

public class Car {

    private int speed;
    private int minSpeed;
    private int maxSpeed;
    private double distance;
    private String pilot;

    public Car(){
        speed = 0;
        distance = 0;
    };

    public Car(int minSpeed, int maxSpeed, String pilot) {
        this.speed = 0;
        this.distance = 0;
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

    public String getPilot() {
        return pilot;
    }

    public void setPilot(String pilot) {
        this.pilot = pilot;
    }

    public void run(){
        updateSpeed();
        updateDistance();
    }

    public void updateSpeed(){
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                speed = (int) Math.floor(Math.random() * (maxSpeed - minSpeed + 1) + minSpeed);
                showSpeed();
            }
        };
        timer.schedule(task, 0, 60000);
    }

    public void showSpeed(){
        System.out.println(pilot + " roule maintenant à " + speed + " km/h");
    }

    public void updateDistance(){
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                distance += speed / (0.1 / 3600);
                showDistance();
            }
        };
        timer.schedule(task, 0, 100);
    }

    public void showDistance(){
        System.out.println("distance par parcourue par " + pilot + " : " + distance + " km");
    }
}