public class Car {

    private static final int speedInterval = 60;
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
        this.pilot = pilot;
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

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getPilot() {
        return pilot;
    }

    public void setPilot(String pilot) {
        this.pilot = pilot;
    }

    public void update(int frame, double totalSeconds, double secondPerFrame){
        if (frame == 1 || totalSeconds % Car.speedInterval == 0){
            changeSpeed();
        }
        calculateDistance(secondPerFrame);
    }

    public void changeSpeed(){
        setSpeed((int) Math.floor(Math.random() * (getMaxSpeed() - getMinSpeed() + 1) + getMinSpeed()));
        showSpeed();
    }

    public void calculateDistance(double secondPerFrame){
        double frameDistance = secondPerFrame * getSpeed() / 3600.0;
        setDistance(getDistance() + frameDistance);
    }

    public void showDistance(){
        System.out.println("distance par parcourue par " + getPilot() + " : " + round(getDistance()) + " km");
    }

    public void showSpeed(){
        System.out.println("----------------------------------------------");
        System.out.println(pilot + " roule maintenant à " + getSpeed() + " km/h");
        System.out.println("----------------------------------------------");
    }

    public static double round(double value) {
        long factor = (long) Math.pow(10, 2);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}